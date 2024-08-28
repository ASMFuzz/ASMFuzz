@@ -22,7 +22,6 @@
  */
 package org.openjdk.bench.java.lang.foreign;
 
-import java.lang.foreign.MemoryLayout;
 import java.lang.foreign.MemorySession;
 import org.openjdk.jmh.annotations.Benchmark;
 import org.openjdk.jmh.annotations.BenchmarkMode;
@@ -38,12 +37,10 @@
 import sun.misc.Unsafe;
 
 import java.lang.foreign.MemorySegment;
-import java.lang.invoke.VarHandle;
 import java.nio.ByteBuffer;
 import java.nio.ByteOrder;
 import java.util.concurrent.TimeUnit;
 
-import static java.lang.foreign.MemoryLayout.PathElement.sequenceElement;
 import static java.lang.foreign.ValueLayout.JAVA_INT;
 
 @BenchmarkMode(Mode.AverageTime)
@@ -52,7 +49,7 @@
 @State(org.openjdk.jmh.annotations.Scope.Thread)
 @OutputTimeUnit(TimeUnit.MILLISECONDS)
 @Fork(value = 3, jvmArgsAppend = "--enable-preview")
-public class LoopOverConstant {
+public class LoopOverConstant extends JavaLayouts {
 
     static final Unsafe unsafe = Utils.unsafe;
 
@@ -73,11 +70,10 @@ public class LoopOverConstant {
     //setup native memory segment
 
     static final MemorySegment segment = MemorySegment.allocateNative(ALLOC_SIZE, MemorySession.openImplicit());
-    static final VarHandle VH_int = JAVA_INT.arrayElementVarHandle();
 
     static {
         for (int i = 0; i < ELEM_SIZE; i++) {
-            VH_int.set(segment, (long) i, i);
+            VH_INT.set(segment, (long) i, i);
         }
     }
 
@@ -100,7 +96,7 @@ public int unsafe_get() {
     @Benchmark
     @OutputTimeUnit(TimeUnit.NANOSECONDS)
     public int segment_get() {
-        return (int)VH_int.get(segment, 0L);
+        return (int)VH_INT.get(segment, 0L);
     }
 
     @Benchmark
@@ -122,7 +118,7 @@ public int unsafe_loop() {
     public int segment_loop() {
         int res = 0;
         for (int i = 0; i < ELEM_SIZE; i++) {
-            res += (int) VH_int.get(segment, (long)i);
+            res += (int) VH_INT.get(segment, (long)i);
         }
         return res;
     }