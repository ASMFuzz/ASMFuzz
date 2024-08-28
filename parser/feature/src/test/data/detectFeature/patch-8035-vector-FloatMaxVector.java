@@ -836,8 +836,8 @@ FloatVector fromArray0(float[] a, int offset) {
     @ForceInline
     @Override
     final
-    FloatVector fromArray0(float[] a, int offset, VectorMask<Float> m) {
-        return super.fromArray0Template(FloatMaxMask.class, a, offset, (FloatMaxMask) m);  // specialize
+    FloatVector fromArray0(float[] a, int offset, VectorMask<Float> m, int offsetInRange) {
+        return super.fromArray0Template(FloatMaxMask.class, a, offset, (FloatMaxMask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
@@ -859,8 +859,8 @@ FloatVector fromMemorySegment0(MemorySegment ms, long offset) {
     @ForceInline
     @Override
     final
-    FloatVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Float> m) {
-        return super.fromMemorySegment0Template(FloatMaxMask.class, ms, offset, (FloatMaxMask) m);  // specialize
+    FloatVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Float> m, int offsetInRange) {
+        return super.fromMemorySegment0Template(FloatMaxMask.class, ms, offset, (FloatMaxMask) m, offsetInRange);  // specialize
     }
 
     @ForceInline