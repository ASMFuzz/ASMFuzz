@@ -33,6 +33,11 @@
 import javax.naming.directory.Attributes;
 import javax.naming.ldap.Control;
 
+import java.lang.invoke.VarHandle;
+import java.lang.ref.Cleaner.Cleanable;
+import java.lang.ref.Reference;
+import jdk.internal.ref.CleanerFactory;
+
 /**
  * Basic enumeration for NameClassPair, Binding, and SearchResults.
  */
@@ -42,17 +47,60 @@ abstract class AbstractLdapNamingEnumeration<T extends NameClassPair>
 
     protected Name listArg;
 
-    private boolean cleaned = false;
-    private LdapResult res;
-    private LdapClient enumClnt;
     private Continuation cont;  // used to fill in exceptions
     private Vector<LdapEntry> entries = null;
     private int limit = 0;
     private int posn = 0;
-    protected LdapCtx homeCtx;
+
     private LdapReferralException refEx = null;
     private NamingException errEx = null;
 
+    /* This class maintains the pieces of state that need to be cleaned up (or
+     * are needed for cleanup). It gets registered with Cleaner to perform cleanup.
+     *
+     * reachabilityFences are used to ensure that an AbstractLdapNamingEnumeration
+     * instance does not become unreachable while one of its methods is still
+     * executing (possibly leading to EnumCtx being cleaned up while it's still in use).
+     *
+     * Because the state is mutable, fullFence() is used to ensure that changes
+     * made on the main/program thread are seen by the cleanup thread.
+     */
+    private static class EnumCtx implements Runnable {
+        private LdapCtx homeCtx;
+        private LdapResult res;
+        private LdapClient enumClnt;
+
+        private EnumCtx(LdapCtx homeCtx, LdapResult answer, LdapClient client) {
+            this.homeCtx = homeCtx;
+            this.res = answer;
+            this.enumClnt = client;
+        }
+
+        @Override
+        public void run() {
+            // Ensure changes on the main/program thread happens-before cleanup
+            VarHandle.fullFence();
+
+            if (enumClnt != null) {
+                if (homeCtx != null) {
+                    enumClnt.clearSearchReply(res, homeCtx.reqCtls);
+                }
+                enumClnt = null;
+            }
+            if (homeCtx != null) {
+                homeCtx.decEnumCount();
+                homeCtx = null;
+            }
+        }
+    }
+
+    private final EnumCtx enumCtx;
+    private final Cleanable cleanable;
+
+    // Subclasses interact directly with the LdapCtx. This method provides
+    // access to the LdapCtx within the EnumCtx.
+    protected final LdapCtx getHomeCtx() { return enumCtx.homeCtx; }
+
     /*
      * Record the next set of entries and/or referrals.
      */
@@ -84,7 +132,6 @@ abstract class AbstractLdapNamingEnumeration<T extends NameClassPair>
 
             // otherwise continue
 
-            res = answer;
             entries = answer.entries;
             limit = (entries == null) ? 0 : entries.size(); // handle empty set
             this.listArg = listArg;
@@ -94,16 +141,38 @@ abstract class AbstractLdapNamingEnumeration<T extends NameClassPair>
                 refEx = answer.refEx;
             }
 
+            this.enumCtx = new EnumCtx(homeCtx, answer, homeCtx.clnt);
             // Ensures that context won't get closed from underneath us
