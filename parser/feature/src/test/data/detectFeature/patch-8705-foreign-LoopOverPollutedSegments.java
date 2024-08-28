@@ -22,7 +22,6 @@
  */
 package org.openjdk.bench.java.lang.foreign;
 
-import java.lang.foreign.MemoryLayout;
 import java.lang.foreign.MemorySegment;
 import java.lang.foreign.MemorySession;
 import org.openjdk.jmh.annotations.Benchmark;
@@ -37,11 +36,8 @@
 import org.openjdk.jmh.annotations.Warmup;
 import sun.misc.Unsafe;
 
-import java.lang.foreign.ValueLayout;
-import java.lang.invoke.VarHandle;
 import java.util.concurrent.TimeUnit;
 
-import static java.lang.foreign.ValueLayout.JAVA_FLOAT;
 import static java.lang.foreign.ValueLayout.JAVA_INT;
 
 @BenchmarkMode(Mode.AverageTime)
@@ -50,7 +46,7 @@
 @State(org.openjdk.jmh.annotations.Scope.Thread)
 @OutputTimeUnit(TimeUnit.MILLISECONDS)
 @Fork(value = 3, jvmArgsAppend = "--enable-preview")
-public class LoopOverPollutedSegments {
+public class LoopOverPollutedSegments extends JavaLayouts {
 
     static final int ELEM_SIZE = 1_000_000;
     static final int CARRIER_SIZE = (int) JAVA_INT.byteSize();
@@ -64,11 +60,6 @@ public class LoopOverPollutedSegments {
     byte[] arr;
     long addr;
 
-    static final ValueLayout.OfInt JAVA_INT_UNALIGNED = JAVA_INT.withBitAlignment(8);
-    static final ValueLayout.OfFloat JAVA_FLOAT_UNALIGNED = JAVA_FLOAT.withBitAlignment(8);
-    static final VarHandle intHandleUnaligned = JAVA_INT_UNALIGNED.arrayElementVarHandle();
-
-
     @Setup
     public void setup() {
         addr = unsafe.allocateMemory(ALLOC_SIZE);
@@ -88,13 +79,13 @@ public void setup() {
                 nativeSegment.setAtIndex(JAVA_FLOAT_UNALIGNED, i, i);
                 nativeSharedSegment.setAtIndex(JAVA_INT_UNALIGNED, i, i);
                 nativeSharedSegment.setAtIndex(JAVA_FLOAT_UNALIGNED, i, i);
-                intHandleUnaligned.set(nativeSegment, (long)i, i);
+                VH_INT_UNALIGNED.set(nativeSegment, (long)i, i);
                 heapSegmentBytes.setAtIndex(JAVA_INT_UNALIGNED, i, i);
                 heapSegmentBytes.setAtIndex(JAVA_FLOAT_UNALIGNED, i, i);
-                intHandleUnaligned.set(heapSegmentBytes, (long)i, i);
+                VH_INT_UNALIGNED.set(heapSegmentBytes, (long)i, i);
                 heapSegmentFloats.setAtIndex(JAVA_INT_UNALIGNED, i, i);
                 heapSegmentFloats.setAtIndex(JAVA_FLOAT_UNALIGNED, i, i);
-                intHandleUnaligned.set(heapSegmentFloats, (long)i, i);
+                VH_INT_UNALIGNED.set(heapSegmentFloats, (long)i, i);
             }
         }
     }
@@ -112,8 +103,8 @@ public void tearDown() {
     public int native_segment_VH() {
         int sum = 0;
         for (int k = 0; k < ELEM_SIZE; k++) {
-            intHandleUnaligned.set(nativeSegment, (long)k, k + 1);
-            int v = (int) intHandleUnaligned.get(nativeSegment, (long)k);
+            VH_INT_UNALIGNED.set(nativeSegment, (long)k, k + 1);
+            int v = (int) VH_INT_UNALIGNED.get(nativeSegment, (long)k);
             sum += v;
         }
         return sum;
@@ -134,8 +125,8 @@ public int native_segment_instance() {
     public int heap_segment_ints_VH() {
         int sum = 0;
         for (int k = 0; k < ELEM_SIZE; k++) {
-            intHandleUnaligned.set(heapSegmentBytes, (long)k, k + 1);
-            int v = (int) intHandleUnaligned.get(heapSegmentBytes, (long)k);
+            VH_INT_UNALIGNED.set(heapSegmentBytes, (long)k, k + 1);
+            int v = (int) VH_INT_UNALIGNED.get(heapSegmentBytes, (long)k);
             sum += v;
         }
         return sum;
@@ -156,8 +147,8 @@ public int heap_segment_ints_instance() {
     public int heap_segment_floats_VH() {
         int sum = 0;
         for (int k = 0; k < ELEM_SIZE; k++) {
-            intHandleUnaligned.set(heapSegmentFloats, (long)k, k + 1);
-            int v = (int)intHandleUnaligned.get(heapSegmentFloats, (long)k);
+            VH_INT_UNALIGNED.set(heapSegmentFloats, (long)k, k + 1);
+            int v = (int)VH_INT_UNALIGNED.get(heapSegmentFloats, (long)k);
             sum += v;
         }
         return sum;