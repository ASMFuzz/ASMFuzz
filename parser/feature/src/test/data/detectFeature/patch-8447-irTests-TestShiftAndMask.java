@@ -26,10 +26,11 @@
 import compiler.lib.ir_framework.*;
 import jdk.test.lib.Utils;
 import java.util.Random;
+import java.util.Objects;
 
 /*
  * @test
- * @bug 8277850 8278949
+ * @bug 8277850 8278949 8285793
  * @summary C2: optimize mask checks in counted loops
  * @library /test/lib /
  * @run driver compiler.c2.irTests.TestShiftAndMask
@@ -274,7 +275,7 @@ public static void addShiftMaskLong3_runner() {
 
     @Test
     @Arguments({Argument.RANDOM_EACH})
-    @IR(failOn = { IRNode.AND_L, IRNode.LSHIFT_I })
+    @IR(failOn = { IRNode.AND_L, IRNode.LSHIFT_I, IRNode.CONV_I2L })
     public static long shiftConvMask(int i) {
         return ((long)(i << 2)) & 3; // transformed to: return 0;
     }
@@ -288,7 +289,7 @@ public static void checkShiftConvMask(long res) {
 
     @Test
     @Arguments({Argument.RANDOM_EACH, Argument.BOOLEAN_TOGGLE_FIRST_TRUE})
-    @IR(failOn = { IRNode.AND_L, IRNode.LSHIFT_L })
+    @IR(failOn = { IRNode.AND_L, IRNode.LSHIFT_I, IRNode.CONV_I2L })
     public static long shiftNotConstConvMask(int i, boolean flag) {
         long mask;
         if (flag) {
@@ -326,7 +327,7 @@ public static void addShiftConvMask_runner() {
 
     @Test
     @Arguments({Argument.RANDOM_EACH, Argument.RANDOM_EACH})
-    @IR(failOn = { IRNode.AND_L, IRNode.ADD_L, IRNode.LSHIFT_L })
+    @IR(failOn = { IRNode.AND_L, IRNode.ADD_L, IRNode.LSHIFT_I, IRNode.CONV_I2L })
     public static long addShiftConvMask2(int i, int j) {
         return (((long)(j << 2)) + ((long)(i << 2))) & 3; // transformed to: return 0;
     }
@@ -337,4 +338,149 @@ public static void checkAddShiftConvMask2(long res) {
             throw new RuntimeException("incorrect result: " + res);
         }
     }
+
+    @Test
+    @IR(failOn = { IRNode.AND_I })
+    public static int shiftMaskIntCheckIndex(int i, int length) {
+        return Objects.checkIndex(i << 2, length) & 3; // transformed to: return 0;
+    }
+
+    @Run(test = "shiftMaskIntCheckIndex")
+    public static void shiftMaskIntCheckIndex_runner() {
+        int i = RANDOM.nextInt((Integer.MAX_VALUE - 1) >> 2);
+        int res = shiftMaskIntCheckIndex(i, (i << 2) + 1);
+        if (res != 0) {
+            throw new RuntimeException("incorrect result: " + res);
+        }
+    }
+
+    @Test
+    @IR(failOn = { IRNode.AND_L })
+    public static long shiftMaskLongCheckIndex(long i, long length) {
+        return Objects.checkIndex(i << 2, length) & 3; // transformed to: return 0;
+    }
+
+    @Run(test = "shiftMaskLongCheckIndex")
+    public static void shiftMaskLongCheckIndex_runner() {
+        long i = RANDOM.nextInt((Integer.MAX_VALUE - 1) >> 2);
+        long res = shiftMaskLongCheckIndex(i, (i << 2) + 1);
+        if (res != 0) {
+            throw new RuntimeException("incorrect result: " + res);
+        }
+    }
+
+    @Test
+    @IR(counts = { IRNode.AND_I, "1" })
+    @IR(failOn = { IRNode.ADD_I })
+    public static int addShiftMaskIntCheckIndex(int i, int j, int length) {
+        return (j + Objects.checkIndex(i << 2, length)) & 3; // transformed to: return j & 3;
+    }
+
+    @Run(test = "addShiftMaskIntCheckIndex")
+    public static void addShiftMaskIntCheckIndex_runner() {
+        int i = RANDOM.nextInt((Integer.MAX_VALUE - 1) >> 2);
+        int j = RANDOM.nextInt();
+        int res = addShiftMaskIntCheckIndex(i, j, (i << 2) + 1);
+        if (res != (j & 3)) {
+            throw new RuntimeException("incorrect result: " + res);
+        }
+    }
+
+    @Test
+    @IR(counts = { IRNode.AND_L, "1" })
+    @IR(failOn = { IRNode.ADD_L })
+    public static long addShiftMaskLongCheckIndex(long i, long j, long length) {
+        return (j + Objects.checkIndex(i << 2, length)) & 3; // transformed to: return j & 3;
+    }
+
+    @Run(test = "addShiftMaskLongCheckIndex")
+    public static void addShiftMaskLongCheckIndex_runner() {
+        long i = RANDOM.nextInt((Integer.MAX_VALUE - 1) >> 2);
+        long j = RANDOM.nextLong();
+        long res = addShiftMaskLongCheckIndex(i, j, (i << 2) + 1);
+        if (res != (j & 3)) {
+            throw new RuntimeException("incorrect result: " + res);
+        }
+    }
+
+    @Test
+    @IR(failOn = { IRNode.AND_I, IRNode.ADD_I })
+    public static int addShiftMaskIntCheckIndex2(int i, int j, int length) {
+        return (Objects.checkIndex(j << 2, length) + Objects.checkIndex(i << 2, length)) & 3; // transformed to: return 0;
+    }
+
+
+    @Run(test = "addShiftMaskIntCheckIndex2")
+    public static void addShiftMaskIntCheckIndex2_runner() {
+        int i = RANDOM.nextInt((Integer.MAX_VALUE - 1) >> 2);
+        int j = RANDOM.nextInt((Integer.MAX_VALUE - 1) >> 2);
+        int res = addShiftMaskIntCheckIndex2(i, j, (Integer.max(i, j) << 2) + 1);
+        if (res != 0) {
+            throw new RuntimeException("incorrect result: " + res);
+        }
+    }
+
+    @Test
+    @IR(failOn = { IRNode.AND_L, IRNode.ADD_L })
+    public static long addShiftMaskLongCheckIndex2(long i, long j, long length) {
+        return (Objects.checkIndex(j << 2, length) + Objects.checkIndex(i << 2, length)) & 3; // transformed to: return 0;
+    }
+
+    @Run(test = "addShiftMaskLongCheckIndex2")
+    public static void addShiftMaskLongCheckIndex2_runner() {
+        long i = RANDOM.nextInt((Integer.MAX_VALUE - 1) >> 2);
+        long j = RANDOM.nextInt((Integer.MAX_VALUE - 1) >> 2);
+        long res = addShiftMaskLongCheckIndex2(i, j, (Long.max(i, j) << 2) + 1);
+        if (res != 0) {
+            throw new RuntimeException("incorrect result: " + res);
+        }
+    }
+
+    @Test
+    @IR(failOn = { IRNode.AND_L, IRNode.CONV_I2L })
+    public static long shiftConvMaskCheckIndex(int i, int length) {
+        return ((long)Objects.checkIndex(i << 2, length)) & 3; // transformed to: return 0;
+    }
+
+    @Run(test = "shiftConvMaskCheckIndex")
+    public static void shiftConvMaskCheckIndex_runner() {
+        int i = RANDOM.nextInt((Integer.MAX_VALUE - 1) >> 2);
+        long res = shiftConvMaskCheckIndex(i, (i << 2) + 1);
+        if (res != 0) {
+            throw new RuntimeException("incorrect result: " + res);
+        }
+    }
+
+    @Test
+    @IR(counts = { IRNode.AND_L, "1" })
+    @IR(failOn = { IRNode.ADD_L, IRNode.CONV_I2L })
+    public static long addShiftConvMaskCheckIndex(int i, long j, int length) {
+        return (j + Objects.checkIndex(i << 2, length)) & 3; // transformed to: return j & 3;
+    }
+
+    @Run(test = "addShiftConvMaskCheckIndex")
+    public static void addShiftConvMaskCheckIndex_runner() {
+        int i = RANDOM.nextInt((Integer.MAX_VALUE - 1) >> 2);
+        long j = RANDOM.nextLong();
+        long res = addShiftConvMaskCheckIndex(i, j, (i << 2) + 1);
+        if (res != (j & 3)) {
+            throw new RuntimeException("incorrect result: " + res);
+        }
+    }
+
+    @Test
+    @IR(failOn = { IRNode.AND_L, IRNode.ADD_L })
+    public static long addShiftConvMaskCheckIndex2(int i, int j, int length) {
+        return (((long)Objects.checkIndex(j << 2, length)) + ((long)Objects.checkIndex(i << 2, length))) & 3; // transformed to: return 0;
+    }
+
+    @Run(test = "addShiftConvMaskCheckIndex2")
+    public static void addShiftConvMaskCheckIndex2_runner() {
+        int i = RANDOM.nextInt((Integer.MAX_VALUE - 1) >> 2);
+        int j = RANDOM.nextInt((Integer.MAX_VALUE - 1) >> 2);
+        long res = addShiftConvMaskCheckIndex2(i, j, (Integer.max(i, j) << 2) + 1);
+        if (res != 0) {
+            throw new RuntimeException("incorrect result: " + res);
+        }
+    }
 }