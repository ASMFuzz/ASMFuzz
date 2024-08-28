@@ -836,8 +836,8 @@ DoubleVector fromArray0(double[] a, int offset) {
     @ForceInline
     @Override
     final
-    DoubleVector fromArray0(double[] a, int offset, VectorMask<Double> m) {
-        return super.fromArray0Template(DoubleMaxMask.class, a, offset, (DoubleMaxMask) m);  // specialize
+    DoubleVector fromArray0(double[] a, int offset, VectorMask<Double> m, int offsetInRange) {
+        return super.fromArray0Template(DoubleMaxMask.class, a, offset, (DoubleMaxMask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
@@ -859,8 +859,8 @@ DoubleVector fromMemorySegment0(MemorySegment ms, long offset) {
     @ForceInline
     @Override
     final
-    DoubleVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Double> m) {
-        return super.fromMemorySegment0Template(DoubleMaxMask.class, ms, offset, (DoubleMaxMask) m);  // specialize
+    DoubleVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Double> m, int offsetInRange) {
+        return super.fromMemorySegment0Template(DoubleMaxMask.class, ms, offset, (DoubleMaxMask) m, offsetInRange);  // specialize
     }
 
     @ForceInline