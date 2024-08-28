@@ -935,12 +935,12 @@ HotSpotResolvedObjectTypeImpl getResolvedJavaType(long displacement, boolean com
      * @param name name of current thread if in a native image otherwise {@code null}
      * @see HotSpotJVMCIRuntime#attachCurrentThread
      */
-    native boolean attachCurrentThread(byte[] name, boolean asDaemon);
+    native boolean attachCurrentThread(byte[] name, boolean asDaemon, long[] javaVMInfo);
 
     /**
-     * @see HotSpotJVMCIRuntime#detachCurrentThread()
+     * @see HotSpotJVMCIRuntime#detachCurrentThread
      */
-    native void detachCurrentThread();
+    native boolean detachCurrentThread(boolean release);
 
     /**
      * @see HotSpotJVMCIRuntime#exitHotSpot(int)