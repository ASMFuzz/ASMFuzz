@@ -862,8 +862,8 @@ void intoArray0(float[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoArray0(float[] a, int offset, VectorMask<Float> m) {
-        super.intoArray0Template(FloatMaxMask.class, a, offset, (FloatMaxMask) m);
+    void intoArray0(float[] a, int offset, VectorMask<Float> m, boolean offsetInRange) {
+        super.intoArray0Template(FloatMaxMask.class, a, offset, (FloatMaxMask) m, offsetInRange);
     }
 
     @ForceInline
@@ -884,15 +884,15 @@ void intoByteArray0(byte[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoByteArray0(byte[] a, int offset, VectorMask<Float> m) {
-        super.intoByteArray0Template(FloatMaxMask.class, a, offset, (FloatMaxMask) m);  // specialize
+    void intoByteArray0(byte[] a, int offset, VectorMask<Float> m, boolean offsetInRange) {
+        super.intoByteArray0Template(FloatMaxMask.class, a, offset, (FloatMaxMask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
     @Override
     final
-    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Float> m) {
-        super.intoByteBuffer0Template(FloatMaxMask.class, bb, offset, (FloatMaxMask) m);
+    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Float> m, boolean offsetInRange) {
+        super.intoByteBuffer0Template(FloatMaxMask.class, bb, offset, (FloatMaxMask) m, offsetInRange);
     }
 
 