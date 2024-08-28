@@ -848,8 +848,8 @@ ByteVector fromArray0(byte[] a, int offset) {
     @ForceInline
     @Override
     final
-    ByteVector fromArray0(byte[] a, int offset, VectorMask<Byte> m) {
-        return super.fromArray0Template(ByteMaxMask.class, a, offset, (ByteMaxMask) m);  // specialize
+    ByteVector fromArray0(byte[] a, int offset, VectorMask<Byte> m, int offsetInRange) {
+        return super.fromArray0Template(ByteMaxMask.class, a, offset, (ByteMaxMask) m, offsetInRange);  // specialize
     }
 
 
@@ -864,8 +864,8 @@ ByteVector fromBooleanArray0(boolean[] a, int offset) {
     @ForceInline
     @Override
     final
-    ByteVector fromBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m) {
-        return super.fromBooleanArray0Template(ByteMaxMask.class, a, offset, (ByteMaxMask) m);  // specialize
+    ByteVector fromBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m, int offsetInRange) {
+        return super.fromBooleanArray0Template(ByteMaxMask.class, a, offset, (ByteMaxMask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
@@ -878,8 +878,8 @@ ByteVector fromMemorySegment0(MemorySegment ms, long offset) {
     @ForceInline
     @Override
     final
-    ByteVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Byte> m) {
-        return super.fromMemorySegment0Template(ByteMaxMask.class, ms, offset, (ByteMaxMask) m);  // specialize
+    ByteVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Byte> m, int offsetInRange) {
+        return super.fromMemorySegment0Template(ByteMaxMask.class, ms, offset, (ByteMaxMask) m, offsetInRange);  // specialize
     }
 
     @ForceInline