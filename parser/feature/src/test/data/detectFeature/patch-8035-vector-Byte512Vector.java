@@ -974,8 +974,8 @@ ByteVector fromArray0(byte[] a, int offset) {
     @ForceInline
     @Override
     final
-    ByteVector fromArray0(byte[] a, int offset, VectorMask<Byte> m) {
-        return super.fromArray0Template(Byte512Mask.class, a, offset, (Byte512Mask) m);  // specialize
+    ByteVector fromArray0(byte[] a, int offset, VectorMask<Byte> m, int offsetInRange) {
+        return super.fromArray0Template(Byte512Mask.class, a, offset, (Byte512Mask) m, offsetInRange);  // specialize
     }
 
 
@@ -990,8 +990,8 @@ ByteVector fromBooleanArray0(boolean[] a, int offset) {
     @ForceInline
     @Override
     final
-    ByteVector fromBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m) {
-        return super.fromBooleanArray0Template(Byte512Mask.class, a, offset, (Byte512Mask) m);  // specialize
+    ByteVector fromBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m, int offsetInRange) {
+        return super.fromBooleanArray0Template(Byte512Mask.class, a, offset, (Byte512Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
@@ -1004,8 +1004,8 @@ ByteVector fromMemorySegment0(MemorySegment ms, long offset) {
     @ForceInline
     @Override
     final
-    ByteVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Byte> m) {
-        return super.fromMemorySegment0Template(Byte512Mask.class, ms, offset, (Byte512Mask) m);  // specialize
+    ByteVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Byte> m, int offsetInRange) {
+        return super.fromMemorySegment0Template(Byte512Mask.class, ms, offset, (Byte512Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline