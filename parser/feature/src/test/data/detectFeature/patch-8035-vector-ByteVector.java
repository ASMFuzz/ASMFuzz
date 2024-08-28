@@ -3009,12 +3009,11 @@ ByteVector fromArray(VectorSpecies<Byte> species,
                                    VectorMask<Byte> m) {
         ByteSpecies vsp = (ByteSpecies) species;
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
@@ -3166,12 +3165,11 @@ ByteVector fromBooleanArray(VectorSpecies<Byte> species,
         ByteSpecies vsp = (ByteSpecies) species;
         if (VectorIntrinsics.indexInRange(offset, vsp.length(), a.length)) {
             ByteVector zero = vsp.zero();
-            return vsp.dummyVector().fromBooleanArray0(a, offset, m);
+            return vsp.dummyVector().fromBooleanArray0(a, offset, m, OFFSET_IN_RANGE);
         }
 
-        // FIXME: optimize
         checkMaskFromIndexSize(offset, vsp, m, 1, a.length);
-        return vsp.vOp(m, i -> (byte) (a[offset + i] ? 1 : 0));
+        return vsp.dummyVector().fromBooleanArray0(a, offset, m, OFFSET_OUT_OF_RANGE);
     }
 
     /**
@@ -3353,12 +3351,11 @@ ByteVector fromMemorySegment(VectorSpecies<Byte> species,
                                            VectorMask<Byte> m) {
         ByteSpecies vsp = (ByteSpecies) species;
         if (VectorIntrinsics.indexInRange(offset, vsp.vectorByteSize(), ms.byteSize())) {
-            return vsp.dummyVector().fromMemorySegment0(ms, offset, m).maybeSwap(bo);
+            return vsp.dummyVector().fromMemorySegment0(ms, offset, m, OFFSET_IN_RANGE).maybeSwap(bo);
         }
 
-        // FIXME: optimize
         checkMaskFromIndexSize(offset, vsp, m, 1, ms.byteSize());
-        return vsp.ldLongOp(ms, offset, m, ByteVector::memorySegmentGet);
+        return vsp.dummyVector().fromMemorySegment0(ms, offset, m, OFFSET_OUT_OF_RANGE).maybeSwap(bo);
     }
 
     // Memory store operations
@@ -3756,16 +3753,16 @@ a, arrayAddress(a, offset),
 
     /*package-private*/
     abstract
-    ByteVector fromArray0(byte[] a, int offset, VectorMask<Byte> m);
+    ByteVector fromArray0(byte[] a, int offset, VectorMask<Byte> m, int offsetInRange);
     @ForceInline
     final
     <M extends VectorMask<Byte>>
-    ByteVector fromArray0Template(Class<M> maskClass, byte[] a, int offset, M m) {
+    ByteVector fromArray0Template(Class<M> maskClass, byte[] a, int offset, M m, int offsetInRange) {
         m.check(species());
         ByteSpecies vsp = vspecies();
         return VectorSupport.loadMasked(
             vsp.vectorType(), maskClass, vsp.elementType(), vsp.laneCount(),
-            a, arrayAddress(a, offset), m,
+            a, arrayAddress(a, offset), m, offsetInRange,
             a, offset, vsp,
             (arr, off, s, vm) -> s.ldOp(arr, (int) off, vm,
                                         (arr_, off_, i) -> arr_[off_ + i]));
@@ -3790,16 +3787,16 @@ a, booleanArrayAddress(a, offset),
 
     /*package-private*/
     abstract
-    ByteVector fromBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m);
+    ByteVector fromBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m, int offsetInRange);
     @ForceInline
     final
     <M extends VectorMask<Byte>>
-    ByteVector fromBooleanArray0Template(Class<M> maskClass, boolean[] a, int offset, M m) {
+    ByteVector fromBooleanArray0Template(Class<M> maskClass, boolean[] a, int offset, M m, int offsetInRange) {
         m.check(species());
         ByteSpecies vsp = vspecies();
         return VectorSupport.loadMasked(
             vsp.vectorType(), maskClass, vsp.elementType(), vsp.laneCount(),
-            a, booleanArrayAddress(a, offset), m,
+            a, booleanArrayAddress(a, offset), m, offsetInRange,
             a, offset, vsp,
             (arr, off, s, vm) -> s.ldOp(arr, (int) off, vm,
                                         (arr_, off_, i) -> (byte) (arr_[off_ + i] ? 1 : 0)));
@@ -3820,16 +3817,16 @@ ByteVector fromMemorySegment0Template(MemorySegment ms, long offset) {
     }
 
     abstract
-    ByteVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Byte> m);
+    ByteVector fromMemorySegment0(MemorySegment ms, long offset, VectorMask<Byte> m, int offsetInRange);
     @ForceInline
     final
     <M extends VectorMask<Byte>>
-    ByteVector fromMemorySegment0Template(Class<M> maskClass, MemorySegment ms, long offset, M m) {
+    ByteVector fromMemorySegment0Template(Class<M> maskClass, MemorySegment ms, long offset, M m, int offsetInRange) {
         ByteSpecies vsp = vspecies();
         m.check(vsp);
         return ScopedMemoryAccess.loadFromMemorySegmentMasked(
                 vsp.vectorType(), maskClass, vsp.elementType(), vsp.laneCount(),
-                (AbstractMemorySegmentImpl) ms, offset, m, vsp,
+                (AbstractMemorySegmentImpl) ms, offset, m, vsp, offsetInRange,
                 (msp, off, s, vm) -> {
                     return s.ldLongOp((MemorySegment) msp, off, vm, ByteVector::memorySegmentGet);
                 });