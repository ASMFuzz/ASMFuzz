@@ -3036,8 +3036,12 @@ void intoArray(double[] a, int offset,
             intoArray(a, offset);
         } else {
             DoubleSpecies vsp = vspecies();
-            checkMaskFromIndexSize(offset, vsp, m, 1, a.length);
-            intoArray0(a, offset, m);
+            if (offset >= 0 && offset <= (a.length - vsp.length())) {
+                intoArray0(a, offset, m, /* offsetInRange */ true);
+            } else {
+                checkMaskFromIndexSize(offset, vsp, m, 1, a.length);
+                intoArray0(a, offset, m, /* offsetInRange */ false);
+            }
         }
     }
 
@@ -3183,8 +3187,12 @@ void intoByteArray(byte[] a, int offset,
             intoByteArray(a, offset, bo);
         } else {
             DoubleSpecies vsp = vspecies();
-            checkMaskFromIndexSize(offset, vsp, m, 8, a.length);
-            maybeSwap(bo).intoByteArray0(a, offset, m);
+            if (offset >= 0 && offset <= (a.length - vsp.vectorByteSize())) {
+                maybeSwap(bo).intoByteArray0(a, offset, m, /* offsetInRange */ true);
+            } else {
+                checkMaskFromIndexSize(offset, vsp, m, 8, a.length);
+                maybeSwap(bo).intoByteArray0(a, offset, m, /* offsetInRange */ false);
+            }
         }
     }
 
@@ -3219,8 +3227,12 @@ void intoByteBuffer(ByteBuffer bb, int offset,
                 throw new ReadOnlyBufferException();
             }
             DoubleSpecies vsp = vspecies();
-            checkMaskFromIndexSize(offset, vsp, m, 8, bb.limit());
-            maybeSwap(bo).intoByteBuffer0(bb, offset, m);
+            if (offset >= 0 && offset <= (bb.limit() - vsp.vectorByteSize())) {
+                maybeSwap(bo).intoByteBuffer0(bb, offset, m, /* offsetInRange */ true);
+            } else {
+                checkMaskFromIndexSize(offset, vsp, m, 8, bb.limit());
+                maybeSwap(bo).intoByteBuffer0(bb, offset, m, /* offsetInRange */ false);
+            }
         }
     }
 
@@ -3433,20 +3445,37 @@ a, arrayAddress(a, offset),
     }
 
     abstract
-    void intoArray0(double[] a, int offset, VectorMask<Double> m);
+    void intoArray0(double[] a, int offset, VectorMask<Double> m, boolean offsetInRange);
     @ForceInline
     final
     <M extends VectorMask<Double>>
-    void intoArray0Template(Class<M> maskClass, double[] a, int offset, M m) {
+    void intoArray0Template(Class<M> maskClass, double[] a, int offset, M m, boolean offsetInRange) {
+        intoArray0Template(maskClass, a, arrayAddress(a, offset), offset,
+            this, m, offsetInRange,
+            (arr, off, v, vm) -> v.stOp(arr, off, vm,
+                                        (arr_, off_, i, e) -> arr_[off_ + i] = e));
+    }
+
+    @ForceInline
+    final
+    <C, M extends VectorMask<Double>>
+    void intoArray0Template(Class<M> maskClass, C base, long offset, int index, DoubleVector v, M m, boolean offsetInRange,
+                            VectorSupport.StoreVectorMaskedOperation<C, DoubleVector, M> defaultImpl) {
         m.check(species());
         DoubleSpecies vsp = vspecies();
-        VectorSupport.storeMasked(
-            vsp.vectorType(), maskClass, vsp.elementType(), vsp.laneCount(),
-            a, arrayAddress(a, offset),
-            this, m, a, offset,
-            (arr, off, v, vm)
-            -> v.stOp(arr, off, vm,
-                      (arr_, off_, i, e) -> arr_[off_ + i] = e));
+        if (offsetInRange) {
+            VectorSupport.storeMasked(
+                vsp.vectorType(), maskClass, vsp.elementType(), vsp.laneCount(),
+                base, offset,
+                v, m, /* offsetInRange */ 1,
+                base, index, defaultImpl);
+        } else {
+            VectorSupport.storeMasked(
+                vsp.vectorType(), maskClass, vsp.elementType(), vsp.laneCount(),
+                base, offset,
+                v, m, /* offsetInRange */ 0,
+                base, index, defaultImpl);
+        }
     }
 
     abstract
@@ -3521,17 +3550,13 @@ a, byteArrayAddress(a, offset),
     }
 
     abstract
-    void intoByteArray0(byte[] a, int offset, VectorMask<Double> m);
+    void intoByteArray0(byte[] a, int offset, VectorMask<Double> m, boolean offsetInRange);
     @ForceInline
     final
     <M extends VectorMask<Double>>
-    void intoByteArray0Template(Class<M> maskClass, byte[] a, int offset, M m) {
-        DoubleSpecies vsp = vspecies();
-        m.check(vsp);
-        VectorSupport.storeMasked(
-            vsp.vectorType(), maskClass, vsp.elementType(), vsp.laneCount(),
-            a, byteArrayAddress(a, offset),
-            this, m, a, offset,
+    void intoByteArray0Template(Class<M> maskClass, byte[] a, int offset, M m, boolean offsetInRange) {
+        intoArray0Template(maskClass, a, byteArrayAddress(a, offset), offset,
+            this, m, offsetInRange,
             (arr, off, v, vm) -> {
                 ByteBuffer wb = wrapper(arr, NATIVE_ENDIAN);
                 v.stOp(wb, off, vm,
@@ -3554,16 +3579,16 @@ void intoByteBuffer0(ByteBuffer bb, int offset) {
     }
 
     abstract
-    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Double> m);
+    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Double> m, boolean offsetInRange);
     @ForceInline
     final
     <M extends VectorMask<Double>>
-    void intoByteBuffer0Template(Class<M> maskClass, ByteBuffer bb, int offset, M m) {
+    void intoByteBuffer0Template(Class<M> maskClass, ByteBuffer bb, int offset, M m, boolean offsetInRange) {
         DoubleSpecies vsp = vspecies();
         m.check(vsp);
         ScopedMemoryAccess.storeIntoByteBufferMasked(
                 vsp.vectorType(), maskClass, vsp.elementType(), vsp.laneCount(),
-                this, m, bb, offset,
+                this, m, offsetInRange, bb, offset,
                 (buf, off, v, vm) -> {
                     ByteBuffer wb = wrapper(buf, NATIVE_ENDIAN);
                     v.stOp(wb, off, vm,