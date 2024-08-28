@@ -851,8 +851,8 @@ FloatVector fromArray0(float[] a, int offset) {
     @ForceInline
     @Override
     final
-    FloatVector fromArray0(float[] a, int offset, VectorMask<Float> m) {
-        return super.fromArray0Template(Float256Mask.class, a, offset, (Float256Mask) m);  // specialize
+    FloatVector fromArray0(float[] a, int offset, VectorMask<Float> m, int offsetInRange) {
+        return super.fromArray0Template(Float256Mask.class, a, offset, (Float256Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
@@ -874,8 +874,8 @@ FloatVector fromMemorySegment0(MemorySegment ms, long offset) {
     @ForceInline
     @Override
     final
-    FloatVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Float> m) {
-        return super.fromMemorySegment0Template(Float256Mask.class, ms, offset, (Float256Mask) m);  // specialize
+    FloatVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Float> m, int offsetInRange) {
+        return super.fromMemorySegment0Template(Float256Mask.class, ms, offset, (Float256Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline