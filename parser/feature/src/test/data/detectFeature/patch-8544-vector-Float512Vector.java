@@ -893,8 +893,8 @@ void intoArray0(float[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoArray0(float[] a, int offset, VectorMask<Float> m) {
-        super.intoArray0Template(Float512Mask.class, a, offset, (Float512Mask) m);
+    void intoArray0(float[] a, int offset, VectorMask<Float> m, boolean offsetInRange) {
+        super.intoArray0Template(Float512Mask.class, a, offset, (Float512Mask) m, offsetInRange);
     }
 
     @ForceInline
@@ -915,15 +915,15 @@ void intoByteArray0(byte[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoByteArray0(byte[] a, int offset, VectorMask<Float> m) {
-        super.intoByteArray0Template(Float512Mask.class, a, offset, (Float512Mask) m);  // specialize
+    void intoByteArray0(byte[] a, int offset, VectorMask<Float> m, boolean offsetInRange) {
+        super.intoByteArray0Template(Float512Mask.class, a, offset, (Float512Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
     @Override
     final
-    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Float> m) {
-        super.intoByteBuffer0Template(Float512Mask.class, bb, offset, (Float512Mask) m);
+    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Float> m, boolean offsetInRange) {
+        super.intoByteBuffer0Template(Float512Mask.class, bb, offset, (Float512Mask) m, offsetInRange);
     }
 
 