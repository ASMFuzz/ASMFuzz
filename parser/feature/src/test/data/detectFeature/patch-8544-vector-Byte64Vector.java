@@ -895,16 +895,16 @@ void intoArray0(byte[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoArray0(byte[] a, int offset, VectorMask<Byte> m) {
-        super.intoArray0Template(Byte64Mask.class, a, offset, (Byte64Mask) m);
+    void intoArray0(byte[] a, int offset, VectorMask<Byte> m, boolean offsetInRange) {
+        super.intoArray0Template(Byte64Mask.class, a, offset, (Byte64Mask) m, offsetInRange);
     }
 
 
     @ForceInline
     @Override
     final
-    void intoBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m) {
-        super.intoBooleanArray0Template(Byte64Mask.class, a, offset, (Byte64Mask) m);
+    void intoBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m, boolean offsetInRange) {
+        super.intoBooleanArray0Template(Byte64Mask.class, a, offset, (Byte64Mask) m, offsetInRange);
     }
 
     @ForceInline
@@ -917,15 +917,15 @@ void intoByteArray0(byte[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoByteArray0(byte[] a, int offset, VectorMask<Byte> m) {
-        super.intoByteArray0Template(Byte64Mask.class, a, offset, (Byte64Mask) m);  // specialize
+    void intoByteArray0(byte[] a, int offset, VectorMask<Byte> m, boolean offsetInRange) {
+        super.intoByteArray0Template(Byte64Mask.class, a, offset, (Byte64Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
     @Override
     final
-    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Byte> m) {
-        super.intoByteBuffer0Template(Byte64Mask.class, bb, offset, (Byte64Mask) m);
+    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Byte> m, boolean offsetInRange) {
+        super.intoByteBuffer0Template(Byte64Mask.class, bb, offset, (Byte64Mask) m, offsetInRange);
     }
 
 