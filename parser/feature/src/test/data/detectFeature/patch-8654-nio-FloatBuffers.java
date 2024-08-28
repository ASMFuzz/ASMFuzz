@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -101,8 +101,8 @@ public void setup() {
 
     // ---------------- HELPER METHODS
 
-    private int innerLoopGetFloat(FloatBuffer buf) {
-        int r = 0;
+    private float innerLoopGetFloat(FloatBuffer buf) {
+        float r = 0;
         for (int i = 0; i < buf.capacity(); i++) {
             r += buf.get(i);
         }
@@ -135,7 +135,7 @@ public void testHeapLoopPutFloat() {
     }
 
     @Benchmark
-    public int testHeapLoopGetFloat() {
+    public float testHeapLoopGetFloat() {
         return innerLoopGetFloat(heapFloatBuffer);
     }
 
@@ -148,7 +148,7 @@ public float[] testHeapBulkGetFloatViewSwapRO() {
     }
 
     @Benchmark
-    public int testHeapLoopGetFloatViewSwapRO() {
+    public float testHeapLoopGetFloatViewSwapRO() {
         return innerLoopGetFloat(heapByteBufferAsFloatBufferViewSwapRO);
     }
 
@@ -172,7 +172,7 @@ public void testHeapLoopPutFloatViewSwap() {
     }
 
     @Benchmark
-    public int testHeapLoopGetFloatViewSwap() {
+    public float testHeapLoopGetFloatViewSwap() {
         return innerLoopGetFloat(heapByteBufferAsFloatBufferViewSwap);
     }
 
@@ -185,7 +185,7 @@ public float[] testHeapBulkGetFloatViewRO() {
     }
 
     @Benchmark
-    public int testHeapLoopGetFloatViewRO() {
+    public float testHeapLoopGetFloatViewRO() {
         return innerLoopGetFloat(heapByteBufferAsFloatBufferViewRO);
     }
 
@@ -209,7 +209,7 @@ public void testHeapLoopPutFloatView() {
     }
 
     @Benchmark
-    public int testHeapLoopGetFloatView() {
+    public float testHeapLoopGetFloatView() {
         return innerLoopGetFloat(heapByteBufferAsFloatBufferView);
     }
 
@@ -222,7 +222,7 @@ public float[] testDirectBulkGetFloatViewSwapRO() {
     }
 
     @Benchmark
-    public int testDirectLoopGetFloatViewSwapRO() {
+    public float testDirectLoopGetFloatViewSwapRO() {
         return innerLoopGetFloat(directByteBufferAsFloatBufferViewSwapRO);
     }
 
@@ -246,7 +246,7 @@ public void testDirectLoopPutFloatViewSwap() {
     }
 
     @Benchmark
-    public int testDirectLoopGetFloatViewSwap() {
+    public float testDirectLoopGetFloatViewSwap() {
         return innerLoopGetFloat(directByteBufferAsFloatBufferViewSwap);
     }
 
@@ -259,7 +259,7 @@ public float[] testDirectBulkGetFloatViewRO() {
     }
 
     @Benchmark
-    public int testDirectLoopGetFloatViewRO() {
+    public float testDirectLoopGetFloatViewRO() {
         return innerLoopGetFloat(directByteBufferAsFloatBufferViewRO);
     }
 
@@ -283,7 +283,7 @@ public void testDirectLoopPutFloatView() {
     }
 
     @Benchmark
-    public int testDirectLoopGetFloatView() {
+    public float testDirectLoopGetFloatView() {
         return innerLoopGetFloat(directByteBufferAsFloatBufferView);
     }
 }