@@ -2830,12 +2830,11 @@ FloatVector fromArray(VectorSpecies<Float> species,
                                    VectorMask<Float> m) {
         FloatSpecies vsp = (FloatSpecies) species;
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
@@ -3045,12 +3044,11 @@ FloatVector fromMemorySegment(VectorSpecies<Float> species,
                                            VectorMask<Float> m) {
         FloatSpecies vsp = (FloatSpecies) species;
         if (VectorIntrinsics.indexInRange(offset, vsp.vectorByteSize(), ms.byteSize())) {
-            return vsp.dummyVector().fromMemorySegment0(ms, offset, m).maybeSwap(bo);
+            return vsp.dummyVector().fromMemorySegment0(ms, offset, m, OFFSET_IN_RANGE).maybeSwap(bo);
         }
 
-        // FIXME: optimize
         checkMaskFromIndexSize(offset, vsp, m, 4, ms.byteSize());
-        return vsp.ldLongOp(ms, offset, m, FloatVector::memorySegmentGet);
+        return vsp.dummyVector().fromMemorySegment0(ms, offset, m, OFFSET_OUT_OF_RANGE).maybeSwap(bo);
     }
 
     // Memory store operations
@@ -3298,16 +3296,16 @@ a, arrayAddress(a, offset),
 
     /*package-private*/
     abstract
-    FloatVector fromArray0(float[] a, int offset, VectorMask<Float> m);
+    FloatVector fromArray0(float[] a, int offset, VectorMask<Float> m, int offsetInRange);
     @ForceInline
     final
     <M extends VectorMask<Float>>
-    FloatVector fromArray0Template(Class<M> maskClass, float[] a, int offset, M m) {
+    FloatVector fromArray0Template(Class<M> maskClass, float[] a, int offset, M m, int offsetInRange) {
         m.check(species());
         FloatSpecies vsp = vspecies();
         return VectorSupport.loadMasked(
             vsp.vectorType(), maskClass, vsp.elementType(), vsp.laneCount(),
-            a, arrayAddress(a, offset), m,
+            a, arrayAddress(a, offset), m, offsetInRange,
             a, offset, vsp,
             (arr, off, s, vm) -> s.ldOp(arr, (int) off, vm,
                                         (arr_, off_, i) -> arr_[off_ + i]));
@@ -3364,16 +3362,16 @@ FloatVector fromMemorySegment0Template(MemorySegment ms, long offset) {
     }
 
     abstract
-    FloatVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Float> m);
+    FloatVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Float> m, int offsetInRange);
     @ForceInline
     final
     <M extends VectorMask<Float>>
-    FloatVector fromMemorySegment0Template(Class<M> maskClass, MemorySegment ms, long offset, M m) {
+    FloatVector fromMemorySegment0Template(Class<M> maskClass, MemorySegment ms, long offset, M m, int offsetInRange) {
         FloatSpecies vsp = vspecies();
         m.check(vsp);
         return ScopedMemoryAccess.loadFromMemorySegmentMasked(
                 vsp.vectorType(), maskClass, vsp.elementType(), vsp.laneCount(),
-                (AbstractMemorySegmentImpl) ms, offset, m, vsp,
+                (AbstractMemorySegmentImpl) ms, offset, m, vsp, offsetInRange,
                 (msp, off, s, vm) -> {
                     return s.ldLongOp((MemorySegment) msp, off, vm, FloatVector::memorySegmentGet);
                 });