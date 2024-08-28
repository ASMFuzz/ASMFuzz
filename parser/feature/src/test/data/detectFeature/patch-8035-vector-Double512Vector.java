@@ -851,8 +851,8 @@ DoubleVector fromArray0(double[] a, int offset) {
     @ForceInline
     @Override
     final
-    DoubleVector fromArray0(double[] a, int offset, VectorMask<Double> m) {
-        return super.fromArray0Template(Double512Mask.class, a, offset, (Double512Mask) m);  // specialize
+    DoubleVector fromArray0(double[] a, int offset, VectorMask<Double> m, int offsetInRange) {
+        return super.fromArray0Template(Double512Mask.class, a, offset, (Double512Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline
@@ -874,8 +874,8 @@ DoubleVector fromMemorySegment0(MemorySegment ms, long offset) {
     @ForceInline
     @Override
     final
-    DoubleVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Double> m) {
-        return super.fromMemorySegment0Template(Double512Mask.class, ms, offset, (Double512Mask) m);  // specialize
+    DoubleVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Double> m, int offsetInRange) {
+        return super.fromMemorySegment0Template(Double512Mask.class, ms, offset, (Double512Mask) m, offsetInRange);  // specialize
     }
 
     @ForceInline