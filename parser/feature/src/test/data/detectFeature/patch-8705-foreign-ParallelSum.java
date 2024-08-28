@@ -40,7 +40,6 @@
 import org.openjdk.jmh.annotations.Warmup;
 
 import java.lang.foreign.MemorySegment;
-import java.lang.invoke.VarHandle;
 import java.util.LinkedList;
 import java.util.List;
 import java.util.Optional;
@@ -51,21 +50,17 @@
 import java.util.function.Predicate;
 import java.util.function.ToIntFunction;
 
-import static java.lang.foreign.MemoryLayout.PathElement.sequenceElement;
-import static java.lang.foreign.ValueLayout.JAVA_INT;
-
 @BenchmarkMode(Mode.AverageTime)
 @Warmup(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
 @Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
 @State(org.openjdk.jmh.annotations.Scope.Thread)
 @OutputTimeUnit(TimeUnit.MILLISECONDS)
 @Fork(value = 3, jvmArgsAppend = "--enable-preview")
-public class ParallelSum {
+public class ParallelSum extends JavaLayouts {
 
     final static int CARRIER_SIZE = 4;
     final static int ALLOC_SIZE = CARRIER_SIZE * 1024 * 1024 * 256;
     final static int ELEM_SIZE = ALLOC_SIZE / CARRIER_SIZE;
-    static final VarHandle VH_int = JAVA_INT.arrayElementVarHandle();
 
     final static MemoryLayout ELEM_LAYOUT = ValueLayout.JAVA_INT;
     final static int BULK_FACTOR = 512;
@@ -84,7 +79,7 @@ public void setup() {
         }
         segment = MemorySegment.allocateNative(ALLOC_SIZE, CARRIER_SIZE, MemorySession.openShared());
         for (int i = 0; i < ELEM_SIZE; i++) {
-            VH_int.set(segment, (long) i, i);
+            VH_INT.set(segment, (long) i, i);
         }
     }
 
@@ -98,7 +93,7 @@ public void tearDown() throws Throwable {
     public int segment_serial() {
         int res = 0;
         for (int i = 0; i < ELEM_SIZE; i++) {
-            res += (int)VH_int.get(segment, (long) i);
+            res += (int)VH_INT.get(segment, (long) i);
         }
         return res;
     }
@@ -133,12 +128,12 @@ public int segment_stream_parallel_bulk() {
     }
 
     final static ToIntFunction<MemorySegment> SEGMENT_TO_INT = slice ->
-            (int) VH_int.get(slice, 0L);
+            (int) VH_INT.get(slice, 0L);
 
     final static ToIntFunction<MemorySegment> SEGMENT_TO_INT_BULK = slice -> {
         int res = 0;
         for (int i = 0; i < BULK_FACTOR ; i++) {
-            res += (int)VH_int.get(slice, (long) i);
+            res += (int)VH_INT.get(slice, (long) i);
         }
         return res;
     };
@@ -172,11 +167,11 @@ public Optional<MemorySegment> segment_stream_findany_parallel_bulk() {
     }
 
     final static Predicate<MemorySegment> FIND_SINGLE = slice ->
-            (int)VH_int.get(slice, 0L) == (ELEM_SIZE - 1);
+            (int)VH_INT.get(slice, 0L) == (ELEM_SIZE - 1);
 
     final static Predicate<MemorySegment> FIND_BULK = slice -> {
         for (int i = 0; i < BULK_FACTOR ; i++) {
-            if ((int)VH_int.get(slice, (long)i) == (ELEM_SIZE - 1)) {
+            if ((int)VH_INT.get(slice, (long)i) == (ELEM_SIZE - 1)) {
                 return true;
             }
         }