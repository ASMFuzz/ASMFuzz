@@ -25,6 +25,8 @@
  */
 package jdk.internal.foreign;
 
+import jdk.internal.vm.annotation.ForceInline;
+
 import java.lang.foreign.GroupLayout;
 import java.lang.foreign.MemoryLayout;
 import java.lang.foreign.MemorySegment;
@@ -34,6 +36,8 @@
 import java.lang.invoke.MethodHandles;
 import java.lang.invoke.MethodType;
 import java.lang.invoke.VarHandle;
+import java.util.Arrays;
+import java.util.Objects;
 import java.util.function.UnaryOperator;
 
 /**
@@ -53,7 +57,7 @@ public class LayoutPath {
         try {
             MethodHandles.Lookup lookup = MethodHandles.lookup();
             MH_ADD_SCALED_OFFSET = lookup.findStatic(LayoutPath.class, "addScaledOffset",
-                    MethodType.methodType(long.class, long.class, long.class, long.class));
+                    MethodType.methodType(long.class, long.class, long.class, long.class, long.class));
             MH_SLICE = lookup.findVirtual(MemorySegment.class, "asSlice",
                     MethodType.methodType(MemorySegment.class, long.class, long.class));
         } catch (Throwable ex) {
@@ -66,10 +70,13 @@ public class LayoutPath {
     private final LayoutPath enclosing;
     private final long[] strides;
 
-    private LayoutPath(MemoryLayout layout, long offset, long[] strides, LayoutPath enclosing) {
+    private final long[] bounds;
+
+    private LayoutPath(MemoryLayout layout, long offset, long[] strides, long[] bounds, LayoutPath enclosing) {
         this.layout = layout;
         this.offset = offset;
         this.strides = strides;
+        this.bounds = bounds;
         this.enclosing = enclosing;
     }
 
@@ -79,7 +86,7 @@ public LayoutPath sequenceElement() {
         check(SequenceLayout.class, "attempting to select a sequence element from a non-sequence layout");
         SequenceLayout seq = (SequenceLayout)layout;
         MemoryLayout elem = seq.elementLayout();
-        return LayoutPath.nestedPath(elem, offset, addStride(elem.bitSize()), this);
+        return LayoutPath.nestedPath(elem, offset, addStride(elem.bitSize()), addBound(seq.elementCount()), this);
     }
 
     public LayoutPath sequenceElement(long start, long step) {
@@ -88,20 +95,21 @@ public LayoutPath sequenceElement(long start, long step) {
         checkSequenceBounds(seq, start);
         MemoryLayout elem = seq.elementLayout();
         long elemSize = elem.bitSize();
-        return LayoutPath.nestedPath(elem, offset + (start * elemSize), addStride(elemSize * step), this);
+        long nelems = step > 0 ?
+                seq.elementCount() - start :
+                start + 1;
+        long maxIndex = Math.ceilDiv(nelems, Math.abs(step));
+        return LayoutPath.nestedPath(elem, offset + (start * elemSize),
+                                     addStride(elemSize * step), addBound(maxIndex), this);
     }
 
     public LayoutPath sequenceElement(long index) {
         check(SequenceLayout.class, "attempting to select a sequence element from a non-sequence layout");
         SequenceLayout seq = (SequenceLayout)layout;
         checkSequenceBounds(seq, index);
-        long elemOffset = 0;
-        if (index > 0) {
-            //if index == 0, we do not depend on sequence element size, so skip
-            long elemSize = seq.elementLayout().bitSize();
-            elemOffset = elemSize * index;
-        }
-        return LayoutPath.nestedPath(seq.elementLayout(), offset + elemOffset, strides, this);
+        long elemSize = seq.elementLayout().bitSize();
+        long elemOffset = elemSize * index;
+        return LayoutPath.nestedPath(seq.elementLayout(), offset + elemOffset, strides, bounds, this);
     }
 
     public LayoutPath groupElement(String name) {
@@ -122,7 +130,7 @@ public LayoutPath groupElement(String name) {
         if (elem == null) {
             throw badLayoutPath("cannot resolve '" + name + "' in layout " + layout);
         }
-        return LayoutPath.nestedPath(elem, this.offset + offset, strides, this);
+        return LayoutPath.nestedPath(elem, this.offset + offset, strides, bounds, this);
     }
 
     // Layout path projections
@@ -140,7 +148,8 @@ public VarHandle dereferenceHandle() {
         VarHandle handle = Utils.makeSegmentViewVarHandle(valueLayout);
         for (int i = strides.length - 1; i >= 0; i--) {
             MethodHandle collector = MethodHandles.insertArguments(MH_ADD_SCALED_OFFSET, 2,
-                    Utils.bitsToBytesOrThrow(strides[i], IllegalArgumentException::new));
+                    Utils.bitsToBytesOrThrow(strides[i], IllegalArgumentException::new),
+                    bounds[i]);
             // (J, ...) -> J to (J, J, ...) -> J
             // i.e. new coord is prefixed. Last coord will correspond to innermost layout
             handle = MethodHandles.collectCoordinates(handle, 1, collector);
@@ -150,14 +159,16 @@ public VarHandle dereferenceHandle() {
         return handle;
     }
 
-    private static long addScaledOffset(long base, long index, long stride) {
+    @ForceInline
+    private static long addScaledOffset(long base, long index, long stride, long bound) {
+        Objects.checkIndex(index, bound);
         return base + (stride * index);
     }
 
     public MethodHandle offsetHandle() {
         MethodHandle mh = MethodHandles.identity(long.class);
         for (int i = strides.length - 1; i >=0; i--) {
-            MethodHandle collector = MethodHandles.insertArguments(MH_ADD_SCALED_OFFSET, 2, strides[i]);
+            MethodHandle collector = MethodHandles.insertArguments(MH_ADD_SCALED_OFFSET, 2, strides[i], bounds[i]);
             // (J, ...) -> J to (J, J, ...) -> J
             // i.e. new coord is prefixed. Last coord will correspond to innermost layout
             mh = MethodHandles.collectArguments(mh, 0, collector);
@@ -189,11 +200,11 @@ public MemoryLayout layout() {
     // Layout path construction
 
     public static LayoutPath rootPath(MemoryLayout layout) {
-        return new LayoutPath(layout, 0L, EMPTY_STRIDES, null);
+        return new LayoutPath(layout, 0L, EMPTY_STRIDES, EMPTY_BOUNDS, null);
     }
 
-    private static LayoutPath nestedPath(MemoryLayout layout, long offset, long[] strides, LayoutPath encl) {
-        return new LayoutPath(layout, offset, strides, encl);
+    private static LayoutPath nestedPath(MemoryLayout layout, long offset, long[] strides, long[] bounds, LayoutPath encl) {
+        return new LayoutPath(layout, offset, strides, bounds, encl);
     }
 
     // Helper methods
@@ -235,13 +246,19 @@ private static void checkAlignment(LayoutPath path) {
     }
 
     private long[] addStride(long stride) {
-        long[] newStrides = new long[strides.length + 1];
-        System.arraycopy(strides, 0, newStrides, 0, strides.length);
+        long[] newStrides = Arrays.copyOf(strides, strides.length + 1);
         newStrides[strides.length] = stride;
         return newStrides;
     }
 
+    private long[] addBound(long maxIndex) {
+        long[] newBounds = Arrays.copyOf(bounds, bounds.length + 1);
+        newBounds[bounds.length] = maxIndex;
+        return newBounds;
+    }
+
     private static final long[] EMPTY_STRIDES = new long[0];
+    private static final long[] EMPTY_BOUNDS = new long[0];
 
     /**
      * This class provides an immutable implementation for the {@code PathElement} interface. A path element implementation