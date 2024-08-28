@@ -804,19 +804,19 @@ public ByteBuffer newHeapByteBuffer(byte[] hb, int offset, int capacity, MemoryS
                 }
 
                 @Override
-                public Object getBufferBase(ByteBuffer bb) {
-                    return bb.base();
+                public Object getBufferBase(Buffer buffer) {
+                    return buffer.base();
                 }
 
                 @Override
-                public long getBufferAddress(ByteBuffer bb) {
-                    return bb.address;
+                public long getBufferAddress(Buffer buffer) {
+                    return buffer.address;
                 }
 
                 @Override
-                public UnmapperProxy unmapper(ByteBuffer bb) {
-                    if (bb instanceof MappedByteBuffer) {
-                        return ((MappedByteBuffer)bb).unmapper();
+                public UnmapperProxy unmapper(Buffer buffer) {
+                    if (buffer instanceof MappedByteBuffer mbb) {
+                        return mbb.unmapper();
                     } else {
                         return null;
                     }