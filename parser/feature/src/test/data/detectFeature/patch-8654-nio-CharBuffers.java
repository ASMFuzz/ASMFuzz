@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -101,8 +101,8 @@ public void setup() {
 
     // ---------------- HELPER METHODS
 
-    private int innerLoopGetChar(CharBuffer buf) {
-        int r = 0;
+    private char innerLoopGetChar(CharBuffer buf) {
+        char r = 0;
         for (int i = 0; i < buf.capacity(); i++) {
             r += buf.get(i);
         }
@@ -135,7 +135,7 @@ public void testHeapLoopPutChar() {
     }
 
     @Benchmark
-    public int testHeapLoopGetChar() {
+    public char testHeapLoopGetChar() {
         return innerLoopGetChar(heapCharBuffer);
     }
 
@@ -148,7 +148,7 @@ public char[] testHeapBulkGetCharViewSwapRO() {
     }
 
     @Benchmark
-    public int testHeapLoopGetCharViewSwapRO() {
+    public char testHeapLoopGetCharViewSwapRO() {
         return innerLoopGetChar(heapByteBufferAsCharBufferViewSwapRO);
     }
 
@@ -172,7 +172,7 @@ public void testHeapLoopPutCharViewSwap() {
     }
 
     @Benchmark
-    public int testHeapLoopGetCharViewSwap() {
+    public char testHeapLoopGetCharViewSwap() {
         return innerLoopGetChar(heapByteBufferAsCharBufferViewSwap);
     }
 
@@ -185,7 +185,7 @@ public char[] testHeapBulkGetCharViewRO() {
     }
 
     @Benchmark
-    public int testHeapLoopGetCharViewRO() {
+    public char testHeapLoopGetCharViewRO() {
         return innerLoopGetChar(heapByteBufferAsCharBufferViewRO);
     }
 
@@ -209,7 +209,7 @@ public void testHeapLoopPutCharView() {
     }
 
     @Benchmark
-    public int testHeapLoopGetCharView() {
+    public char testHeapLoopGetCharView() {
         return innerLoopGetChar(heapByteBufferAsCharBufferView);
     }
 
@@ -222,7 +222,7 @@ public char[] testDirectBulkGetCharViewSwapRO() {
     }
 
     @Benchmark
-    public int testDirectLoopGetCharViewSwapRO() {
+    public char testDirectLoopGetCharViewSwapRO() {
         return innerLoopGetChar(directByteBufferAsCharBufferViewSwapRO);
     }
 
@@ -246,7 +246,7 @@ public void testDirectLoopPutCharViewSwap() {
     }
 
     @Benchmark
-    public int testDirectLoopGetCharViewSwap() {
+    public char testDirectLoopGetCharViewSwap() {
         return innerLoopGetChar(directByteBufferAsCharBufferViewSwap);
     }
 
@@ -259,7 +259,7 @@ public char[] testDirectBulkGetCharViewRO() {
     }
 
     @Benchmark
-    public int testDirectLoopGetCharViewRO() {
+    public char testDirectLoopGetCharViewRO() {
         return innerLoopGetChar(directByteBufferAsCharBufferViewRO);
     }
 
@@ -283,7 +283,7 @@ public void testDirectLoopPutCharView() {
     }
 
     @Benchmark
-    public int testDirectLoopGetCharView() {
+    public char testDirectLoopGetCharView() {
         return innerLoopGetChar(directByteBufferAsCharBufferView);
     }
 }