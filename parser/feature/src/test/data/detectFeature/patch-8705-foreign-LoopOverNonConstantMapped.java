@@ -22,7 +22,6 @@
  */
 package org.openjdk.bench.java.lang.foreign;
 
-import java.lang.foreign.MemoryLayout;
 import java.lang.foreign.MemorySegment;
 import java.lang.foreign.MemorySession;
 import org.openjdk.jmh.annotations.Benchmark;
@@ -39,7 +38,6 @@
 
 import java.io.File;
 import java.io.IOException;
-import java.lang.invoke.VarHandle;
 import java.nio.ByteBuffer;
 import java.nio.ByteOrder;
 import java.nio.MappedByteBuffer;
@@ -49,7 +47,6 @@
 import java.nio.file.StandardOpenOption;
 import java.util.concurrent.TimeUnit;
 
-import static java.lang.foreign.MemoryLayout.PathElement.sequenceElement;
 import static java.lang.foreign.ValueLayout.JAVA_INT;
 
 @BenchmarkMode(Mode.AverageTime)
@@ -58,7 +55,7 @@
 @State(org.openjdk.jmh.annotations.Scope.Thread)
 @OutputTimeUnit(TimeUnit.MILLISECONDS)
 @Fork(value = 3, jvmArgsAppend = "--enable-preview")
-public class LoopOverNonConstantMapped {
+public class LoopOverNonConstantMapped extends JavaLayouts {
 
     static final Unsafe unsafe = Utils.unsafe;
 
@@ -80,7 +77,6 @@ public class LoopOverNonConstantMapped {
         }
     }
 
-    static final VarHandle VH_int = JAVA_INT.arrayElementVarHandle();
     FileChannel fileChannel;
     MemorySegment segment;
     long unsafe_addr;
@@ -117,7 +113,7 @@ public int unsafe_get() {
     @Benchmark
     @OutputTimeUnit(TimeUnit.NANOSECONDS)
     public int segment_get() {
-        return (int) VH_int.get(segment, 0L);
+        return (int) VH_INT.get(segment, 0L);
     }
 
     @Benchmark
@@ -139,7 +135,7 @@ public int unsafe_loop() {
     public int segment_loop() {
         int sum = 0;
         for (int i = 0; i < ELEM_SIZE; i++) {
-            sum += (int) VH_int.get(segment, (long) i);
+            sum += (int) VH_INT.get(segment, (long) i);
         }
         return sum;
     }
@@ -167,7 +163,7 @@ public int segment_loop_slice() {
         int sum = 0;
         MemorySegment base = segment.asSlice(0, segment.byteSize());
         for (int i = 0; i < ELEM_SIZE; i++) {
-            sum += (int) VH_int.get(base, (long) i);
+            sum += (int) VH_INT.get(base, (long) i);
         }
         return sum;
     }
@@ -177,7 +173,7 @@ public int segment_loop_readonly() {
         int sum = 0;
         MemorySegment base = segment.asReadOnly();
         for (int i = 0; i < ELEM_SIZE; i++) {
-            sum += (int) VH_int.get(base, (long) i);
+            sum += (int) VH_INT.get(base, (long) i);
         }
         return sum;
     }