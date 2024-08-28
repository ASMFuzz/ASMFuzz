@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2012, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -102,6 +102,7 @@ static int test() {
       test_andImm(a1, a2, a3);
       test_orImm(a1, a2);
       test_xorImm(a1, a2);
+      test_cp_countingdown(a1, a2);
     }
     // Initialize
     for (int i=0; i<ARRLEN; i++) {
@@ -552,6 +553,10 @@ static int test() {
       for (int i=0; i<ARRLEN; i++) {
         errn += verify("test_xorImm: a2", i, a2[i], golden);
       }
+      test_cp_countingdown(a1, a2);
+      for (int i = 500; i > 0; i--) {
+        errn += verify("test_cp_countingdown: a2", ARRLEN - i, a2[ARRLEN - i], a1[ARRLEN - i]);
+      }
 
     }
 
@@ -837,6 +842,12 @@ static int test() {
     }
     end = System.currentTimeMillis();
     System.out.println("test_xorImm: " + (end - start));
+    start = System.currentTimeMillis();
+    for (int i = 0; i < ITERS; i++) {
+      test_cp_countingdown(a1, a2);
+    }
+    end = System.currentTimeMillis();
+    System.out.println("test_cp_countingdown: " + (end - start));
 
     return errn;
   }
@@ -1095,7 +1106,11 @@ static void test_xorImm(int[] a, int[] b) {
       b[i] = a[i] ^ 2032;
     }
   }
-
+  static void test_cp_countingdown(int[] a, int[] b) {
+    for (int i = 500; i > 0; i--) {
+      b[ARRLEN - i] = a[ARRLEN - i];
+    }
+  }
 
   static int verify(String text, int i, int elem, int val) {
     if (elem != val) {