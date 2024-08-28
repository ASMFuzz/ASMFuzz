@@ -911,16 +911,16 @@ void intoArray0(byte[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoArray0(byte[] a, int offset, VectorMask<Byte> m) {
-        super.intoArray0Template(Byte128Mask.class, a, offset, (Byte128Mask) m);
+    void intoArray0(byte[] a, int offset, VectorMask<Byte> m, boolean offsetInRange) {
+        super.intoArray0Template(Byte128Mask.class, a, offset, (Byte128Mask) m, offsetInRange);
     }
 
 
     @ForceInline
     @Override
     final
-    void intoBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m) {
-        super.intoBooleanArray0Template(Byte128Mask.class, a, offset, (Byte128Mask) m);
+    void intoBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m, boolean offsetInRange) {
+        super.intoBooleanArray0Template(Byte128Mask.class, a, offset, (Byte128Mask) m, offsetInRange);
     }
 
     @ForceInline
@@ -933,15 +933,15 @@ void intoByteArray0(byte[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoByteArray0(byte[] a, int offset, VectorMask<Byte> m) {
-        super.intoByteArray0Template(Byte128Mask.class, a, offset, (Byte128Mask) m);  // specialize
+    void intoByteArray0(byte[] a, int offset, VectorMask<Byte> m, boolean offsetInRange) {
+        super.intoByteArray0Template(Byte128Mask.class, a, offset, (Byte128Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
     @Override
     final
-    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Byte> m) {
-        super.intoByteBuffer0Template(Byte128Mask.class, bb, offset, (Byte128Mask) m);
+    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Byte> m, boolean offsetInRange) {
+        super.intoByteBuffer0Template(Byte128Mask.class, bb, offset, (Byte128Mask) m, offsetInRange);
     }
 
 