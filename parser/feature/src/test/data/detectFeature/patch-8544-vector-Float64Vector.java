@@ -865,8 +865,8 @@ void intoArray0(float[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoArray0(float[] a, int offset, VectorMask<Float> m) {
-        super.intoArray0Template(Float64Mask.class, a, offset, (Float64Mask) m);
+    void intoArray0(float[] a, int offset, VectorMask<Float> m, boolean offsetInRange) {
+        super.intoArray0Template(Float64Mask.class, a, offset, (Float64Mask) m, offsetInRange);
     }
 
     @ForceInline
@@ -887,15 +887,15 @@ void intoByteArray0(byte[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoByteArray0(byte[] a, int offset, VectorMask<Float> m) {
-        super.intoByteArray0Template(Float64Mask.class, a, offset, (Float64Mask) m);  // specialize
+    void intoByteArray0(byte[] a, int offset, VectorMask<Float> m, boolean offsetInRange) {
+        super.intoByteArray0Template(Float64Mask.class, a, offset, (Float64Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
     @Override
     final
-    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Float> m) {
-        super.intoByteBuffer0Template(Float64Mask.class, bb, offset, (Float64Mask) m);
+    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Float> m, boolean offsetInRange) {
+        super.intoByteBuffer0Template(Float64Mask.class, bb, offset, (Float64Mask) m, offsetInRange);
     }
 
 