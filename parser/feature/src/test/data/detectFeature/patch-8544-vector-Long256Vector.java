@@ -870,8 +870,8 @@ void intoArray0(long[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoArray0(long[] a, int offset, VectorMask<Long> m) {
-        super.intoArray0Template(Long256Mask.class, a, offset, (Long256Mask) m);
+    void intoArray0(long[] a, int offset, VectorMask<Long> m, boolean offsetInRange) {
+        super.intoArray0Template(Long256Mask.class, a, offset, (Long256Mask) m, offsetInRange);
     }
 
     @ForceInline
@@ -892,15 +892,15 @@ void intoByteArray0(byte[] a, int offset) {
     @ForceInline
     @Override
     final
-    void intoByteArray0(byte[] a, int offset, VectorMask<Long> m) {
-        super.intoByteArray0Template(Long256Mask.class, a, offset, (Long256Mask) m);  // specialize
+    void intoByteArray0(byte[] a, int offset, VectorMask<Long> m, boolean offsetInRange) {
+        super.intoByteArray0Template(Long256Mask.class, a, offset, (Long256Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
     @Override
     final
-    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Long> m) {
-        super.intoByteBuffer0Template(Long256Mask.class, bb, offset, (Long256Mask) m);
+    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Long> m, boolean offsetInRange) {
+        super.intoByteBuffer0Template(Long256Mask.class, bb, offset, (Long256Mask) m, offsetInRange);
     }
 
 