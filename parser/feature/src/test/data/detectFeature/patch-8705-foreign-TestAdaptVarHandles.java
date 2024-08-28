@@ -24,9 +24,8 @@
 
 package org.openjdk.bench.java.lang.foreign;
 
-import java.lang.foreign.MemoryLayout;
 import java.lang.foreign.MemorySegment;
-import java.lang.foreign.ValueLayout;
+
 import org.openjdk.jmh.annotations.Benchmark;
 import org.openjdk.jmh.annotations.BenchmarkMode;
 import org.openjdk.jmh.annotations.Fork;
@@ -49,7 +48,7 @@
 @State(org.openjdk.jmh.annotations.Scope.Thread)
 @OutputTimeUnit(TimeUnit.MILLISECONDS)
 @Fork(value = 3, jvmArgsAppend = "--enable-preview")
-public class TestAdaptVarHandles {
+public class TestAdaptVarHandles extends JavaLayouts {
 
     static class IntBox {
 
@@ -80,17 +79,15 @@ int intValue() {
         }
     }
 
-    static final VarHandle VH_int = MethodHandles.arrayElementVarHandle(int[].class);
-
-    static final VarHandle VH_box_int = MethodHandles.filterValue(VH_int, INTBOX_TO_INT, INT_TO_INTBOX);
+    static final VarHandle VH_ARR_INT = MethodHandles.arrayElementVarHandle(int[].class);
 
-    static final VarHandle VH_addr_int = ValueLayout.JAVA_INT.arrayElementVarHandle();
+    static final VarHandle VH_BOX_ARR_INT = MethodHandles.filterValue(VH_ARR_INT, INTBOX_TO_INT, INT_TO_INTBOX);
 
-    static final VarHandle VH_addr_box_int = MethodHandles.filterValue(VH_addr_int, INTBOX_TO_INT, INT_TO_INTBOX);
+    static final VarHandle VH_BOX_INT = MethodHandles.filterValue(VH_INT, INTBOX_TO_INT, INT_TO_INTBOX);
 
-    static final MethodHandle MH_int = VH_int.toMethodHandle(VarHandle.AccessMode.GET);
+    static final MethodHandle MH_INT = VH_ARR_INT.toMethodHandle(VarHandle.AccessMode.GET);
 
-    static final MethodHandle MH_box_int = MethodHandles.filterReturnValue(MH_int, INT_TO_INTBOX);
+    static final MethodHandle MH_BOX_INT = MethodHandles.filterReturnValue(MH_INT, INT_TO_INTBOX);
 
     int[] base = new int[ELEM_SIZE];
     MemorySegment segment = MemorySegment.ofArray(base);
@@ -106,7 +103,7 @@ public void setup() {
     public int vh_loop() throws Throwable {
         int sum = 0;
         for (int i = 0; i < ELEM_SIZE; i++) {
-            sum += (int)VH_int.get(base, i);
+            sum += (int) VH_ARR_INT.get(base, i);
         }
         return sum;
     }
@@ -115,7 +112,7 @@ public int vh_loop() throws Throwable {
     public int vh_box_loop() throws Throwable {
         int sum = 0;
         for (int i = 0; i < ELEM_SIZE; i++) {
-            sum += ((IntBox)VH_box_int.get(base, i)).intValue();
+            sum += ((IntBox) VH_BOX_ARR_INT.get(base, i)).intValue();
         }
         return sum;
     }
@@ -124,7 +121,7 @@ public int vh_box_loop() throws Throwable {
     public int mh_loop() throws Throwable {
         int sum = 0;
         for (int i = 0; i < ELEM_SIZE; i++) {
-            sum += (int)MH_int.invokeExact(base, i);
+            sum += (int) MH_INT.invokeExact(base, i);
         }
         return sum;
     }
@@ -133,7 +130,7 @@ public int mh_loop() throws Throwable {
     public int mh_box_loop() throws Throwable {
         int sum = 0;
         for (int i = 0; i < ELEM_SIZE; i++) {
-            sum += ((IntBox)MH_box_int.invokeExact(base, i)).intValue();
+            sum += ((IntBox) MH_BOX_INT.invokeExact(base, i)).intValue();
         }
         return sum;
     }
@@ -142,7 +139,7 @@ public int mh_box_loop() throws Throwable {
     public int segment_loop() throws Throwable {
         int sum = 0;
         for (int i = 0; i < ELEM_SIZE; i++) {
-            sum += (int)VH_addr_int.get(segment, (long)i);
+            sum += (int)VH_INT.get(segment, (long)i);
         }
         return sum;
     }
@@ -151,7 +148,7 @@ public int segment_loop() throws Throwable {
     public int segment_box_loop() throws Throwable {
         int sum = 0;
         for (int i = 0; i < ELEM_SIZE; i++) {
-            sum += ((IntBox)VH_addr_box_int.get(segment, (long)i)).intValue();
+            sum += ((IntBox)VH_BOX_INT.get(segment, (long)i)).intValue();
         }
         return sum;
     }