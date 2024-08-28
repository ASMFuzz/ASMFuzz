@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -101,8 +101,8 @@ public void setup() {
 
     // ---------------- HELPER METHODS
 
-    private int innerLoopGetLong(LongBuffer buf) {
-        int r = 0;
+    private long innerLoopGetLong(LongBuffer buf) {
+        long r = 0;
         for (int i = 0; i < buf.capacity(); i++) {
             r += buf.get(i);
         }
@@ -135,7 +135,7 @@ public void testHeapLoopPutLong() {
     }
 
     @Benchmark
-    public int testHeapLoopGetLong() {
+    public long testHeapLoopGetLong() {
         return innerLoopGetLong(heapLongBuffer);
     }
 
@@ -148,7 +148,7 @@ public long[] testHeapBulkGetLongViewSwapRO() {
     }
 
     @Benchmark
-    public int testHeapLoopGetLongViewSwapRO() {
+    public long testHeapLoopGetLongViewSwapRO() {
         return innerLoopGetLong(heapByteBufferAsLongBufferViewSwapRO);
     }
 
@@ -172,7 +172,7 @@ public void testHeapLoopPutLongViewSwap() {
     }
 
     @Benchmark
-    public int testHeapLoopGetLongViewSwap() {
+    public long testHeapLoopGetLongViewSwap() {
         return innerLoopGetLong(heapByteBufferAsLongBufferViewSwap);
     }
 
@@ -185,7 +185,7 @@ public long[] testHeapBulkGetLongViewRO() {
     }
 
     @Benchmark
-    public int testHeapLoopGetLongViewRO() {
+    public long testHeapLoopGetLongViewRO() {
         return innerLoopGetLong(heapByteBufferAsLongBufferViewRO);
     }
 
@@ -209,7 +209,7 @@ public void testHeapLoopPutLongView() {
     }
 
     @Benchmark
-    public int testHeapLoopGetLongView() {
+    public long testHeapLoopGetLongView() {
         return innerLoopGetLong(heapByteBufferAsLongBufferView);
     }
 
@@ -222,7 +222,7 @@ public long[] testDirectBulkGetLongViewSwapRO() {
     }
 
     @Benchmark
-    public int testDirectLoopGetLongViewSwapRO() {
+    public long testDirectLoopGetLongViewSwapRO() {
         return innerLoopGetLong(directByteBufferAsLongBufferViewSwapRO);
     }
 
@@ -246,7 +246,7 @@ public void testDirectLoopPutLongViewSwap() {
     }
 
     @Benchmark
-    public int testDirectLoopGetLongViewSwap() {
+    public long testDirectLoopGetLongViewSwap() {
         return innerLoopGetLong(directByteBufferAsLongBufferViewSwap);
     }
 
@@ -259,7 +259,7 @@ public long[] testDirectBulkGetLongViewRO() {
     }
 
     @Benchmark
-    public int testDirectLoopGetLongViewRO() {
+    public long testDirectLoopGetLongViewRO() {
         return innerLoopGetLong(directByteBufferAsLongBufferViewRO);
     }
 
@@ -283,7 +283,7 @@ public void testDirectLoopPutLongView() {
     }
 
     @Benchmark
-    public int testDirectLoopGetLongView() {
+    public long testDirectLoopGetLongView() {
         return innerLoopGetLong(directByteBufferAsLongBufferView);
     }
 }