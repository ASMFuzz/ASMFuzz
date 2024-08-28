@@ -866,8 +866,8 @@ void intoArray0(long[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoArray0(long[] a, int offset, VectorMask<Long> m) {
-        super.intoArray0Template(Long128Mask.class, a, offset, (Long128Mask) m);
+    void intoArray0(long[] a, int offset, VectorMask<Long> m, boolean offsetInRange) {
+        super.intoArray0Template(Long128Mask.class, a, offset, (Long128Mask) m, offsetInRange);
     }
 
     @ForceInline
@@ -888,15 +888,15 @@ void intoByteArray0(byte[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoByteArray0(byte[] a, int offset, VectorMask<Long> m) {
-        super.intoByteArray0Template(Long128Mask.class, a, offset, (Long128Mask) m);  // specialize
+    void intoByteArray0(byte[] a, int offset, VectorMask<Long> m, boolean offsetInRange) {
+        super.intoByteArray0Template(Long128Mask.class, a, offset, (Long128Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
     @Override
     final
-    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Long> m) {
-        super.intoByteBuffer0Template(Long128Mask.class, bb, offset, (Long128Mask) m);
+    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Long> m, boolean offsetInRange) {
+        super.intoByteBuffer0Template(Long128Mask.class, bb, offset, (Long128Mask) m, offsetInRange);
     }
 
 