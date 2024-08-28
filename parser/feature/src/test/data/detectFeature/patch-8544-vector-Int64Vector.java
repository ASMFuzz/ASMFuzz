@@ -876,8 +876,8 @@ void intoArray0(int[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoArray0(int[] a, int offset, VectorMask<Integer> m) {
-        super.intoArray0Template(Int64Mask.class, a, offset, (Int64Mask) m);
+    void intoArray0(int[] a, int offset, VectorMask<Integer> m, boolean offsetInRange) {
+        super.intoArray0Template(Int64Mask.class, a, offset, (Int64Mask) m, offsetInRange);
     }
 
     @ForceInline
@@ -898,15 +898,15 @@ void intoByteArray0(byte[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoByteArray0(byte[] a, int offset, VectorMask<Integer> m) {
-        super.intoByteArray0Template(Int64Mask.class, a, offset, (Int64Mask) m);  // specialize
+    void intoByteArray0(byte[] a, int offset, VectorMask<Integer> m, boolean offsetInRange) {
+        super.intoByteArray0Template(Int64Mask.class, a, offset, (Int64Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
     @Override
     final
-    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Integer> m) {
-        super.intoByteBuffer0Template(Int64Mask.class, bb, offset, (Int64Mask) m);
+    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Integer> m, boolean offsetInRange) {
+        super.intoByteBuffer0Template(Int64Mask.class, bb, offset, (Int64Mask) m, offsetInRange);
     }
 
 