-            this.homeCtx = homeCtx;
-            homeCtx.incEnumCount();
-            enumClnt = homeCtx.clnt; // remember
+            this.enumCtx.homeCtx.incEnumCount();
+            this.cleanable = CleanerFactory.cleaner().register(this, this.enumCtx);
+            // For finalizers, JLS guarantees that the constructor of a finalizeable
+            // class will complete before the finalizer is run. Classes that use
+            // Cleaner instead don't currently have such a guarantee.
+
+            // 'this' needs to stay reachable until registration with Cleaner
+            // completes, to ensure that the cleanable state that has been created
+            // will eventually be cleaned up. Within Cleaner.register(), there
+            // are reachability fences to ensure that the registered object remains
+            // reachable.
+            // TODO: Is anything else needed so that this constructor
+            //  "happens-before" the cleaning action ?
     }
 
     @Override
     public final T nextElement() {
         try {
-            return next();
+            try {
+                return next();
+            } finally {
+                // See comment in nextImpl(). This is similar, but in this case, next()
+                // *is* overridable. Fences are included here, in case next() is
+                // overridden to access the cleanable state without the proper fences.
+
+                // Ensure writes are visible to the Cleaner thread
+                VarHandle.fullFence();
+                // Ensure Cleaner does not run until after this method completes
+                Reference.reachabilityFence(this);
+            }
         } catch (NamingException e) {
             // can't throw exception
             cleanup();
@@ -114,7 +183,16 @@ public final T nextElement() {
     @Override
     public final boolean hasMoreElements() {
         try {
-            return hasMore();
+            try {
+                return hasMore();
+            } finally {
+                // Same situation as nextElement() - see comment above
+
+                // Ensure writes are visible to the Cleaner thread
+                VarHandle.fullFence();
+                // Ensure Cleaner does not run until after this method completes
+                Reference.reachabilityFence(this);
+            }
         } catch (NamingException e) {
             // can't throw exception
             cleanup();
@@ -126,45 +204,51 @@ public final boolean hasMoreElements() {
      * Retrieve the next set of entries and/or referrals.
      */
     private void getNextBatch() throws NamingException {
+        try {
+            enumCtx.res = enumCtx.homeCtx.getSearchReply(enumCtx.enumClnt, enumCtx.res);
+            if (enumCtx.res == null) {
+                limit = posn = 0;
+                return;
+            }
 
-        res = homeCtx.getSearchReply(enumClnt, res);
-        if (res == null) {
-            limit = posn = 0;
-            return;
-        }
-
-        entries = res.entries;
-        limit = (entries == null) ? 0 : entries.size(); // handle empty set
-        posn = 0; // reset
+            entries = enumCtx.res.entries;
+            limit = (entries == null) ? 0 : entries.size(); // handle empty set
+            posn = 0; // reset
 
-        // minimize the number of calls to processReturnCode()
-        // (expensive when batchSize is small and there are many results)
-        if ((res.status != LdapClient.LDAP_SUCCESS) ||
-            ((res.status == LdapClient.LDAP_SUCCESS) &&
-                (res.referrals != null))) {
+            // minimize the number of calls to processReturnCode()
+            // (expensive when batchSize is small and there are many results)
+            if ((enumCtx.res.status != LdapClient.LDAP_SUCCESS) ||
+                ((enumCtx.res.status == LdapClient.LDAP_SUCCESS) &&
+                    (enumCtx.res.referrals != null))) {
 
-            try {
-                // convert referrals into a chain of LdapReferralException
-                homeCtx.processReturnCode(res, listArg);
+                try {
+                    // convert referrals into a chain of LdapReferralException
+                    enumCtx.homeCtx.processReturnCode(enumCtx.res, listArg);
 
-            } catch (LimitExceededException | PartialResultException e) {
-                setNamingException(e);
+                } catch (LimitExceededException | PartialResultException e) {
+                    setNamingException(e);
 
+                }
             }
-        }
 
-        // merge any newly received referrals with any current referrals
-        if (res.refEx != null) {
-            if (refEx == null) {
-                refEx = res.refEx;
-            } else {
-                refEx = refEx.appendUnprocessedReferrals(res.refEx);
+            // merge any newly received referrals with any current referrals
+            if (enumCtx.res.refEx != null) {
+                if (refEx == null) {
+                    refEx = enumCtx.res.refEx;
+                } else {
+                    refEx = refEx.appendUnprocessedReferrals(enumCtx.res.refEx);
+                }
+                enumCtx.res.refEx = null; // reset
             }
-            res.refEx = null; // reset
-        }
 
-        if (res.resControls != null) {
-            homeCtx.respCtls = res.resControls;
+            if (enumCtx.res.resControls != null) {
+                enumCtx.homeCtx.respCtls = enumCtx.res.resControls;
+            }
+        } finally {
+            // Ensure writes are visible to the Cleaner thread
+            VarHandle.fullFence();
+            // Ensure Cleaner does not run until after this method completes
+            Reference.reachabilityFence(this);
         }
     }
 
@@ -176,17 +260,23 @@ private void getNextBatch() throws NamingException {
      */
     @Override
     public final boolean hasMore() throws NamingException {
+        try {
+            if (hasMoreCalled) {
+                return more;
+            }
 
-        if (hasMoreCalled) {
-            return more;
-        }
-
-        hasMoreCalled = true;
+            hasMoreCalled = true;
 
-        if (!more) {
-            return false;
-        } else {
-            return (more = hasMoreImpl());
+            if (!more) {
+                return false;
+            } else {
+                return (more = hasMoreImpl());
+            }
+        } finally {
+            // Ensure writes are visible to the Cleaner thread
+            VarHandle.fullFence();
+            // Ensure Cleaner does not run until after this method completes
+            Reference.reachabilityFence(enumCtx);
         }
     }
 
@@ -195,49 +285,62 @@ public final boolean hasMore() throws NamingException {
      */
     @Override
     public final T next() throws NamingException {
-
-        if (!hasMoreCalled) {
-            hasMore();
+        try {
+            if (!hasMoreCalled) {
+                hasMore();
+            }
+            hasMoreCalled = false;
+            return nextImpl();
+        } finally {
+            // Ensure writes are visible to the Cleaner thread
+            VarHandle.fullFence();
+            // Ensure Cleaner does not run until after this method completes
+            Reference.reachabilityFence(enumCtx);
         }
-        hasMoreCalled = false;
-        return nextImpl();
     }
 
     /*
      * Test if unprocessed entries or referrals exist.
      */
     private boolean hasMoreImpl() throws NamingException {
-        // when page size is supported, this
-        // might generate an exception while attempting
-        // to fetch the next batch to determine
-        // whether there are any more elements
-
-        // test if the current set of entries has been processed
-        if (posn == limit) {
-            getNextBatch();
-        }
-
-        // test if any unprocessed entries exist
-        if (posn < limit) {
-            return true;
-        } else {
-
-            try {
-                // try to process another referral
-                return hasMoreReferrals();
+        try {
+            // when page size is supported, this
+            // might generate an exception while attempting
+            // to fetch the next batch to determine
+            // whether there are any more elements
+
+            // test if the current set of entries has been processed
+            if (posn == limit) {
+                getNextBatch();
+            }
 
-            } catch (LdapReferralException |
-                     LimitExceededException |
-                     PartialResultException e) {
-                cleanup();
-                throw e;
+            // test if any unprocessed entries exist
+            if (posn < limit) {
+                return true;
+            } else {
 
-            } catch (NamingException e) {
-                cleanup();
-                PartialResultException pre = new PartialResultException();
-                pre.setRootCause(e);
-                throw pre;
+                try {
+                    // try to process another referral
+                    return hasMoreReferrals();
+
+                } catch (LdapReferralException |
+                        LimitExceededException |
+                        PartialResultException e) {
+                    cleanup();
+                    throw e;
+
+                } catch (NamingException e) {
+                    cleanup();
+                    PartialResultException pre = new PartialResultException();
+                    pre.setRootCause(e);
+                    throw pre;
+                }
             }
+        } finally {
+            // Ensure writes are visible to the Cleaner thread
+            VarHandle.fullFence();
+            // Ensure Cleaner does not run until after this method completes
+            Reference.reachabilityFence(enumCtx);
         }
     }
 
@@ -251,22 +354,33 @@ private T nextImpl() throws NamingException {
             cleanup();
             throw cont.fillInException(e);
         }
+        // No fences here. nextAux() (source just below) has its own fences. The
+        // only other thing this method does is call cleanup().
+        // If nextAux() were overrideable, this method should probably have
+        // fences, but it seems OK for now without.
     }
 
     private T nextAux() throws NamingException {
-        if (posn == limit) {
-            getNextBatch();  // updates posn and limit
-        }
+        try {
+            if (posn == limit) {
+                getNextBatch();  // updates posn and limit
+            }
 
-        if (posn >= limit) {
-            cleanup();
-            throw new NoSuchElementException("invalid enumeration handle");
-        }
+            if (posn >= limit) {
+                cleanup();
+                throw new NoSuchElementException("invalid enumeration handle");
+            }
 
-        LdapEntry result = entries.elementAt(posn++);
+            LdapEntry result = entries.elementAt(posn++);
 
-        // gets and outputs DN from the entry
-        return createItem(result.DN, result.attributes, result.respCtls);
+            // gets and outputs DN from the entry
+            return createItem(result.DN, result.attributes, result.respCtls);
+        } finally {
+            // Ensure writes are visible to the Cleaner thread
+            VarHandle.fullFence();
+            // Ensure Cleaner does not run until after this method completes
+            Reference.reachabilityFence(enumCtx);
+        }
     }
 
     protected final String getAtom(String dn) {
@@ -278,6 +392,7 @@ protected final String getAtom(String dn) {
         } catch (NamingException e) {
             return dn;
         }
+        // No fences - method clearly does not access cleanable state
     }
 
     protected abstract T createItem(String dn, Attributes attrs,
@@ -289,15 +404,23 @@ protected abstract T createItem(String dn, Attributes attrs,
      */
     @Override
     public void appendUnprocessedReferrals(LdapReferralException ex) {
-        if (refEx != null) {
-            refEx = refEx.appendUnprocessedReferrals(ex);
-        } else {
-            refEx = ex.appendUnprocessedReferrals(refEx);
+        try {
+            if (refEx != null) {
+                refEx = refEx.appendUnprocessedReferrals(ex);
+            } else {
+                refEx = ex.appendUnprocessedReferrals(refEx);
+            }
+        } finally {
+            // Ensure writes are visible to the Cleaner thread
+            VarHandle.fullFence();
+            // Ensure Cleaner does not run until after this method completes
+            Reference.reachabilityFence(this);
         }
     }
 
     final void setNamingException(NamingException e) {
         errEx = e;
+        // No fences - method clearly does not access cleanable state
     }
 
     protected abstract AbstractLdapNamingEnumeration<? extends NameClassPair> getReferredResults(
@@ -309,53 +432,59 @@ protected abstract AbstractLdapNamingEnumeration<? extends NameClassPair> getRef
      * results.
      */
     protected final boolean hasMoreReferrals() throws NamingException {
+        try {
+            if ((refEx != null) && !(errEx instanceof LimitExceededException) &&
+                (refEx.hasMoreReferrals() || refEx.hasMoreReferralExceptions())) {
 
-        if ((refEx != null) && !(errEx instanceof LimitExceededException) &&
-            (refEx.hasMoreReferrals() || refEx.hasMoreReferralExceptions())) {
-
-            if (homeCtx.handleReferrals == LdapClient.LDAP_REF_THROW) {
-                throw (NamingException)(refEx.fillInStackTrace());
-            }
-
-            // process the referrals sequentially
-            while (true) {
-
-                LdapReferralContext refCtx =
-                    (LdapReferralContext)refEx.getReferralContext(
-                    homeCtx.envprops, homeCtx.reqCtls);
+                if (enumCtx.homeCtx.handleReferrals == LdapClient.LDAP_REF_THROW) {
+                    throw (NamingException)(refEx.fillInStackTrace());
+                }
 
-                try {
+                // process the referrals sequentially
+                while (true) {
 
-                    update(getReferredResults(refCtx));
-                    break;
+                    LdapReferralContext refCtx =
+                        (LdapReferralContext)refEx.getReferralContext(
+                        enumCtx.homeCtx.envprops, enumCtx.homeCtx.reqCtls);
 
-                } catch (LdapReferralException re) {
+                    try {
 
-                    // record a previous exception and quit if any limit is reached
-                    var namingException = re.getNamingException();
-                    if (namingException instanceof LimitExceededException) {
-                        errEx = namingException;
+                        update(getReferredResults(refCtx));
                         break;
-                    } else if (errEx == null) {
-                        errEx = namingException;
-                    }
-                    refEx = re;
-                    continue;
 
-                } finally {
-                    // Make sure we close referral context
-                    refCtx.close();
+                    } catch (LdapReferralException re) {
+
+                        // record a previous exception and quit if any limit is reached
+                        var namingException = re.getNamingException();
+                        if (namingException instanceof LimitExceededException) {
+                            errEx = namingException;
+                            break;
+                        } else if (errEx == null) {
+                            errEx = namingException;
+                        }
+                        refEx = re;
+                        continue;
+
+                    } finally {
+                        // Make sure we close referral context
+                        refCtx.close();
+                    }
                 }
-            }
-            return hasMoreImpl();
+                return hasMoreImpl();
 
-        } else {
-            cleanup();
+            } else {
+                cleanup();
 
-            if (errEx != null) {
-                throw errEx;
+                if (errEx != null) {
+                    throw errEx;
+                }
+                return (false);
             }
-            return (false);
+        } finally {
+            // Ensure writes are visible to the Cleaner thread
+            VarHandle.fullFence();
+            // Ensure Cleaner does not run until after this method completes
+            Reference.reachabilityFence(enumCtx);
         }
     }
 
@@ -364,49 +493,43 @@ protected final boolean hasMoreReferrals() throws NamingException {
      * with those of the current enumeration.
      */
     protected void update(AbstractLdapNamingEnumeration<? extends NameClassPair> ne) {
-        // Cleanup previous context first
-        homeCtx.decEnumCount();
-
-        // New enum will have already incremented enum count and recorded clnt
-        homeCtx = ne.homeCtx;
-        enumClnt = ne.enumClnt;
-
-        // Do this to prevent referral enumeration (ne) from decrementing
-        // enum count because we'll be doing that here from this
-        // enumeration.
-        ne.homeCtx = null;
-
-        // Record rest of information from new enum
-        posn = ne.posn;
-        limit = ne.limit;
-        res = ne.res;
-        entries = ne.entries;
-        refEx = ne.refEx;
-        listArg = ne.listArg;
-        // record a previous exception and quit if any limit is reached
-        if (errEx == null || ne.errEx instanceof LimitExceededException) {
-            errEx = ne.errEx;
+        try {
+            // Cleanup previous context first
+            getHomeCtx().decEnumCount();
+
+            // New enum will have already incremented enum count and recorded clnt
+            enumCtx.homeCtx = ne.enumCtx.homeCtx;
+            enumCtx.enumClnt = ne.enumCtx.enumClnt;
+
+            // 'this' and 'ne' now both refer to ne's homeCtx. 'this' will
+            // decrement homeCtx's enum count later (via cleanup() or Cleaner).
+            // Clear ne's reference to homeCtx so ne's Cleaner doesn't
+            // *also* decrement the count.
+            ne.enumCtx.homeCtx = null;
+
+            // Record rest of information from new enum
+            posn = ne.posn;
+            limit = ne.limit;
+            enumCtx.res = ne.enumCtx.res;
+            entries = ne.entries;
+            refEx = ne.refEx;
+            listArg = ne.listArg;
+            // record a previous exception and quit if any limit is reached
+            if (errEx == null || ne.errEx instanceof LimitExceededException) {
+                errEx = ne.errEx;
+            }
+        } finally {
+            // Ensure writes are visible to the Cleaner thread
+            VarHandle.fullFence();
+            // Ensure Cleaner does not run until after this method completes
+            Reference.reachabilityFence(ne);
+            Reference.reachabilityFence(this);
         }
     }
 
-    @SuppressWarnings("removal")
-    protected final void finalize() {
-        cleanup();
-    }
-
     protected final void cleanup() {
-        if (cleaned) return; // been there; done that
-
-        if(enumClnt != null) {
-            enumClnt.clearSearchReply(res, homeCtx.reqCtls);
-        }
-
-        enumClnt = null;
-        cleaned = true;
-        if (homeCtx != null) {
-            homeCtx.decEnumCount();
-            homeCtx = null;
-        }
+        // Run the cleaning action (if it has not run already)
+        cleanable.clean();
     }
 
     @Override