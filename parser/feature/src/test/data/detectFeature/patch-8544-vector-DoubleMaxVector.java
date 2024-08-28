@@ -862,8 +862,8 @@ void intoArray0(double[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoArray0(double[] a, int offset, VectorMask<Double> m) {
-        super.intoArray0Template(DoubleMaxMask.class, a, offset, (DoubleMaxMask) m);
+    void intoArray0(double[] a, int offset, VectorMask<Double> m, boolean offsetInRange) {
+        super.intoArray0Template(DoubleMaxMask.class, a, offset, (DoubleMaxMask) m, offsetInRange);
     }
 
     @ForceInline
@@ -884,15 +884,15 @@ void intoByteArray0(byte[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoByteArray0(byte[] a, int offset, VectorMask<Double> m) {
-        super.intoByteArray0Template(DoubleMaxMask.class, a, offset, (DoubleMaxMask) m);  // specialize
+    void intoByteArray0(byte[] a, int offset, VectorMask<Double> m, boolean offsetInRange) {
+        super.intoByteArray0Template(DoubleMaxMask.class, a, offset, (DoubleMaxMask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
     @Override
     final
-    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Double> m) {
-        super.intoByteBuffer0Template(DoubleMaxMask.class, bb, offset, (DoubleMaxMask) m);
+    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Double> m, boolean offsetInRange) {
+        super.intoByteBuffer0Template(DoubleMaxMask.class, bb, offset, (DoubleMaxMask) m, offsetInRange);
     }
 
 