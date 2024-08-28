@@ -885,8 +885,8 @@ void intoArray0(int[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoArray0(int[] a, int offset, VectorMask<Integer> m) {
-        super.intoArray0Template(IntMaxMask.class, a, offset, (IntMaxMask) m);
+    void intoArray0(int[] a, int offset, VectorMask<Integer> m, boolean offsetInRange) {
+        super.intoArray0Template(IntMaxMask.class, a, offset, (IntMaxMask) m, offsetInRange);
     }
 
     @ForceInline
@@ -907,15 +907,15 @@ void intoByteArray0(byte[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoByteArray0(byte[] a, int offset, VectorMask<Integer> m) {
-        super.intoByteArray0Template(IntMaxMask.class, a, offset, (IntMaxMask) m);  // specialize
+    void intoByteArray0(byte[] a, int offset, VectorMask<Integer> m, boolean offsetInRange) {
+        super.intoByteArray0Template(IntMaxMask.class, a, offset, (IntMaxMask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
     @Override
     final
-    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Integer> m) {
-        super.intoByteBuffer0Template(IntMaxMask.class, bb, offset, (IntMaxMask) m);
+    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Integer> m, boolean offsetInRange) {
+        super.intoByteBuffer0Template(IntMaxMask.class, bb, offset, (IntMaxMask) m, offsetInRange);
     }
 
 