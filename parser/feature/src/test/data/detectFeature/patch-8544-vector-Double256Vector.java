@@ -869,8 +869,8 @@ void intoArray0(double[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoArray0(double[] a, int offset, VectorMask<Double> m) {
-        super.intoArray0Template(Double256Mask.class, a, offset, (Double256Mask) m);
+    void intoArray0(double[] a, int offset, VectorMask<Double> m, boolean offsetInRange) {
+        super.intoArray0Template(Double256Mask.class, a, offset, (Double256Mask) m, offsetInRange);
     }
 
     @ForceInline
@@ -891,15 +891,15 @@ void intoByteArray0(byte[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoByteArray0(byte[] a, int offset, VectorMask<Double> m) {
-        super.intoByteArray0Template(Double256Mask.class, a, offset, (Double256Mask) m);  // specialize
+    void intoByteArray0(byte[] a, int offset, VectorMask<Double> m, boolean offsetInRange) {
+        super.intoByteArray0Template(Double256Mask.class, a, offset, (Double256Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
     @Override
     final
-    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Double> m) {
-        super.intoByteBuffer0Template(Double256Mask.class, bb, offset, (Double256Mask) m);
+    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Double> m, boolean offsetInRange) {
+        super.intoByteBuffer0Template(Double256Mask.class, bb, offset, (Double256Mask) m, offsetInRange);
     }
 
 