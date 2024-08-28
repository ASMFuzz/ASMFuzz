@@ -2806,12 +2806,11 @@ DoubleVector fromArray(VectorSpecies<Double> species,
                                    VectorMask<Double> m) {
         DoubleSpecies vsp = (DoubleSpecies) species;
         if (VectorIntrinsics.indexInRange(offset, vsp.length(), a.length)) {
-            return vsp.dummyVector().fromArray0(a, offset, m);
+            return vsp.dummyVector().fromArray0(a, offset, m, OFFSET_IN_RANGE);
         }
 
-        // FIXME: optimize
         checkMaskFromIndexSize(offset, vsp, m, 1, a.length);
-        return vsp.vOp(m, i -> a[offset + i]);
+        return vsp.dummyVector().fromArray0(a, offset, m, OFFSET_OUT_OF_RANGE);
     }
 
     /**
@@ -3039,12 +3038,11 @@ DoubleVector fromMemorySegment(VectorSpecies<Double> species,
                                            VectorMask<Double> m) {
         DoubleSpecies vsp = (DoubleSpecies) species;
         if (VectorIntrinsics.indexInRange(offset, vsp.vectorByteSize(), ms.byteSize())) {
-            return vsp.dummyVector().fromMemorySegment0(ms, offset, m).maybeSwap(bo);
+            return vsp.dummyVector().fromMemorySegment0(ms, offset, m, OFFSET_IN_RANGE).maybeSwap(bo);
         }
 
-        // FIXME: optimize
         checkMaskFromIndexSize(offset, vsp, m, 8, ms.byteSize());
-        return vsp.ldLongOp(ms, offset, m, DoubleVector::memorySegmentGet);
+        return vsp.dummyVector().fromMemorySegment0(ms, offset, m, OFFSET_OUT_OF_RANGE).maybeSwap(bo);
     }
 
     // Memory store operations
@@ -3311,16 +3309,16 @@ a, arrayAddress(a, offset),
 
     /*package-private*/
     abstract
-    DoubleVector fromArray0(double[] a, int offset, VectorMask<Double> m);
+    DoubleVector fromArray0(double[] a, int offset, VectorMask<Double> m, int offsetInRange);
     @ForceInline
     final
     <M extends VectorMask<Double>>
-    DoubleVector fromArray0Template(Class<M> maskClass, double[] a, int offset, M m) {
+    DoubleVector fromArray0Template(Class<M> maskClass, double[] a, int offset, M m, int offsetInRange) {
         m.check(species());
         DoubleSpecies vsp = vspecies();
         return VectorSupport.loadMasked(
             vsp.vectorType(), maskClass, vsp.elementType(), vsp.laneCount(),
-            a, arrayAddress(a, offset), m,
+            a, arrayAddress(a, offset), m, offsetInRange,
             a, offset, vsp,
             (arr, off, s, vm) -> s.ldOp(arr, (int) off, vm,
                                         (arr_, off_, i) -> arr_[off_ + i]));
@@ -3395,16 +3393,16 @@ DoubleVector fromMemorySegment0Template(MemorySegment ms, long offset) {
     }
 
     abstract
-    DoubleVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Double> m);
+    DoubleVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Double> m, int offsetInRange);
     @ForceInline
     final
     <M extends VectorMask<Double>>
-    DoubleVector fromMemorySegment0Template(Class<M> maskClass, MemorySegment ms, long offset, M m) {
+    DoubleVector fromMemorySegment0Template(Class<M> maskClass, MemorySegment ms, long offset, M m, int offsetInRange) {
         DoubleSpecies vsp = vspecies();
         m.check(vsp);
         return ScopedMemoryAccess.loadFromMemorySegmentMasked(
                 vsp.vectorType(), maskClass, vsp.elementType(), vsp.laneCount(),
-                (AbstractMemorySegmentImpl) ms, offset, m, vsp,
+                (AbstractMemorySegmentImpl) ms, offset, m, vsp, offsetInRange,
                 (msp, off, s, vm) -> {
                     return s.ldLongOp((MemorySegment) msp, off, vm, DoubleVector::memorySegmentGet);
                 });