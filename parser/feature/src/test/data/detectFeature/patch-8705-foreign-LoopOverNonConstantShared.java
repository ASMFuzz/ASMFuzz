@@ -22,7 +22,6 @@
  */
 package org.openjdk.bench.java.lang.foreign;
 
-import java.lang.foreign.MemoryLayout;
 import java.lang.foreign.MemorySegment;
 import java.lang.foreign.MemorySession;
 import org.openjdk.jmh.annotations.Benchmark;
@@ -37,12 +36,10 @@
 import org.openjdk.jmh.annotations.Warmup;
 import sun.misc.Unsafe;
 
-import java.lang.invoke.VarHandle;
 import java.nio.ByteBuffer;
 import java.nio.ByteOrder;
 import java.util.concurrent.TimeUnit;
 
-import static java.lang.foreign.MemoryLayout.PathElement.sequenceElement;
 import static java.lang.foreign.ValueLayout.JAVA_INT;
 
 @BenchmarkMode(Mode.AverageTime)
@@ -51,15 +48,13 @@
 @State(org.openjdk.jmh.annotations.Scope.Thread)
 @OutputTimeUnit(TimeUnit.MILLISECONDS)
 @Fork(value = 3, jvmArgsAppend = "--enable-preview")
-public class LoopOverNonConstantShared {
+public class LoopOverNonConstantShared extends JavaLayouts {
 
     static final Unsafe unsafe = Utils.unsafe;
 
     static final int ELEM_SIZE = 1_000_000;
     static final int CARRIER_SIZE = (int)JAVA_INT.byteSize();
     static final int ALLOC_SIZE = ELEM_SIZE * CARRIER_SIZE;
-
-    static final VarHandle VH_int = JAVA_INT.arrayElementVarHandle();
     MemorySegment segment;
     long unsafe_addr;
 
@@ -73,7 +68,7 @@ public void setup() {
         }
         segment = MemorySegment.allocateNative(ALLOC_SIZE, CARRIER_SIZE, MemorySession.openConfined());
         for (int i = 0; i < ELEM_SIZE; i++) {
-            VH_int.set(segment, (long) i, i);
+            VH_INT.set(segment, (long) i, i);
         }
         byteBuffer = ByteBuffer.allocateDirect(ALLOC_SIZE).order(ByteOrder.nativeOrder());
         for (int i = 0; i < ELEM_SIZE; i++) {
@@ -97,7 +92,7 @@ public int unsafe_get() {
     @Benchmark
     @OutputTimeUnit(TimeUnit.NANOSECONDS)
     public int segment_get() {
-        return (int) VH_int.get(segment, 0L);
+        return (int) VH_INT.get(segment, 0L);
     }
 
     @Benchmark
@@ -137,7 +132,7 @@ public int segment_loop_instance_address() {
     public int segment_loop() {
         int sum = 0;
         for (int i = 0; i < ELEM_SIZE; i++) {
-            sum += (int) VH_int.get(segment, (long) i);
+            sum += (int) VH_INT.get(segment, (long) i);
         }
         return sum;
     }
@@ -147,7 +142,7 @@ public int segment_loop_slice() {
         int sum = 0;
         MemorySegment base = segment.asSlice(0, segment.byteSize());
         for (int i = 0; i < ELEM_SIZE; i++) {
-            sum += (int) VH_int.get(base, (long) i);
+            sum += (int) VH_INT.get(base, (long) i);
         }
         return sum;
     }
@@ -157,7 +152,7 @@ public int segment_loop_readonly() {
         int sum = 0;
         MemorySegment base = segment.asReadOnly();
         for (int i = 0; i < ELEM_SIZE; i++) {
-            sum += (int) VH_int.get(base, (long) i);
+            sum += (int) VH_INT.get(base, (long) i);
         }
         return sum;
     }