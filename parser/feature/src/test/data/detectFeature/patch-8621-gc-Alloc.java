@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2014, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -38,13 +38,14 @@
 public class Alloc {
 
     public static final int LENGTH = 400;
-    public static final int ARR_LEN = 100;
-    public int largeLen = 100;
-    public int smalllen = 6;
+    public static final int largeConstLen = 100;
+    public static final int smallConstLen = 6;
+    public int largeVariableLen = 100;
+    public int smallVariableLen = 6;
 
     @Benchmark
     public void testLargeConstArray(Blackhole bh) throws Exception {
-        int localArrlen = ARR_LEN;
+        int localArrlen = largeConstLen;
         for (int i = 0; i < LENGTH; i++) {
             Object[] tmp = new Object[localArrlen];
             bh.consume(tmp);
@@ -53,7 +54,7 @@ public void testLargeConstArray(Blackhole bh) throws Exception {
 
     @Benchmark
     public void testLargeVariableArray(Blackhole bh) throws Exception {
-        int localArrlen = largeLen;
+        int localArrlen = largeVariableLen;
         for (int i = 0; i < LENGTH; i++) {
             Object[] tmp = new Object[localArrlen];
             bh.consume(tmp);
@@ -62,7 +63,7 @@ public void testLargeVariableArray(Blackhole bh) throws Exception {
 
     @Benchmark
     public void testSmallConstArray(Blackhole bh) throws Exception {
-        int localArrlen = largeLen;
+        int localArrlen = smallConstLen;
         for (int i = 0; i < LENGTH; i++) {
             Object[] tmp = new Object[localArrlen];
             bh.consume(tmp);
@@ -82,7 +83,7 @@ public void testSmallObject(Blackhole bh) throws Exception {
 
     @Benchmark
     public void testSmallVariableArray(Blackhole bh) throws Exception {
-        int localArrlen = smalllen;
+        int localArrlen = smallVariableLen;
         for (int i = 0; i < LENGTH; i++) {
             Object[] tmp = new Object[localArrlen];
             bh.consume(tmp);