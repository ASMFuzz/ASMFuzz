@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -101,8 +101,8 @@ public void setup() {
 
     // ---------------- HELPER METHODS
 
-    private int innerLoopGetShort(ShortBuffer buf) {
-        int r = 0;
+    private short innerLoopGetShort(ShortBuffer buf) {
+        short r = 0;
         for (int i = 0; i < buf.capacity(); i++) {
             r += buf.get(i);
         }
@@ -135,7 +135,7 @@ public void testHeapLoopPutShort() {
     }
 
     @Benchmark
-    public int testHeapLoopGetShort() {
+    public short testHeapLoopGetShort() {
         return innerLoopGetShort(heapShortBuffer);
     }
 
@@ -148,7 +148,7 @@ public short[] testHeapBulkGetShortViewSwapRO() {
     }
 
     @Benchmark
-    public int testHeapLoopGetShortViewSwapRO() {
+    public short testHeapLoopGetShortViewSwapRO() {
         return innerLoopGetShort(heapByteBufferAsShortBufferViewSwapRO);
     }
 
@@ -172,7 +172,7 @@ public void testHeapLoopPutShortViewSwap() {
     }
 
     @Benchmark
-    public int testHeapLoopGetShortViewSwap() {
+    public short testHeapLoopGetShortViewSwap() {
         return innerLoopGetShort(heapByteBufferAsShortBufferViewSwap);
     }
 
@@ -185,7 +185,7 @@ public short[] testHeapBulkGetShortViewRO() {
     }
 
     @Benchmark
-    public int testHeapLoopGetShortViewRO() {
+    public short testHeapLoopGetShortViewRO() {
         return innerLoopGetShort(heapByteBufferAsShortBufferViewRO);
     }
 
@@ -209,7 +209,7 @@ public void testHeapLoopPutShortView() {
     }
 
     @Benchmark
-    public int testHeapLoopGetShortView() {
+    public short testHeapLoopGetShortView() {
         return innerLoopGetShort(heapByteBufferAsShortBufferView);
     }
 
@@ -222,7 +222,7 @@ public short[] testDirectBulkGetShortViewSwapRO() {
     }
 
     @Benchmark
-    public int testDirectLoopGetShortViewSwapRO() {
+    public short testDirectLoopGetShortViewSwapRO() {
         return innerLoopGetShort(directByteBufferAsShortBufferViewSwapRO);
     }
 
@@ -246,7 +246,7 @@ public void testDirectLoopPutShortViewSwap() {
     }
 
     @Benchmark
-    public int testDirectLoopGetShortViewSwap() {
+    public short testDirectLoopGetShortViewSwap() {
         return innerLoopGetShort(directByteBufferAsShortBufferViewSwap);
     }
 
@@ -259,7 +259,7 @@ public short[] testDirectBulkGetShortViewRO() {
     }
 
     @Benchmark
-    public int testDirectLoopGetShortViewRO() {
+    public short testDirectLoopGetShortViewRO() {
         return innerLoopGetShort(directByteBufferAsShortBufferViewRO);
     }
 
@@ -283,7 +283,7 @@ public void testDirectLoopPutShortView() {
     }
 
     @Benchmark
-    public int testDirectLoopGetShortView() {
+    public short testDirectLoopGetShortView() {
         return innerLoopGetShort(directByteBufferAsShortBufferView);
     }
 }