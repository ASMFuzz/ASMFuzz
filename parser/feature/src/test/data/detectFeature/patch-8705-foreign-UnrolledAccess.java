@@ -31,8 +31,6 @@
 import sun.misc.Unsafe;
 import java.util.concurrent.TimeUnit;
 
-import java.lang.invoke.VarHandle;
-
 import static java.lang.foreign.ValueLayout.JAVA_LONG;
 
 @BenchmarkMode(Mode.AverageTime)
@@ -41,20 +39,12 @@
 @State(org.openjdk.jmh.annotations.Scope.Thread)
 @OutputTimeUnit(TimeUnit.MICROSECONDS)
 @Fork(value = 3, jvmArgsAppend = { "--enable-preview", "--enable-native-access=ALL-UNNAMED" })
-public class UnrolledAccess {
+public class UnrolledAccess extends JavaLayouts {
 
     static final Unsafe U = Utils.unsafe;
 
     final static int SIZE = 1024;
 
-    static final ValueLayout.OfLong JAVA_LONG_UNALIGNED = JAVA_LONG.withBitAlignment(8);
-
-    static final VarHandle LONG_HANDLE = MemoryLayout.sequenceLayout(SIZE, JAVA_LONG)
-            .varHandle(MemoryLayout.PathElement.sequenceElement());
-
-    static final VarHandle LONG_HANDLE_UNALIGNED = MemoryLayout.sequenceLayout(SIZE, JAVA_LONG_UNALIGNED)
-            .varHandle(MemoryLayout.PathElement.sequenceElement());
-
     @State(Scope.Benchmark)
     public static class Data {
 
@@ -94,10 +84,10 @@ public void handle_loop(Data state) {
         final MemorySegment os = state.outputSegment;
 
         for(int i = 0; i < SIZE; i+=4) {
-            LONG_HANDLE.set(os, (long) (i),   (long) LONG_HANDLE.get(is, (long) (i))   + (long) LONG_HANDLE.get(os, (long) (i)));
-            LONG_HANDLE.set(os, (long) (i+1), (long) LONG_HANDLE.get(is, (long) (i+1)) + (long) LONG_HANDLE.get(os, (long) (i+1)));
-            LONG_HANDLE.set(os, (long) (i+2), (long) LONG_HANDLE.get(is, (long) (i+2)) + (long) LONG_HANDLE.get(os, (long) (i+2)));
-            LONG_HANDLE.set(os, (long) (i+3), (long) LONG_HANDLE.get(is, (long) (i+3)) + (long) LONG_HANDLE.get(os, (long) (i+3)));
+            VH_LONG.set(os, (long) (i),   (long) VH_LONG.get(is, (long) (i))   + (long) VH_LONG.get(os, (long) (i)));
+            VH_LONG.set(os, (long) (i+1), (long) VH_LONG.get(is, (long) (i+1)) + (long) VH_LONG.get(os, (long) (i+1)));
+            VH_LONG.set(os, (long) (i+2), (long) VH_LONG.get(is, (long) (i+2)) + (long) VH_LONG.get(os, (long) (i+2)));
+            VH_LONG.set(os, (long) (i+3), (long) VH_LONG.get(is, (long) (i+3)) + (long) VH_LONG.get(os, (long) (i+3)));
         }
     }
 
@@ -120,10 +110,10 @@ public void handle_loop_unaligned(Data state) {
         final MemorySegment os = state.outputSegment;
 
         for(int i = 0; i < SIZE; i+=4) {
-            LONG_HANDLE_UNALIGNED.set(os, (long) (i),   (long) LONG_HANDLE_UNALIGNED.get(is, (long) (i))   + (long) LONG_HANDLE_UNALIGNED.get(os, (long) (i)));
-            LONG_HANDLE_UNALIGNED.set(os, (long) (i+1), (long) LONG_HANDLE_UNALIGNED.get(is, (long) (i+1)) + (long) LONG_HANDLE_UNALIGNED.get(os, (long) (i+1)));
-            LONG_HANDLE_UNALIGNED.set(os, (long) (i+2), (long) LONG_HANDLE_UNALIGNED.get(is, (long) (i+2)) + (long) LONG_HANDLE_UNALIGNED.get(os, (long) (i+2)));
-            LONG_HANDLE_UNALIGNED.set(os, (long) (i+3), (long) LONG_HANDLE_UNALIGNED.get(is, (long) (i+3)) + (long) LONG_HANDLE_UNALIGNED.get(os, (long) (i+3)));
+            VH_LONG_UNALIGNED.set(os, (long) (i),   (long) VH_LONG_UNALIGNED.get(is, (long) (i))   + (long) VH_LONG_UNALIGNED.get(os, (long) (i)));
+            VH_LONG_UNALIGNED.set(os, (long) (i+1), (long) VH_LONG_UNALIGNED.get(is, (long) (i+1)) + (long) VH_LONG_UNALIGNED.get(os, (long) (i+1)));
+            VH_LONG_UNALIGNED.set(os, (long) (i+2), (long) VH_LONG_UNALIGNED.get(is, (long) (i+2)) + (long) VH_LONG_UNALIGNED.get(os, (long) (i+2)));
+            VH_LONG_UNALIGNED.set(os, (long) (i+3), (long) VH_LONG_UNALIGNED.get(is, (long) (i+3)) + (long) VH_LONG_UNALIGNED.get(os, (long) (i+3)));
         }
     }
 