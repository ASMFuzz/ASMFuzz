@@ -869,8 +869,8 @@ void intoArray0(float[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoArray0(float[] a, int offset, VectorMask<Float> m) {
-        super.intoArray0Template(Float128Mask.class, a, offset, (Float128Mask) m);
+    void intoArray0(float[] a, int offset, VectorMask<Float> m, boolean offsetInRange) {
+        super.intoArray0Template(Float128Mask.class, a, offset, (Float128Mask) m, offsetInRange);
     }
 
     @ForceInline
@@ -891,15 +891,15 @@ void intoByteArray0(byte[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoByteArray0(byte[] a, int offset, VectorMask<Float> m) {
-        super.intoByteArray0Template(Float128Mask.class, a, offset, (Float128Mask) m);  // specialize
+    void intoByteArray0(byte[] a, int offset, VectorMask<Float> m, boolean offsetInRange) {
+        super.intoByteArray0Template(Float128Mask.class, a, offset, (Float128Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
     @Override
     final
-    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Float> m) {
-        super.intoByteBuffer0Template(Float128Mask.class, bb, offset, (Float128Mask) m);
+    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Float> m, boolean offsetInRange) {
+        super.intoByteBuffer0Template(Float128Mask.class, bb, offset, (Float128Mask) m, offsetInRange);
     }
 
 