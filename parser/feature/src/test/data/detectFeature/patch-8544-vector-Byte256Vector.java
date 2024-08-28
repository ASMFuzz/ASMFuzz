@@ -943,16 +943,16 @@ void intoArray0(byte[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoArray0(byte[] a, int offset, VectorMask<Byte> m) {
-        super.intoArray0Template(Byte256Mask.class, a, offset, (Byte256Mask) m);
+    void intoArray0(byte[] a, int offset, VectorMask<Byte> m, boolean offsetInRange) {
+        super.intoArray0Template(Byte256Mask.class, a, offset, (Byte256Mask) m, offsetInRange);
     }
 
 
     @ForceInline
     @Override
     final
-    void intoBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m) {
-        super.intoBooleanArray0Template(Byte256Mask.class, a, offset, (Byte256Mask) m);
+    void intoBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m, boolean offsetInRange) {
+        super.intoBooleanArray0Template(Byte256Mask.class, a, offset, (Byte256Mask) m, offsetInRange);
     }
 
     @ForceInline
@@ -965,15 +965,15 @@ void intoByteArray0(byte[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoByteArray0(byte[] a, int offset, VectorMask<Byte> m) {
-        super.intoByteArray0Template(Byte256Mask.class, a, offset, (Byte256Mask) m);  // specialize
+    void intoByteArray0(byte[] a, int offset, VectorMask<Byte> m, boolean offsetInRange) {
+        super.intoByteArray0Template(Byte256Mask.class, a, offset, (Byte256Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
     @Override
     final
-    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Byte> m) {
-        super.intoByteBuffer0Template(Byte256Mask.class, bb, offset, (Byte256Mask) m);
+    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Byte> m, boolean offsetInRange) {
+        super.intoByteBuffer0Template(Byte256Mask.class, bb, offset, (Byte256Mask) m, offsetInRange);
     }
 
 