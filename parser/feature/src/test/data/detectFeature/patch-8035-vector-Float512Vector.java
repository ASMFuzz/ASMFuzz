@@ -867,8 +867,8 @@ FloatVector fromArray0(float[] a, int offset) {
     @ForceInline
     @Override
     final
-    FloatVector fromArray0(float[] a, int offset, VectorMask<Float> m) {
-        return super.fromArray0Template(Float512Mask.class, a, offset, (Float512Mask) m);  // specialize
+    FloatVector fromArray0(float[] a, int offset, VectorMask<Float> m, int offsetInRange) {
+        return super.fromArray0Template(Float512Mask.class, a, offset, (Float512Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
@@ -890,8 +890,8 @@ FloatVector fromMemorySegment0(MemorySegment ms, long offset) {
     @ForceInline
     @Override
     final
-    FloatVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Float> m) {
-        return super.fromMemorySegment0Template(Float512Mask.class, ms, offset, (Float512Mask) m);  // specialize
+    FloatVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Float> m, int offsetInRange) {
+        return super.fromMemorySegment0Template(Float512Mask.class, ms, offset, (Float512Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline