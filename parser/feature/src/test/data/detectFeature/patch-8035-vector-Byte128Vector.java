@@ -878,8 +878,8 @@ ByteVector fromArray0(byte[] a, int offset) {
     @ForceInline
     @Override
     final
-    ByteVector fromArray0(byte[] a, int offset, VectorMask<Byte> m) {
-        return super.fromArray0Template(Byte128Mask.class, a, offset, (Byte128Mask) m);  // specialize
+    ByteVector fromArray0(byte[] a, int offset, VectorMask<Byte> m, int offsetInRange) {
+        return super.fromArray0Template(Byte128Mask.class, a, offset, (Byte128Mask) m, offsetInRange);  // specialize
     }
 
 
@@ -894,8 +894,8 @@ ByteVector fromBooleanArray0(boolean[] a, int offset) {
     @ForceInline
     @Override
     final
-    ByteVector fromBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m) {
-        return super.fromBooleanArray0Template(Byte128Mask.class, a, offset, (Byte128Mask) m);  // specialize
+    ByteVector fromBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m, int offsetInRange) {
+        return super.fromBooleanArray0Template(Byte128Mask.class, a, offset, (Byte128Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
@@ -908,8 +908,8 @@ ByteVector fromMemorySegment0(MemorySegment ms, long offset) {
     @ForceInline
     @Override
     final
-    ByteVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Byte> m) {
-        return super.fromMemorySegment0Template(Byte128Mask.class, ms, offset, (Byte128Mask) m);  // specialize
+    ByteVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Byte> m, int offsetInRange) {
+        return super.fromMemorySegment0Template(Byte128Mask.class, ms, offset, (Byte128Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline