@@ -248,13 +248,9 @@ static String callToString(Object o) {
     }
 
     /**
-     * Set of recognized {@code "jvmci.*"} system properties. Entries not associated with an
-     * {@link Option} have this object as their value.
+     * Set of recognized {@code "jvmci.*"} system properties.
      */
     static final Map<String, Object> options = new HashMap<>();
-    static {
-        options.put("jvmci.class.path.append", options);
-    }
 
     /**
      * A list of all supported JVMCI options.
@@ -1342,6 +1338,8 @@ public long getCurrentJavaThread() {
      * Ensures the current thread is attached to the peer runtime.
      *
      * @param asDaemon if the thread is not yet attached, should it be attached as a daemon
+     * @param javaVMInfo if non-null, the JavaVM info as returned by {@link #registerNativeMethods}
+     *            is returned in this array
      * @return {@code true} if this call attached the current thread, {@code false} if the current
      *         thread was already attached
      * @throws UnsupportedOperationException if the JVMCI shared library is not enabled (i.e.
@@ -1351,21 +1349,25 @@ public long getCurrentJavaThread() {
      * @throws ArrayIndexOutOfBoundsException if {@code javaVMInfo} is non-null and is shorter than
      *             the length of the array returned by {@link #registerNativeMethods}
      */
-    public boolean attachCurrentThread(boolean asDaemon) {
+    public boolean attachCurrentThread(boolean asDaemon, long[] javaVMInfo) {
         byte[] name = IS_IN_NATIVE_IMAGE ? Thread.currentThread().getName().getBytes() : null;
-        return compilerToVm.attachCurrentThread(name, asDaemon);
+        return compilerToVm.attachCurrentThread(name, asDaemon, javaVMInfo);
     }
 
     /**
      * Detaches the current thread from the peer runtime.
      *
+     * @param release if {@code true} and this is the last thread attached to the peer runtime, the
+     *            {@code JavaVM} associated with the peer runtime is destroyed if possible
+     * @return {@code true} if the {@code JavaVM} associated with the peer runtime was destroyed as
+     *         a result of this call
      * @throws UnsupportedOperationException if the JVMCI shared library is not enabled (i.e.
      *             {@code -XX:-UseJVMCINativeLibrary})
      * @throws IllegalStateException if the peer runtime has not been initialized or if the current
      *             thread is not attached or if there is an error while trying to detach the thread
      */
-    public void detachCurrentThread() {
-        compilerToVm.detachCurrentThread();
+    public boolean detachCurrentThread(boolean release) {
+        return compilerToVm.detachCurrentThread(release);
     }
 
     /**