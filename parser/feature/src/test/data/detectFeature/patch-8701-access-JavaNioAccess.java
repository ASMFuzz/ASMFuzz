@@ -68,17 +68,17 @@ public interface JavaNioAccess {
     /**
      * Used by {@code jdk.internal.foreign.Utils}.
      */
-    Object getBufferBase(ByteBuffer bb);
+    Object getBufferBase(Buffer bb);
 
     /**
      * Used by {@code jdk.internal.foreign.Utils}.
      */
-    long getBufferAddress(ByteBuffer bb);
+    long getBufferAddress(Buffer buffer);
 
     /**
      * Used by {@code jdk.internal.foreign.Utils}.
      */
-    UnmapperProxy unmapper(ByteBuffer bb);
+    UnmapperProxy unmapper(Buffer buffer);
 
     /**
      * Used by {@code jdk.internal.foreign.AbstractMemorySegmentImpl} and byte buffer var handle views.