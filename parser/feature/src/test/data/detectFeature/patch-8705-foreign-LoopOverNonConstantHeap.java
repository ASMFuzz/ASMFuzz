@@ -24,7 +24,6 @@
 
 import java.lang.foreign.MemorySegment;
 import java.lang.foreign.MemorySession;
-import java.lang.foreign.ValueLayout;
 import org.openjdk.jmh.annotations.Benchmark;
 import org.openjdk.jmh.annotations.BenchmarkMode;
 import org.openjdk.jmh.annotations.Fork;
@@ -38,7 +37,6 @@
 import org.openjdk.jmh.annotations.Warmup;
 import sun.misc.Unsafe;
 
-import java.lang.invoke.VarHandle;
 import java.nio.ByteBuffer;
 import java.nio.ByteOrder;
 import java.util.concurrent.TimeUnit;
@@ -54,19 +52,14 @@
 @State(org.openjdk.jmh.annotations.Scope.Thread)
 @OutputTimeUnit(TimeUnit.MILLISECONDS)
 @Fork(value = 3, jvmArgsAppend = "--enable-preview")
-public class LoopOverNonConstantHeap {
+public class LoopOverNonConstantHeap extends JavaLayouts {
 
     static final Unsafe unsafe = Utils.unsafe;
 
     static final int ELEM_SIZE = 1_000_000;
     static final int CARRIER_SIZE = (int)JAVA_INT.byteSize();
     static final int ALLOC_SIZE = ELEM_SIZE * CARRIER_SIZE;
     static final int UNSAFE_BYTE_BASE = unsafe.arrayBaseOffset(byte[].class);
-
-    static final VarHandle VH_INT = JAVA_INT.arrayElementVarHandle();
-
-    static final ValueLayout.OfInt JAVA_INT_UNALIGNED = JAVA_INT.withBitAlignment(8);
-    static final VarHandle VH_INT_UNALIGNED = JAVA_INT_UNALIGNED.arrayElementVarHandle();
     static final int UNSAFE_INT_BASE = unsafe.arrayBaseOffset(int[].class);
 
     MemorySegment segment, alignedSegment;
@@ -136,7 +129,7 @@ public int unsafe_loop() {
     }
 
     @Benchmark
-    public int segment_loop() {
+    public int segment_loop_unaligned() {
         int sum = 0;
         for (int i = 0; i < ELEM_SIZE; i++) {
             sum += (int) VH_INT_UNALIGNED.get(segment, (long) i);
@@ -145,7 +138,7 @@ public int segment_loop() {
     }
 
     @Benchmark
-    public int segment_loop_aligned() {
+    public int segment_loop() {
         int sum = 0;
         for (int i = 0; i < ELEM_SIZE; i++) {
             sum += (int) VH_INT.get(alignedSegment, (long) i);
@@ -154,7 +147,7 @@ public int segment_loop_aligned() {
     }
 
     @Benchmark
-    public int segment_loop_instance() {
+    public int segment_loop_instance_unaligned() {
         int res = 0;
         for (int i = 0; i < ELEM_SIZE; i ++) {
             res += segment.get(JAVA_INT_UNALIGNED, i * CARRIER_SIZE);
@@ -163,7 +156,7 @@ public int segment_loop_instance() {
     }
 
     @Benchmark
-    public int segment_loop_instance_aligned() {
+    public int segment_loop_instance() {
         int res = 0;
         for (int i = 0; i < ELEM_SIZE; i ++) {
             res += alignedSegment.get(JAVA_INT, i * CARRIER_SIZE);
@@ -174,19 +167,19 @@ public int segment_loop_instance_aligned() {
     @Benchmark
     public int segment_loop_slice() {
         int sum = 0;
-        MemorySegment base = segment.asSlice(0, segment.byteSize());
+        MemorySegment base = alignedSegment.asSlice(0, alignedSegment.byteSize());
         for (int i = 0; i < ELEM_SIZE; i++) {
-            sum += (int) VH_INT_UNALIGNED.get(base, (long) i);
+            sum += (int) VH_INT.get(base, (long) i);
         }
         return sum;
     }
 
     @Benchmark
     public int segment_loop_readonly() {
         int sum = 0;
-        MemorySegment base = segment.asReadOnly();
+        MemorySegment base = alignedSegment.asReadOnly();
         for (int i = 0; i < ELEM_SIZE; i++) {
-            sum += (int) VH_INT_UNALIGNED.get(base, (long) i);
+            sum += (int) VH_INT.get(base, (long) i);
         }
         return sum;
     }