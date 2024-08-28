@@ -38,12 +38,10 @@
 import org.openjdk.jmh.annotations.Warmup;
 import sun.misc.Unsafe;
 
-import java.lang.invoke.VarHandle;
 import java.nio.ByteBuffer;
 import java.nio.ByteOrder;
 import java.util.concurrent.TimeUnit;
 
-import static java.lang.foreign.MemoryLayout.PathElement.sequenceElement;
 import static java.lang.foreign.ValueLayout.JAVA_INT;
 
 @BenchmarkMode(Mode.AverageTime)
@@ -52,17 +50,14 @@
 @State(org.openjdk.jmh.annotations.Scope.Thread)
 @OutputTimeUnit(TimeUnit.MILLISECONDS)
 @Fork(value = 3, jvmArgsAppend = "--enable-preview")
-public class LoopOverNew {
+public class LoopOverNew extends JavaLayouts {
 
     static final Unsafe unsafe = Utils.unsafe;
 
     static final int ELEM_SIZE = 1_000_000;
     static final int CARRIER_SIZE = (int)JAVA_INT.byteSize();
     static final int ALLOC_SIZE = ELEM_SIZE * CARRIER_SIZE;
     static final MemoryLayout ALLOC_LAYOUT = MemoryLayout.sequenceLayout(ELEM_SIZE, JAVA_INT);
-
-    static final VarHandle VH_int = JAVA_INT.arrayElementVarHandle();
-
     final MemorySession session = MemorySession.openConfined();
     final SegmentAllocator recyclingAlloc = SegmentAllocator.prefixAllocator(MemorySegment.allocateNative(ALLOC_LAYOUT, session));
 
@@ -85,7 +80,7 @@ public void segment_loop_confined() {
         try (MemorySession session = MemorySession.openConfined()) {
             MemorySegment segment = MemorySegment.allocateNative(ALLOC_SIZE, 4, session);
             for (int i = 0; i < ELEM_SIZE; i++) {
-                VH_int.set(segment, (long) i, i);
+                VH_INT.set(segment, (long) i, i);
             }
         }
     }
@@ -95,7 +90,7 @@ public void segment_loop_shared() {
         try (MemorySession session = MemorySession.openShared()) {
             MemorySegment segment = MemorySegment.allocateNative(ALLOC_SIZE, 4, session);
             for (int i = 0; i < ELEM_SIZE; i++) {
-                VH_int.set(segment, (long) i, i);
+                VH_INT.set(segment, (long) i, i);
             }
         }
     }
@@ -104,7 +99,7 @@ public void segment_loop_shared() {
     public void segment_loop_recycle() {
         MemorySegment segment = recyclingAlloc.allocate(ALLOC_SIZE, 4);
         for (int i = 0; i < ELEM_SIZE; i++) {
-            VH_int.set(segment, (long) i, i);
+            VH_INT.set(segment, (long) i, i);
         }
     }
 
@@ -140,7 +135,7 @@ public void segment_loop_implicit() {
         if (gcCount++ == 0) System.gc(); // GC when we overflow
         MemorySegment segment = MemorySegment.allocateNative(ALLOC_SIZE, 4, MemorySession.openImplicit());
         for (int i = 0; i < ELEM_SIZE; i++) {
-            VH_int.set(segment, (long) i, i);
+            VH_INT.set(segment, (long) i, i);
         }
     }
 }