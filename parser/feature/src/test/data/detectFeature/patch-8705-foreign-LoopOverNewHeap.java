@@ -22,7 +22,6 @@
  */
 package org.openjdk.bench.java.lang.foreign;
 
-import java.lang.foreign.MemoryLayout;
 import java.lang.foreign.MemorySegment;
 import org.openjdk.jmh.annotations.Benchmark;
 import org.openjdk.jmh.annotations.BenchmarkMode;
@@ -38,11 +37,9 @@
 import org.openjdk.jmh.annotations.Warmup;
 import sun.misc.Unsafe;
 
-import java.lang.invoke.VarHandle;
 import java.nio.IntBuffer;
 import java.util.concurrent.TimeUnit;
 
-import static java.lang.foreign.MemoryLayout.PathElement.sequenceElement;
 import static java.lang.foreign.ValueLayout.JAVA_INT;
 
 @BenchmarkMode(Mode.AverageTime)
@@ -51,15 +48,13 @@
 @State(org.openjdk.jmh.annotations.Scope.Thread)
 @OutputTimeUnit(TimeUnit.MILLISECONDS)
 @Fork(value = 3, jvmArgsAppend = "--enable-preview")
-public class LoopOverNewHeap {
+public class LoopOverNewHeap extends JavaLayouts {
 
     static final Unsafe unsafe = Utils.unsafe;
 
     static final int ELEM_SIZE = 1_000_000;
     static final int CARRIER_SIZE = (int)JAVA_INT.byteSize();
 
-    static final VarHandle VH_int = JAVA_INT.arrayElementVarHandle();
-
     @Param(value = {"false", "true"})
     boolean polluteProfile;
 
@@ -88,7 +83,7 @@ public void unsafe_loop() {
     public void segment_loop() {
         MemorySegment segment = MemorySegment.ofArray(new int[ELEM_SIZE]);
         for (int i = 0; i < ELEM_SIZE; i++) {
-            VH_int.set(segment, (long) i, i);
+            VH_INT.set(segment, (long) i, i);
         }
     }
 
@@ -97,7 +92,7 @@ public void segment_loop() {
     public void segment_loop_dontinline() {
         MemorySegment segment = MemorySegment.ofArray(new int[ELEM_SIZE]);
         for (int i = 0; i < ELEM_SIZE; i++) {
-            VH_int.set(segment, (long) i, i);
+            VH_INT.set(segment, (long) i, i);
         }
     }
 