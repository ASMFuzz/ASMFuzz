@@ -3320,8 +3320,12 @@ void intoArray(byte[] a, int offset,
             intoArray(a, offset);
         } else {
             ByteSpecies vsp = vspecies();
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
 
@@ -3475,8 +3479,12 @@ void intoBooleanArray(boolean[] a, int offset,
             intoBooleanArray(a, offset);
         } else {
             ByteSpecies vsp = vspecies();
-            checkMaskFromIndexSize(offset, vsp, m, 1, a.length);
-            intoBooleanArray0(a, offset, m);
+            if (offset >= 0 && offset <= (a.length - vsp.length())) {
+                intoBooleanArray0(a, offset, m, /* offsetInRange */ true);
+            } else {
+                checkMaskFromIndexSize(offset, vsp, m, 1, a.length);
+                intoBooleanArray0(a, offset, m, /* offsetInRange */ false);
+            }
         }
     }
 
@@ -3596,8 +3604,12 @@ void intoByteArray(byte[] a, int offset,
             intoByteArray(a, offset, bo);
         } else {
             ByteSpecies vsp = vspecies();
-            checkMaskFromIndexSize(offset, vsp, m, 1, a.length);
-            maybeSwap(bo).intoByteArray0(a, offset, m);
+            if (offset >= 0 && offset <= (a.length - vsp.vectorByteSize())) {
+                maybeSwap(bo).intoByteArray0(a, offset, m, /* offsetInRange */ true);
+            } else {
+                checkMaskFromIndexSize(offset, vsp, m, 1, a.length);
+                maybeSwap(bo).intoByteArray0(a, offset, m, /* offsetInRange */ false);
+            }
         }
     }
 
@@ -3632,8 +3644,12 @@ void intoByteBuffer(ByteBuffer bb, int offset,
                 throw new ReadOnlyBufferException();
             }
             ByteSpecies vsp = vspecies();
-            checkMaskFromIndexSize(offset, vsp, m, 1, bb.limit());
-            maybeSwap(bo).intoByteBuffer0(bb, offset, m);
+            if (offset >= 0 && offset <= (bb.limit() - vsp.vectorByteSize())) {
+                maybeSwap(bo).intoByteBuffer0(bb, offset, m, /* offsetInRange */ true);
+            } else {
+                checkMaskFromIndexSize(offset, vsp, m, 1, bb.limit());
+                maybeSwap(bo).intoByteBuffer0(bb, offset, m, /* offsetInRange */ false);
+            }
         }
     }
 
@@ -3823,39 +3839,51 @@ a, arrayAddress(a, offset),
     }
 
     abstract
-    void intoArray0(byte[] a, int offset, VectorMask<Byte> m);
+    void intoArray0(byte[] a, int offset, VectorMask<Byte> m, boolean offsetInRange);
     @ForceInline
     final
     <M extends VectorMask<Byte>>
-    void intoArray0Template(Class<M> maskClass, byte[] a, int offset, M m) {
+    void intoArray0Template(Class<M> maskClass, byte[] a, int offset, M m, boolean offsetInRange) {
+        intoArray0Template(maskClass, a, arrayAddress(a, offset), offset,
+            this, m, offsetInRange,
+            (arr, off, v, vm) -> v.stOp(arr, off, vm,
+                                        (arr_, off_, i, e) -> arr_[off_ + i] = e));
+    }
+
+    @ForceInline
+    final
+    <C, M extends VectorMask<Byte>>
+    void intoArray0Template(Class<M> maskClass, C base, long offset, int index, ByteVector v, M m, boolean offsetInRange,
+                            VectorSupport.StoreVectorMaskedOperation<C, ByteVector, M> defaultImpl) {
         m.check(species());
         ByteSpecies vsp = vspecies();
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
-    void intoBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m);
+    void intoBooleanArray0(boolean[] a, int offset, VectorMask<Byte> m, boolean offsetInRange);
     @ForceInline
     final
     <M extends VectorMask<Byte>>
-    void intoBooleanArray0Template(Class<M> maskClass, boolean[] a, int offset, M m) {
-        m.check(species());
-        ByteSpecies vsp = vspecies();
+    void intoBooleanArray0Template(Class<M> maskClass, boolean[] a, int offset, M m, boolean offsetInRange) {
         ByteVector normalized = this.and((byte) 1);
-        VectorSupport.storeMasked(
-            vsp.vectorType(), maskClass, vsp.elementType(), vsp.laneCount(),
-            a, booleanArrayAddress(a, offset),
-            normalized, m, a, offset,
-            (arr, off, v, vm)
-            -> v.stOp(arr, off, vm,
-                      (arr_, off_, i, e) -> arr_[off_ + i] = (e & 1) != 0));
+        intoArray0Template(maskClass, a, booleanArrayAddress(a, offset), offset,
+            normalized,  m, offsetInRange,
+            (arr, off, v, vm) -> v.stOp(arr, off, vm,
+                                        (arr_, off_, i, e) -> arr_[off_ + i] = (e & 1) != 0));
     }
 
     abstract
@@ -3876,17 +3904,13 @@ a, byteArrayAddress(a, offset),
     }
 
     abstract
-    void intoByteArray0(byte[] a, int offset, VectorMask<Byte> m);
+    void intoByteArray0(byte[] a, int offset, VectorMask<Byte> m, boolean offsetInRange);
     @ForceInline
     final
     <M extends VectorMask<Byte>>
-    void intoByteArray0Template(Class<M> maskClass, byte[] a, int offset, M m) {
-        ByteSpecies vsp = vspecies();
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
@@ -3909,16 +3933,16 @@ void intoByteBuffer0(ByteBuffer bb, int offset) {
     }
 
     abstract
-    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Byte> m);
+    void intoByteBuffer0(ByteBuffer bb, int offset, VectorMask<Byte> m, boolean offsetInRange);
     @ForceInline
     final
     <M extends VectorMask<Byte>>
-    void intoByteBuffer0Template(Class<M> maskClass, ByteBuffer bb, int offset, M m) {
+    void intoByteBuffer0Template(Class<M> maskClass, ByteBuffer bb, int offset, M m, boolean offsetInRange) {
         ByteSpecies vsp = vspecies();
         m.check(vsp);
         ScopedMemoryAccess.storeIntoByteBufferMasked(
                 vsp.vectorType(), maskClass, vsp.elementType(), vsp.laneCount(),
-                this, m, bb, offset,
+                this, m, offsetInRange, bb, offset,
                 (buf, off, v, vm) -> {
                     ByteBuffer wb = wrapper(buf, NATIVE_ENDIAN);
                     v.stOp(wb, off, vm,