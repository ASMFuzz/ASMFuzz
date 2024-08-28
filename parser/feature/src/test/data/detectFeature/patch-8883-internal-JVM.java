@@ -39,11 +39,17 @@
 public final class JVM {
     private static final JVM jvm = new JVM();
 
-    // JVM signals file changes by doing Object#notify on this object
-    static final Object FILE_DELTA_CHANGE = new Object();
-
     static final long RESERVED_CLASS_ID_LIMIT = 500;
 
+    private static class ChunkRotationMonitor {}
+
+    /*
+     * The JVM uses the chunk rotation monitor to notify Java that a rotation is warranted.
+     * The monitor type is used to exclude jdk.JavaMonitorWait events from being generated
+     * when Object.wait() is called on this monitor.
+     */
+    static final Object CHUNK_ROTATION_MONITOR = new ChunkRotationMonitor();
+
     private volatile boolean nativeOK;
 
     private static native void registerNatives();