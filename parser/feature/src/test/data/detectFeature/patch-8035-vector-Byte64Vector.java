@@ -862,8 +862,8 @@ ByteVector fromArray0(byte[] a, int offset) {
     @ForceInline
     @Override
     final
-    ByteVector fromArray0(byte[] a, int offset, VectorMask<Byte> m) {
-        return super.fromArray0Template(Byte64Mask.class, a, offset, (Byte64Mask) m);  // specialize
+    ByteVector fromArray0(byte[] a, int offset, VectorMask<Byte> m, int offsetInRange) {
+        return super.fromArray0Template(Byte64Mask.class, a, offset, (Byte64Mask) m, offsetInRange);  // specialize
     }
 
 
@@ -878,8 +878,8 @@ ByteVector fromBooleanArray0(boolean[] a, int offset) {
     @ForceInline
     @Override
     final
-    ByteVector fromBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m) {
-        return super.fromBooleanArray0Template(Byte64Mask.class, a, offset, (Byte64Mask) m);  // specialize
+    ByteVector fromBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m, int offsetInRange) {
+        return super.fromBooleanArray0Template(Byte64Mask.class, a, offset, (Byte64Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
@@ -892,8 +892,8 @@ ByteVector fromMemorySegment0(MemorySegment ms, long offset) {
     @ForceInline
     @Override
     final
-    ByteVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Byte> m) {
-        return super.fromMemorySegment0Template(Byte64Mask.class, ms, offset, (Byte64Mask) m);  // specialize
+    ByteVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Byte> m, int offsetInRange) {
+        return super.fromMemorySegment0Template(Byte64Mask.class, ms, offset, (Byte64Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline