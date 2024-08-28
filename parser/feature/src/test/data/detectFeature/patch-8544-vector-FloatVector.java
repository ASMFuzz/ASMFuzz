@@ -3042,8 +3042,12 @@ void intoArray(float[] a, int offset,
             intoArray(a, offset);
         } else {
             FloatSpecies vsp = vspecies();
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
 
@@ -3170,8 +3174,12 @@ void intoByteArray(byte[] a, int offset,
             intoByteArray(a, offset, bo);
         } else {
             FloatSpecies vsp = vspecies();
-            checkMaskFromIndexSize(offset, vsp, m, 4, a.length);
-            maybeSwap(bo).intoByteArray0(a, offset, m);
+            if (offset >= 0 && offset <= (a.length - vsp.vectorByteSize())) {
+                maybeSwap(bo).intoByteArray0(a, offset, m, /* offsetInRange */ true);
+            } else {
+                checkMaskFromIndexSize(offset, vsp, m, 4, a.length);
+                maybeSwap(bo).intoByteArray0(a, offset, m, /* offsetInRange */ false);
+            }
         }
     }
 
@@ -3206,8 +3214,12 @@ void intoByteBuffer(ByteBuffer bb, int offset,
                 throw new ReadOnlyBufferException();
             }
             FloatSpecies vsp = vspecies();
-            checkMaskFromIndexSize(offset, vsp, m, 4, bb.limit());
-            maybeSwap(bo).intoByteBuffer0(bb, offset, m);
+            if (offset >= 0 && offset <= (bb.limit() - vsp.vectorByteSize())) {
+                maybeSwap(bo).intoByteBuffer0(bb, offset, m, /* offsetInRange */ true);
+            } else {
+                checkMaskFromIndexSize(offset, vsp, m, 4, bb.limit());
+                maybeSwap(bo).intoByteBuffer0(bb, offset, m, /* offsetInRange */ false);
+            }
         }
     }
 
@@ -3402,20 +3414,37 @@ a, arrayAddress(a, offset),
     }
 
     abstract
-    void intoArray0(float[] a, int offset, VectorMask<Float> m);
+    void intoArray0(float[] a, int offset, VectorMask<Float> m, boolean offsetInRange);
     @ForceInline
     final
     <M extends VectorMask<Float>>
-    void intoArray0Template(Class<M> maskClass, float[] a, int offset, M m) {
+    void intoArray0Template(Class<M> maskClass, float[] a, int offset, M m, boolean offsetInRange) {
+        intoArray0Template(maskClass, a, arrayAddress(a, offset), offset,
+            this, m, offsetInRange,
+            (arr, off, v, vm) -> v.stOp(arr, off, vm,
+                                        (arr_, off_, i, e) -> arr_[off_ + i] = e));
+    }
+
+    @ForceInline
+    final
+    <C, M extends VectorMask<Float>>
+    void intoArray0Template(Class<M> maskClass, C base, long offset, int index, FloatVector v, M m, boolean offsetInRange,
+                            VectorSupport.StoreVectorMaskedOperation<C, FloatVector, M> defaultImpl) {
         m.check(species());
         FloatSpecies vsp = vspecies();
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
@@ -3471,17 +3500,13 @@ a, byteArrayAddress(a, offset),
     }
 
     abstract
-    void intoByteArray0(byte[] a, int offset, VectorMask<Float> m);
+    void intoByteArray0(byte[] a, int offset, VectorMask<Float> m, boolean offsetInRange);
     @ForceInline
     final
     <M extends VectorMask<Float>>
-    void intoByteArray0Template(Class<M> maskClass, byte[] a, int offset, M m) {
-        FloatSpecies vsp = vspecies();
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
@@ -3504,16 +3529,16 @@ void intoByteBuffer0(ByteBuffer bb, int offset) {
     }
 
     abstract
-    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Float> m);
+    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Float> m, boolean offsetInRange);
     @ForceInline
     final
     <M extends VectorMask<Float>>
-    void intoByteBuffer0Template(Class<M> maskClass, ByteBuffer bb, int offset, M m) {
+    void intoByteBuffer0Template(Class<M> maskClass, ByteBuffer bb, int offset, M m, boolean offsetInRange) {
         FloatSpecies vsp = vspecies();
         m.check(vsp);
         ScopedMemoryAccess.storeIntoByteBufferMasked(
                 vsp.vectorType(), maskClass, vsp.elementType(), vsp.laneCount(),
-                this, m, bb, offset,
+                this, m, offsetInRange, bb, offset,
                 (buf, off, v, vm) -> {
                     ByteBuffer wb = wrapper(buf, NATIVE_ENDIAN);
                     v.stOp(wb, off, vm,