@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -101,8 +101,8 @@ public void setup() {
 
     // ---------------- HELPER METHODS
 
-    private int innerLoopGetDouble(DoubleBuffer buf) {
-        int r = 0;
+    private double innerLoopGetDouble(DoubleBuffer buf) {
+        double r = 0;
         for (int i = 0; i < buf.capacity(); i++) {
             r += buf.get(i);
         }
@@ -135,7 +135,7 @@ public void testHeapLoopPutDouble() {
     }
 
     @Benchmark
-    public int testHeapLoopGetDouble() {
+    public double testHeapLoopGetDouble() {
         return innerLoopGetDouble(heapDoubleBuffer);
     }
 
@@ -148,7 +148,7 @@ public double[] testHeapBulkGetDoubleViewSwapRO() {
     }
 
     @Benchmark
-    public int testHeapLoopGetDoubleViewSwapRO() {
+    public double testHeapLoopGetDoubleViewSwapRO() {
         return innerLoopGetDouble(heapByteBufferAsDoubleBufferViewSwapRO);
     }
 
@@ -172,7 +172,7 @@ public void testHeapLoopPutDoubleViewSwap() {
     }
 
     @Benchmark
-    public int testHeapLoopGetDoubleViewSwap() {
+    public double testHeapLoopGetDoubleViewSwap() {
         return innerLoopGetDouble(heapByteBufferAsDoubleBufferViewSwap);
     }
 
@@ -185,7 +185,7 @@ public double[] testHeapBulkGetDoubleViewRO() {
     }
 
     @Benchmark
-    public int testHeapLoopGetDoubleViewRO() {
+    public double testHeapLoopGetDoubleViewRO() {
         return innerLoopGetDouble(heapByteBufferAsDoubleBufferViewRO);
     }
 
@@ -209,7 +209,7 @@ public void testHeapLoopPutDoubleView() {
     }
 
     @Benchmark
-    public int testHeapLoopGetDoubleView() {
+    public double testHeapLoopGetDoubleView() {
         return innerLoopGetDouble(heapByteBufferAsDoubleBufferView);
     }
 
@@ -222,7 +222,7 @@ public double[] testDirectBulkGetDoubleViewSwapRO() {
     }
 
     @Benchmark
-    public int testDirectLoopGetDoubleViewSwapRO() {
+    public double testDirectLoopGetDoubleViewSwapRO() {
         return innerLoopGetDouble(directByteBufferAsDoubleBufferViewSwapRO);
     }
 
@@ -246,7 +246,7 @@ public void testDirectLoopPutDoubleViewSwap() {
     }
 
     @Benchmark
-    public int testDirectLoopGetDoubleViewSwap() {
+    public double testDirectLoopGetDoubleViewSwap() {
         return innerLoopGetDouble(directByteBufferAsDoubleBufferViewSwap);
     }
 
@@ -259,7 +259,7 @@ public double[] testDirectBulkGetDoubleViewRO() {
     }
 
     @Benchmark
-    public int testDirectLoopGetDoubleViewRO() {
+    public double testDirectLoopGetDoubleViewRO() {
         return innerLoopGetDouble(directByteBufferAsDoubleBufferViewRO);
     }
 
@@ -283,7 +283,7 @@ public void testDirectLoopPutDoubleView() {
     }
 
     @Benchmark
-    public int testDirectLoopGetDoubleView() {
+    public double testDirectLoopGetDoubleView() {
         return innerLoopGetDouble(directByteBufferAsDoubleBufferView);
     }
 }