@@ -881,16 +881,16 @@ void intoArray0(byte[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoArray0(byte[] a, int offset, VectorMask<Byte> m) {
-        super.intoArray0Template(ByteMaxMask.class, a, offset, (ByteMaxMask) m);
+    void intoArray0(byte[] a, int offset, VectorMask<Byte> m, boolean offsetInRange) {
+        super.intoArray0Template(ByteMaxMask.class, a, offset, (ByteMaxMask) m, offsetInRange);
     }
 
 
     @ForceInline
     @Override
     final
-    void intoBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m) {
-        super.intoBooleanArray0Template(ByteMaxMask.class, a, offset, (ByteMaxMask) m);
+    void intoBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m, boolean offsetInRange) {
+        super.intoBooleanArray0Template(ByteMaxMask.class, a, offset, (ByteMaxMask) m, offsetInRange);
     }
 
     @ForceInline
@@ -903,15 +903,15 @@ void intoByteArray0(byte[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoByteArray0(byte[] a, int offset, VectorMask<Byte> m) {
-        super.intoByteArray0Template(ByteMaxMask.class, a, offset, (ByteMaxMask) m);  // specialize
+    void intoByteArray0(byte[] a, int offset, VectorMask<Byte> m, boolean offsetInRange) {
+        super.intoByteArray0Template(ByteMaxMask.class, a, offset, (ByteMaxMask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
     @Override
     final
-    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Byte> m) {
-        super.intoByteBuffer0Template(ByteMaxMask.class, bb, offset, (ByteMaxMask) m);
+    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Byte> m, boolean offsetInRange) {
+        super.intoByteBuffer0Template(ByteMaxMask.class, bb, offset, (ByteMaxMask) m, offsetInRange);
     }
 
 