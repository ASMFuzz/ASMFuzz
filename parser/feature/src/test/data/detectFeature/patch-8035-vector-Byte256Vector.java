@@ -910,8 +910,8 @@ ByteVector fromArray0(byte[] a, int offset) {
     @ForceInline
     @Override
     final
-    ByteVector fromArray0(byte[] a, int offset, VectorMask<Byte> m) {
-        return super.fromArray0Template(Byte256Mask.class, a, offset, (Byte256Mask) m);  // specialize
+    ByteVector fromArray0(byte[] a, int offset, VectorMask<Byte> m, int offsetInRange) {
+        return super.fromArray0Template(Byte256Mask.class, a, offset, (Byte256Mask) m, offsetInRange);  // specialize
     }
 
 
@@ -926,8 +926,8 @@ ByteVector fromBooleanArray0(boolean[] a, int offset) {
     @ForceInline
     @Override
     final
-    ByteVector fromBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m) {
-        return super.fromBooleanArray0Template(Byte256Mask.class, a, offset, (Byte256Mask) m);  // specialize
+    ByteVector fromBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m, int offsetInRange) {
+        return super.fromBooleanArray0Template(Byte256Mask.class, a, offset, (Byte256Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
@@ -940,8 +940,8 @@ ByteVector fromMemorySegment0(MemorySegment ms, long offset) {
     @ForceInline
     @Override
     final
-    ByteVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Byte> m) {
-        return super.fromMemorySegment0Template(Byte256Mask.class, ms, offset, (Byte256Mask) m);  // specialize
+    ByteVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Byte> m, int offsetInRange) {
+        return super.fromMemorySegment0Template(Byte256Mask.class, ms, offset, (Byte256Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline