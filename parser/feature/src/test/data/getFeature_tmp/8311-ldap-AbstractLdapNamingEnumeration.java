/*
 * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.sun.jndi.ldap;

import com.sun.jndi.toolkit.ctx.Continuation;
import java.util.NoSuchElementException;
import java.util.Vector;

import javax.naming.*;
import javax.naming.directory.Attributes;
import javax.naming.ldap.Control;

import java.lang.invoke.VarHandle;
import java.lang.ref.Cleaner.Cleanable;
import java.lang.ref.Reference;
import jdk.internal.ref.CleanerFactory;

/**
 * Basic enumeration for NameClassPair, Binding, and SearchResults.
 */

abstract class AbstractLdapNamingEnumeration<T extends NameClassPair>
        implements NamingEnumeration<T>, ReferralEnumeration<T> {

    protected Name listArg;

    private Continuation cont;  // used to fill in exceptions
    private Vector<LdapEntry> entries = null;
    private int limit = 0;
    private int posn = 0;

    private LdapReferralException refEx = null;
    private NamingException errEx = null;

    /* This class maintains the pieces of state that need to be cleaned up (or
     * are needed for cleanup). It gets registered with Cleaner to perform cleanup.
     *
     * reachabilityFences are used to ensure that an AbstractLdapNamingEnumeration
     * instance does not become unreachable while one of its methods is still
     * executing (possibly leading to EnumCtx being cleaned up while it's still in use).
     *
     * Because the state is mutable, fullFence() is used to ensure that changes
     * made on the main/program thread are seen by the cleanup thread.
     */
    private static class EnumCtx implements Runnable {
        private LdapCtx homeCtx;
        private LdapResult res;
        private LdapClient enumClnt;

        private EnumCtx(LdapCtx homeCtx, LdapResult answer, LdapClient client) {
            this.homeCtx = homeCtx;
            this.res = answer;
            this.enumClnt = client;
        }

        @Override
        public void run() {
            // Ensure changes on the main/program thread happens-before cleanup
            VarHandle.fullFence();

            if (enumClnt != null) {
                if (homeCtx != null) {
                    enumClnt.clearSearchReply(res, homeCtx.reqCtls);
                }
                enumClnt = null;
            }
            if (homeCtx != null) {
                homeCtx.decEnumCount();
                homeCtx = null;
            }
        }
    }

    private final EnumCtx enumCtx;
    private final Cleanable cleanable;

    // Subclasses interact directly with the LdapCtx. This method provides
    // access to the LdapCtx within the EnumCtx.
    protected final LdapCtx getHomeCtx() { return enumCtx.homeCtx; }

    /*
     * Record the next set of entries and/or referrals.
     */
    AbstractLdapNamingEnumeration(LdapCtx homeCtx, LdapResult answer, Name listArg,
        Continuation cont) throws NamingException {

            // These checks are to accommodate referrals and limit exceptions
            // which will generate an enumeration and defer the exception
            // to be thrown at the end of the enumeration.
            // All other exceptions are thrown immediately.
            // Exceptions shouldn't be thrown here anyhow because
            // process_return_code() is called before the constructor
            // is called, so these are just safety checks.

            if ((answer.status != LdapClient.LDAP_SUCCESS) &&
                (answer.status != LdapClient.LDAP_SIZE_LIMIT_EXCEEDED) &&
                (answer.status != LdapClient.LDAP_TIME_LIMIT_EXCEEDED) &&
                (answer.status != LdapClient.LDAP_ADMIN_LIMIT_EXCEEDED) &&
                (answer.status != LdapClient.LDAP_REFERRAL) &&
                (answer.status != LdapClient.LDAP_PARTIAL_RESULTS)) {

                // %%% need to deal with referral
                NamingException e = new NamingException(
                                    LdapClient.getErrorMessage(
                                    answer.status, answer.errorMessage));

                throw cont.fillInException(e);
            }

            // otherwise continue

            entries = answer.entries;
            limit = (entries == null) ? 0 : entries.size(); // handle empty set
            this.listArg = listArg;
            this.cont = cont;

            if (answer.refEx != null) {
                refEx = answer.refEx;
            }

            this.enumCtx = new EnumCtx(homeCtx, answer, homeCtx.clnt);
            // Ensures that context won't get closed from underneath us
            this.enumCtx.homeCtx.incEnumCount();
            this.cleanable = CleanerFactory.cleaner().register(this, this.enumCtx);
            // For finalizers, JLS guarantees that the constructor of a finalizeable
            // class will complete before the finalizer is run. Classes that use
            // Cleaner instead don't currently have such a guarantee.

            // 'this' needs to stay reachable until registration with Cleaner
            // completes, to ensure that the cleanable state that has been created
            // will eventually be cleaned up. Within Cleaner.register(), there
            // are reachability fences to ensure that the registered object remains
            // reachable.
            // TODO: Is anything else needed so that this constructor
            //  "happens-before" the cleaning action ?
    }

    @Override
    public final T nextElement() {
        try {
            try {
                return next();
            } finally {
                // See comment in nextImpl(). This is similar, but in this case, next()
                // *is* overridable. Fences are included here, in case next() is
                // overridden to access the cleanable state without the proper fences.

                // Ensure writes are visible to the Cleaner thread
                VarHandle.fullFence();
                // Ensure Cleaner does not run until after this method completes
                Reference.reachabilityFence(this);
            }
        } catch (NamingException e) {
            // can't throw exception
            cleanup();
            return null;
        }
    }

    @Override
    public final boolean hasMoreElements() {
        try {
            try {
                return hasMore();
            } finally {
                // Same situation as nextElement() - see comment above

                // Ensure writes are visible to the Cleaner thread
                VarHandle.fullFence();
                // Ensure Cleaner does not run until after this method completes
                Reference.reachabilityFence(this);
            }
        } catch (NamingException e) {
            // can't throw exception
            cleanup();
            return false;
        }
    }

    /*
     * Retrieve the next set of entries and/or referrals.
     */
    private void getNextBatch() throws NamingException {
        try {
            enumCtx.res = enumCtx.homeCtx.getSearchReply(enumCtx.enumClnt, enumCtx.res);
            if (enumCtx.res == null) {
                limit = posn = 0;
                return;
            }

            entries = enumCtx.res.entries;
            limit = (entries == null) ? 0 : entries.size(); // handle empty set
            posn = 0; // reset

            // minimize the number of calls to processReturnCode()
            // (expensive when batchSize is small and there are many results)
            if ((enumCtx.res.status != LdapClient.LDAP_SUCCESS) ||
                ((enumCtx.res.status == LdapClient.LDAP_SUCCESS) &&
                    (enumCtx.res.referrals != null))) {

                try {
                    // convert referrals into a chain of LdapReferralException
                    enumCtx.homeCtx.processReturnCode(enumCtx.res, listArg);

                } catch (LimitExceededException | PartialResultException e) {
                    setNamingException(e);

                }
            }

            // merge any newly received referrals with any current referrals
            if (enumCtx.res.refEx != null) {
                if (refEx == null) {
                    refEx = enumCtx.res.refEx;
                } else {
                    refEx = refEx.appendUnprocessedReferrals(enumCtx.res.refEx);
                }
                enumCtx.res.refEx = null; // reset
            }

            if (enumCtx.res.resControls != null) {
                enumCtx.homeCtx.respCtls = enumCtx.res.resControls;
            }
        } finally {
            // Ensure writes are visible to the Cleaner thread
            VarHandle.fullFence();
            // Ensure Cleaner does not run until after this method completes
            Reference.reachabilityFence(this);
        }
    }

    private boolean more = true;  // assume we have something to start with
    private boolean hasMoreCalled = false;

    /*
     * Test if unprocessed entries or referrals exist.
     */
    @Override
    public final boolean hasMore() throws NamingException {
        try {
            if (hasMoreCalled) {
                return more;
            }

            hasMoreCalled = true;

            if (!more) {
                return false;
            } else {
                return (more = hasMoreImpl());
            }
        } finally {
            // Ensure writes are visible to the Cleaner thread
            VarHandle.fullFence();
            // Ensure Cleaner does not run until after this method completes
            Reference.reachabilityFence(enumCtx);
        }
    }

    /*
     * Retrieve the next entry.
     */
    @Override
    public final T next() throws NamingException {
        try {
            if (!hasMoreCalled) {
                hasMore();
            }
            hasMoreCalled = false;
            return nextImpl();
        } finally {
            // Ensure writes are visible to the Cleaner thread
            VarHandle.fullFence();
            // Ensure Cleaner does not run until after this method completes
            Reference.reachabilityFence(enumCtx);
        }
    }

    /*
     * Test if unprocessed entries or referrals exist.
     */
    private boolean hasMoreImpl() throws NamingException {
        try {
            // when page size is supported, this
            // might generate an exception while attempting
            // to fetch the next batch to determine
            // whether there are any more elements

            // test if the current set of entries has been processed
            if (posn == limit) {
                getNextBatch();
            }

            // test if any unprocessed entries exist
            if (posn < limit) {
                return true;
            } else {

                try {
                    // try to process another referral
                    return hasMoreReferrals();

                } catch (LdapReferralException |
                        LimitExceededException |
                        PartialResultException e) {
                    cleanup();
                    throw e;

                } catch (NamingException e) {
                    cleanup();
                    PartialResultException pre = new PartialResultException();
                    pre.setRootCause(e);
                    throw pre;
                }
            }
        } finally {
            // Ensure writes are visible to the Cleaner thread
            VarHandle.fullFence();
            // Ensure Cleaner does not run until after this method completes
            Reference.reachabilityFence(enumCtx);
        }
    }

    /*
     * Retrieve the next entry.
     */
    private T nextImpl() throws NamingException {
        try {
            return nextAux();
        } catch (NamingException e) {
            cleanup();
            throw cont.fillInException(e);
        }
        // No fences here. nextAux() (source just below) has its own fences. The
        // only other thing this method does is call cleanup().
        // If nextAux() were overrideable, this method should probably have
        // fences, but it seems OK for now without.
    }

    private T nextAux() throws NamingException {
        try {
            if (posn == limit) {
                getNextBatch();  // updates posn and limit
            }

            if (posn >= limit) {
                cleanup();
                throw new NoSuchElementException("invalid enumeration handle");
            }

            LdapEntry result = entries.elementAt(posn++);

            // gets and outputs DN from the entry
            return createItem(result.DN, result.attributes, result.respCtls);
        } finally {
            // Ensure writes are visible to the Cleaner thread
            VarHandle.fullFence();
            // Ensure Cleaner does not run until after this method completes
            Reference.reachabilityFence(enumCtx);
        }
    }

    protected final String getAtom(String dn) {
        // need to strip off all but lowest component of dn
        // so that is relative to current context (currentDN)
        try {
            Name parsed = new LdapName(dn);
            return parsed.get(parsed.size() - 1);
        } catch (NamingException e) {
            return dn;
        }
        // No fences - method clearly does not access cleanable state
    }

    protected abstract T createItem(String dn, Attributes attrs,
        Vector<Control> respCtls) throws NamingException;

    /*
     * Append the supplied (chain of) referrals onto the
     * end of the current (chain of) referrals.
     */
    @Override
    public void appendUnprocessedReferrals(LdapReferralException ex) {
        try {
            if (refEx != null) {
                refEx = refEx.appendUnprocessedReferrals(ex);
            } else {
                refEx = ex.appendUnprocessedReferrals(refEx);
            }
        } finally {
            // Ensure writes are visible to the Cleaner thread
            VarHandle.fullFence();
            // Ensure Cleaner does not run until after this method completes
            Reference.reachabilityFence(this);
        }
    }

    final void setNamingException(NamingException e) {
        errEx = e;
        // No fences - method clearly does not access cleanable state
    }

    protected abstract AbstractLdapNamingEnumeration<? extends NameClassPair> getReferredResults(
            LdapReferralContext refCtx) throws NamingException;

    /*
     * Iterate through the URLs of a referral. If successful then perform
     * a search operation and merge the received results with the current
     * results.
     */
    protected final boolean hasMoreReferrals() throws NamingException {
        try {
            if ((refEx != null) && !(errEx instanceof LimitExceededException) &&
                (refEx.hasMoreReferrals() || refEx.hasMoreReferralExceptions())) {

                if (enumCtx.homeCtx.handleReferrals == LdapClient.LDAP_REF_THROW) {
                    throw (NamingException)(refEx.fillInStackTrace());
                }

                // process the referrals sequentially
                while (true) {

                    LdapReferralContext refCtx =
                        (LdapReferralContext)refEx.getReferralContext(
                        enumCtx.homeCtx.envprops, enumCtx.homeCtx.reqCtls);

                    try {

                        update(getReferredResults(refCtx));
                        break;

                    } catch (LdapReferralException re) {

                        // record a previous exception and quit if any limit is reached
                        var namingException = re.getNamingException();
                        if (namingException instanceof LimitExceededException) {
                            errEx = namingException;
                            break;
                        } else if (errEx == null) {
                            errEx = namingException;
                        }
                        refEx = re;
                        continue;

                    } finally {
                        // Make sure we close referral context
                        refCtx.close();
                    }
                }
                return hasMoreImpl();

            } else {
                cleanup();

                if (errEx != null) {
                    throw errEx;
                }
                return (false);
            }
        } finally {
            // Ensure writes are visible to the Cleaner thread
            VarHandle.fullFence();
            // Ensure Cleaner does not run until after this method completes
            Reference.reachabilityFence(enumCtx);
        }
    }

    /*
     * Merge the entries and/or referrals from the supplied enumeration
     * with those of the current enumeration.
     */
    protected void update(AbstractLdapNamingEnumeration<? extends NameClassPair> ne) {
        try {
            // Cleanup previous context first
            getHomeCtx().decEnumCount();

            // New enum will have already incremented enum count and recorded clnt
            enumCtx.homeCtx = ne.enumCtx.homeCtx;
            enumCtx.enumClnt = ne.enumCtx.enumClnt;

            // 'this' and 'ne' now both refer to ne's homeCtx. 'this' will
            // decrement homeCtx's enum count later (via cleanup() or Cleaner).
            // Clear ne's reference to homeCtx so ne's Cleaner doesn't
            // *also* decrement the count.
            ne.enumCtx.homeCtx = null;

            // Record rest of information from new enum
            posn = ne.posn;
            limit = ne.limit;
            enumCtx.res = ne.enumCtx.res;
            entries = ne.entries;
            refEx = ne.refEx;
            listArg = ne.listArg;
            // record a previous exception and quit if any limit is reached
            if (errEx == null || ne.errEx instanceof LimitExceededException) {
                errEx = ne.errEx;
            }
        } finally {
            // Ensure writes are visible to the Cleaner thread
            VarHandle.fullFence();
            // Ensure Cleaner does not run until after this method completes
            Reference.reachabilityFence(ne);
            Reference.reachabilityFence(this);
        }
    }

    protected final void cleanup() {
        // Run the cleaning action (if it has not run already)
        cleanable.clean();
    }

    @Override
    public final void close() {
        cleanup();
    }
}
