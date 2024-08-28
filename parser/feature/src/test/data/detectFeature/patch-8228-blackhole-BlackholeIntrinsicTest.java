@@ -77,6 +77,15 @@ public class BlackholeIntrinsicTest {
         TESTS.put("bh_s_long_2",    BlackholeIntrinsicTest::test_long_2);
         TESTS.put("bh_s_double_2",  BlackholeIntrinsicTest::test_double_2);
         TESTS.put("bh_s_Object_2",  BlackholeIntrinsicTest::test_Object_2);
+
+        // Test calling static methods through instance method to exercise
+        // unusual intrinsic shapes.
+        TESTS.put("bh_is_int_0",    BlackholeIntrinsicTest::test_is_int_0);
+        TESTS.put("bh_is_Object_0", BlackholeIntrinsicTest::test_is_Object_0);
+        TESTS.put("bh_is_int_1",    BlackholeIntrinsicTest::test_is_int_1);
+        TESTS.put("bh_is_Object_1", BlackholeIntrinsicTest::test_is_Object_1);
+        TESTS.put("bh_is_int_2",    BlackholeIntrinsicTest::test_is_int_2);
+        TESTS.put("bh_is_Object_2", BlackholeIntrinsicTest::test_is_Object_2);
     }
 
     private static final int CYCLES = 100_000;
@@ -162,6 +171,13 @@ private static void test_int_0() {
         }
     }
 
+    private static void test_is_int_0() {
+        BlackholeTarget t = new BlackholeTarget();
+        for (int c = 0; c < CYCLES; c++) {
+            t.bh_is_int_0();
+        }
+    }
+
     private static void test_float_0() {
         for (int c = 0; c < CYCLES; c++) {
             BlackholeTarget.bh_s_float_0();
@@ -186,6 +202,13 @@ private static void test_Object_0() {
         }
     }
 
+    private static void test_is_Object_0() {
+        BlackholeTarget t = new BlackholeTarget();
+        for (int c = 0; c < CYCLES; c++) {
+            t.bh_is_Object_0();
+        }
+    }
+
     private static void test_boolean_1() {
         for (int c = 0; c < CYCLES; c++) {
             BlackholeTarget.bh_s_boolean_1((c & 0x1) == 0);
@@ -216,6 +239,13 @@ private static void test_int_1() {
         }
     }
 
+    private static void test_is_int_1() {
+        BlackholeTarget t = new BlackholeTarget();
+        for (int c = 0; c < CYCLES; c++) {
+            t.bh_is_int_1(c);
+        }
+    }
+
     private static void test_float_1() {
         for (int c = 0; c < CYCLES; c++) {
             BlackholeTarget.bh_s_float_1(c);
@@ -241,6 +271,14 @@ private static void test_Object_1() {
         }
     }
 
+    private static void test_is_Object_1() {
+        BlackholeTarget t = new BlackholeTarget();
+        for (int c = 0; c < CYCLES; c++) {
+            Object o = new Object();
+            t.bh_is_Object_1(o);
+        }
+    }
+
     private static void test_boolean_2() {
         for (int c = 0; c < CYCLES; c++) {
             BlackholeTarget.bh_s_boolean_2((c & 0x1) == 0, (c & 0x2) == 0);
@@ -271,6 +309,13 @@ private static void test_int_2() {
         }
     }
 
+    private static void test_is_int_2() {
+        BlackholeTarget t = new BlackholeTarget();
+        for (int c = 0; c < CYCLES; c++) {
+            t.bh_is_int_2(c, c + 1);
+        }
+    }
+
     private static void test_float_2() {
         for (int c = 0; c < CYCLES; c++) {
             BlackholeTarget.bh_s_float_2(c, c + 1);
@@ -296,4 +341,13 @@ private static void test_Object_2() {
             BlackholeTarget.bh_s_Object_2(o1, o2);
         }
     }
+
+    private static void test_is_Object_2() {
+        BlackholeTarget t = new BlackholeTarget();
+        for (int c = 0; c < CYCLES; c++) {
+            Object o1 = new Object();
+            Object o2 = new Object();
+            t.bh_is_Object_2(o1, o2);
+        }
+    }
 }