@@ -22,8 +22,6 @@
  */
 package org.openjdk.bench.java.lang.foreign;
 
-import java.lang.foreign.MemoryAddress;
-import java.lang.foreign.MemoryLayout;
 import java.lang.foreign.MemorySegment;
 import java.lang.foreign.MemorySession;
 import org.openjdk.jmh.annotations.Benchmark;
@@ -38,13 +36,10 @@
 import org.openjdk.jmh.annotations.Warmup;
 import sun.misc.Unsafe;
 
-import java.lang.foreign.ValueLayout;
-import java.lang.invoke.VarHandle;
 import java.nio.ByteBuffer;
 import java.nio.ByteOrder;
 import java.util.concurrent.TimeUnit;
 
-import static java.lang.foreign.MemoryLayout.PathElement.sequenceElement;
 import static java.lang.foreign.ValueLayout.JAVA_INT;
 
 @BenchmarkMode(Mode.AverageTime)
@@ -53,19 +48,13 @@
 @State(org.openjdk.jmh.annotations.Scope.Thread)
 @OutputTimeUnit(TimeUnit.MILLISECONDS)
 @Fork(value = 3, jvmArgsAppend = { "--enable-preview", "--enable-native-access=ALL-UNNAMED" })
-public class LoopOverNonConstant {
+public class LoopOverNonConstant extends JavaLayouts {
 
     static final Unsafe unsafe = Utils.unsafe;
 
     static final int ELEM_SIZE = 1_000_000;
     static final int CARRIER_SIZE = (int)JAVA_INT.byteSize();
     static final int ALLOC_SIZE = ELEM_SIZE * CARRIER_SIZE;
-
-    static final VarHandle VH_int = JAVA_INT.arrayElementVarHandle();
-
-    static final ValueLayout.OfInt JAVA_INT_ALIGNED = JAVA_INT.withBitAlignment(32);
-    static final VarHandle VH_int_aligned = JAVA_INT_ALIGNED.arrayElementVarHandle();
-
     MemorySegment segment;
     long unsafe_addr;
 
@@ -79,7 +68,7 @@ public void setup() {
         }
         segment = MemorySegment.allocateNative(ALLOC_SIZE, MemorySession.openConfined());
         for (int i = 0; i < ELEM_SIZE; i++) {
-            VH_int.set(segment, (long) i, i);
+            VH_INT.set(segment, (long) i, i);
         }
         byteBuffer = ByteBuffer.allocateDirect(ALLOC_SIZE).order(ByteOrder.nativeOrder());
         for (int i = 0; i < ELEM_SIZE; i++) {
@@ -103,7 +92,7 @@ public int unsafe_get() {
     @Benchmark
     @OutputTimeUnit(TimeUnit.NANOSECONDS)
     public int segment_get() {
-        return (int) VH_int.get(segment, 0L);
+        return (int) VH_INT.get(segment, 0L);
     }
 
     @Benchmark
@@ -125,16 +114,16 @@ public int unsafe_loop() {
     public int segment_loop() {
         int sum = 0;
         for (int i = 0; i < ELEM_SIZE; i++) {
-            sum += (int) VH_int.get(segment, (long) i);
+            sum += (int) VH_INT.get(segment, (long) i);
         }
         return sum;
     }
 
     @Benchmark
-    public int segment_loop_aligned() {
+    public int segment_loop_unaligned() {
         int sum = 0;
         for (int i = 0; i < ELEM_SIZE; i++) {
-            sum += (int) VH_int_aligned.get(segment, (long) i);
+            sum += (int) VH_INT_UNALIGNED.get(segment, (long) i);
         }
         return sum;
     }
@@ -160,10 +149,10 @@ public int segment_loop_instance_index() {
     }
 
     @Benchmark
-    public int segment_loop_instance_aligned() {
+    public int segment_loop_instance_unaligned() {
         int res = 0;
         for (int i = 0; i < ELEM_SIZE; i ++) {
-            res += segment.get(JAVA_INT_ALIGNED, i * CARRIER_SIZE);
+            res += segment.get(JAVA_INT_UNALIGNED, i * CARRIER_SIZE);
         }
         return res;
     }
@@ -191,7 +180,7 @@ public int segment_loop_slice() {
         int sum = 0;
         MemorySegment base = segment.asSlice(0, segment.byteSize());
         for (int i = 0; i < ELEM_SIZE; i++) {
-            sum += (int) VH_int.get(base, (long) i);
+            sum += (int) VH_INT.get(base, (long) i);
         }
         return sum;
     }
@@ -201,7 +190,7 @@ public int segment_loop_readonly() {
         int sum = 0;
         MemorySegment base = segment.asReadOnly();
         for (int i = 0; i < ELEM_SIZE; i++) {
-            sum += (int) VH_int.get(base, (long) i);
+            sum += (int) VH_INT.get(base, (long) i);
         }
         return sum;
     }