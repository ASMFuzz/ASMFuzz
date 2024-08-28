@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2014, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -120,8 +120,8 @@ private long innerCandidate1long(long l) {
 
     /** Tests how well serial constant long compares are straightened. */
     @Benchmark
-    public int testStraighten1long() throws Exception {
-        int dummy = 0;
+    public long testStraighten1long() throws Exception {
+        long dummy = 0;
         long[] arr = longArr;
         for (long l : arr) {
             dummy += innerCandidate1long(l);
@@ -182,8 +182,8 @@ private long innerCandidate2long(long l) {
 
     /** Tests how well constant long definitions are straightened. */
     @Benchmark
-    public int testStraighten2long() throws Exception {
-        int dummy = 0;
+    public long testStraighten2long() throws Exception {
+        long dummy = 0;
         long[] arr = longArr;
         for (long l : arr) {
             dummy += innerCandidate2long(l);
@@ -236,8 +236,8 @@ private long innerCandidate3long(long i, long j) {
 
     /** Tests how well variable long compares are straightened. */
     @Benchmark
-    public int testStraighten3long() throws Exception {
-        int dummy = 0;
+    public long testStraighten3long() throws Exception {
+        long dummy = 0;
         long[] arr = longArr;
         for (int i = 0; i < arr.length - 1; i++) {
             dummy += innerCandidate3long(arr[i], arr[i + 1]);