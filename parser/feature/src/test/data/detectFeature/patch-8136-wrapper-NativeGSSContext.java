@@ -26,6 +26,7 @@
 package sun.security.jgss.wrapper;
 
 import org.ietf.jgss.*;
+import java.lang.ref.Cleaner;
 import java.security.Provider;
 import sun.security.jgss.GSSHeader;
 import sun.security.jgss.GSSUtil;
@@ -46,6 +47,7 @@
  * @since 1.6
  */
 class NativeGSSContext implements GSSContextSpi {
+    private Cleaner.Cleanable cleanable;
 
     private static final int GSS_C_DELEG_FLAG = 1;
     private static final int GSS_C_MUTUAL_FLAG = 2;
@@ -238,8 +240,8 @@ private byte[] retrieveToken(InputStream is, int mechTokenLen)
     // Warning: called by NativeUtil.c
     NativeGSSContext(long pCtxt, GSSLibStub stub) throws GSSException {
         assert(pCtxt != 0);
-        pContext = pCtxt;
         cStub = stub;
+        setContext(pCtxt);
 
         // Set everything except cred, cb, delegatedCred
         long[] info = cStub.inquireContext(pContext);
@@ -359,7 +361,7 @@ public boolean isEstablished() {
         return isEstablished;
     }
 
-    public void dispose() throws GSSException {
+    public void dispose() {
         if (disposeCred != null) {
             disposeCred.dispose();
         }
@@ -370,12 +372,36 @@ public void dispose() throws GSSException {
         srcName = null;
         targetName = null;
         delegatedCred = null;
-        if (pContext != 0) {
-            pContext = cStub.deleteContext(pContext);
+
+        if (pContext != 0 && cleanable != null) {
             pContext = 0;
+            cleanable.clean();
+        }
+    }
+
+    // Note: this method is also used in native code.
+    private void setContext(long pContext) {
+        // Dispose the existing context.
+        if (this.pContext != 0L && cleanable != null) {
+            cleanable.clean();
+        }
+
+        // Reset the context
+        this.pContext = pContext;
+
+        // Register the cleaner.
+        if (pContext != 0L) {
+            cleanable = Krb5Util.cleaner.register(this,
+                    disposerFor(cStub, pContext));
         }
     }
 
+    private static Runnable disposerFor(GSSLibStub stub, long pContext) {
+        return () -> {
+            stub.deleteContext(pContext);
+        };
+    }
+
     public int getWrapSizeLimit(int qop, boolean confReq,
                                 int maxTokenSize)
         throws GSSException {
@@ -639,11 +665,6 @@ public boolean isInitiator() {
         return isInitiator;
     }
 
-    @SuppressWarnings("removal")
-    protected void finalize() throws Throwable {
-        dispose();
-    }
-
     public Object inquireSecContext(String type)
             throws GSSException {
         throw new GSSException(GSSException.UNAVAILABLE, -1,