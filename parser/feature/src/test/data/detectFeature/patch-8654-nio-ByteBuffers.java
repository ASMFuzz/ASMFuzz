@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -115,8 +115,8 @@ public byte[] testHeapBulkGetByte() {
     // -- Heap_Byte_Swap_RO
 
     @Benchmark
-    public int testHeapLoopGetByteSwapRO() {
-        int r = 0;
+    public byte testHeapLoopGetByteSwapRO() {
+        byte r = 0;
         for (int i = 0; i < heapByteBufferSwapRO.capacity(); i+=1) {
             r += heapByteBufferSwapRO.get(i);
         }
@@ -133,8 +133,8 @@ public void testHeapLoopPutByteSwap() {
     }
 
     @Benchmark
-    public int testHeapLoopGetByteSwap() {
-        int r = 0;
+    public byte testHeapLoopGetByteSwap() {
+        byte r = 0;
         for (int i = 0; i < heapByteBufferSwap.capacity(); i+=1) {
             r += heapByteBufferSwap.get(i);
         }
@@ -144,8 +144,8 @@ public int testHeapLoopGetByteSwap() {
     // -- Heap_Byte__RO
 
     @Benchmark
-    public int testHeapLoopGetByteRO() {
-        int r = 0;
+    public byte testHeapLoopGetByteRO() {
+        byte r = 0;
         for (int i = 0; i < heapByteBufferRO.capacity(); i+=1) {
             r += heapByteBufferRO.get(i);
         }
@@ -162,8 +162,8 @@ public void testHeapLoopPutByte() {
     }
 
     @Benchmark
-    public int testHeapLoopGetByte() {
-        int r = 0;
+    public byte testHeapLoopGetByte() {
+        byte r = 0;
         for (int i = 0; i < heapByteBuffer.capacity(); i+=1) {
             r += heapByteBuffer.get(i);
         }
@@ -173,8 +173,8 @@ public int testHeapLoopGetByte() {
     // -- Direct_Byte_Swap_RO
 
     @Benchmark
-    public int testDirectLoopGetByteSwapRO() {
-        int r = 0;
+    public byte testDirectLoopGetByteSwapRO() {
+        byte r = 0;
         for (int i = 0; i < directByteBufferSwapRO.capacity(); i+=1) {
             r += directByteBufferSwapRO.get(i);
         }
@@ -191,8 +191,8 @@ public void testDirectLoopPutByteSwap() {
     }
 
     @Benchmark
-    public int testDirectLoopGetByteSwap() {
-        int r = 0;
+    public byte testDirectLoopGetByteSwap() {
+        byte r = 0;
         for (int i = 0; i < directByteBufferSwap.capacity(); i+=1) {
             r += directByteBufferSwap.get(i);
         }
@@ -202,8 +202,8 @@ public int testDirectLoopGetByteSwap() {
     // -- Direct_Byte__RO
 
     @Benchmark
-    public int testDirectLoopGetByteRO() {
-        int r = 0;
+    public byte testDirectLoopGetByteRO() {
+        byte r = 0;
         for (int i = 0; i < directByteBufferRO.capacity(); i+=1) {
             r += directByteBufferRO.get(i);
         }
@@ -220,8 +220,8 @@ public void testDirectLoopPutByte() {
     }
 
     @Benchmark
-    public int testDirectLoopGetByte() {
-        int r = 0;
+    public byte testDirectLoopGetByte() {
+        byte r = 0;
         for (int i = 0; i < directByteBuffer.capacity(); i+=1) {
             r += directByteBuffer.get(i);
         }
@@ -231,8 +231,8 @@ public int testDirectLoopGetByte() {
     // -- Heap_Char_Swap_RO
 
     @Benchmark
-    public int testHeapLoopGetCharSwapRO() {
-        int r = 0;
+    public char testHeapLoopGetCharSwapRO() {
+        char r = 0;
         for (int i = 0; i < heapByteBufferSwapRO.capacity(); i+=2) {
             r += heapByteBufferSwapRO.getChar(i);
         }
@@ -249,8 +249,8 @@ public void testHeapLoopPutCharSwap() {
     }
 
     @Benchmark
-    public int testHeapLoopGetCharSwap() {
-        int r = 0;
+    public char testHeapLoopGetCharSwap() {
+        char r = 0;
         for (int i = 0; i < heapByteBufferSwap.capacity(); i+=2) {
             r += heapByteBufferSwap.getChar(i);
         }
@@ -260,8 +260,8 @@ public int testHeapLoopGetCharSwap() {
     // -- Heap_Char__RO
 
     @Benchmark
-    public int testHeapLoopGetCharRO() {
-        int r = 0;
+    public char testHeapLoopGetCharRO() {
+        char r = 0;
         for (int i = 0; i < heapByteBufferRO.capacity(); i+=2) {
             r += heapByteBufferRO.getChar(i);
         }
@@ -278,8 +278,8 @@ public void testHeapLoopPutChar() {
     }
 
     @Benchmark
-    public int testHeapLoopGetChar() {
-        int r = 0;
+    public char testHeapLoopGetChar() {
+        char r = 0;
         for (int i = 0; i < heapByteBuffer.capacity(); i+=2) {
             r += heapByteBuffer.getChar(i);
         }
@@ -289,8 +289,8 @@ public int testHeapLoopGetChar() {
     // -- Direct_Char_Swap_RO
 
     @Benchmark
-    public int testDirectLoopGetCharSwapRO() {
-        int r = 0;
+    public char testDirectLoopGetCharSwapRO() {
+        char r = 0;
         for (int i = 0; i < directByteBufferSwapRO.capacity(); i+=2) {
             r += directByteBufferSwapRO.getChar(i);
         }
@@ -307,8 +307,8 @@ public void testDirectLoopPutCharSwap() {
     }
 
     @Benchmark
-    public int testDirectLoopGetCharSwap() {
-        int r = 0;
+    public char testDirectLoopGetCharSwap() {
+        char r = 0;
         for (int i = 0; i < directByteBufferSwap.capacity(); i+=2) {
             r += directByteBufferSwap.getChar(i);
         }
@@ -318,8 +318,8 @@ public int testDirectLoopGetCharSwap() {
     // -- Direct_Char__RO
 
     @Benchmark
-    public int testDirectLoopGetCharRO() {
-        int r = 0;
+    public char testDirectLoopGetCharRO() {
+        char r = 0;
         for (int i = 0; i < directByteBufferRO.capacity(); i+=2) {
             r += directByteBufferRO.getChar(i);
         }
@@ -336,8 +336,8 @@ public void testDirectLoopPutChar() {
     }
 
     @Benchmark
-    public int testDirectLoopGetChar() {
-        int r = 0;
+    public char testDirectLoopGetChar() {
+        char r = 0;
         for (int i = 0; i < directByteBuffer.capacity(); i+=2) {
             r += directByteBuffer.getChar(i);
         }
@@ -347,8 +347,8 @@ public int testDirectLoopGetChar() {
     // -- Heap_Short_Swap_RO
 
     @Benchmark
-    public int testHeapLoopGetShortSwapRO() {
-        int r = 0;
+    public short testHeapLoopGetShortSwapRO() {
+        short r = 0;
         for (int i = 0; i < heapByteBufferSwapRO.capacity(); i+=2) {
             r += heapByteBufferSwapRO.getShort(i);
         }
@@ -365,8 +365,8 @@ public void testHeapLoopPutShortSwap() {
     }
 
     @Benchmark
-    public int testHeapLoopGetShortSwap() {
-        int r = 0;
+    public short testHeapLoopGetShortSwap() {
+        short r = 0;
         for (int i = 0; i < heapByteBufferSwap.capacity(); i+=2) {
             r += heapByteBufferSwap.getShort(i);
         }
@@ -376,8 +376,8 @@ public int testHeapLoopGetShortSwap() {
     // -- Heap_Short__RO
 
     @Benchmark
-    public int testHeapLoopGetShortRO() {
-        int r = 0;
+    public short testHeapLoopGetShortRO() {
+        short r = 0;
         for (int i = 0; i < heapByteBufferRO.capacity(); i+=2) {
             r += heapByteBufferRO.getShort(i);
         }
@@ -394,8 +394,8 @@ public void testHeapLoopPutShort() {
     }
 
     @Benchmark
-    public int testHeapLoopGetShort() {
-        int r = 0;
+    public short testHeapLoopGetShort() {
+        short r = 0;
         for (int i = 0; i < heapByteBuffer.capacity(); i+=2) {
             r += heapByteBuffer.getShort(i);
         }
@@ -405,8 +405,8 @@ public int testHeapLoopGetShort() {
     // -- Direct_Short_Swap_RO
 
     @Benchmark
-    public int testDirectLoopGetShortSwapRO() {
-        int r = 0;
+    public short testDirectLoopGetShortSwapRO() {
+        short r = 0;
         for (int i = 0; i < directByteBufferSwapRO.capacity(); i+=2) {
             r += directByteBufferSwapRO.getShort(i);
         }
@@ -423,8 +423,8 @@ public void testDirectLoopPutShortSwap() {
     }
 
     @Benchmark
-    public int testDirectLoopGetShortSwap() {
-        int r = 0;
+    public short testDirectLoopGetShortSwap() {
+        short r = 0;
         for (int i = 0; i < directByteBufferSwap.capacity(); i+=2) {
             r += directByteBufferSwap.getShort(i);
         }
@@ -434,8 +434,8 @@ public int testDirectLoopGetShortSwap() {
     // -- Direct_Short__RO
 
     @Benchmark
-    public int testDirectLoopGetShortRO() {
-        int r = 0;
+    public short testDirectLoopGetShortRO() {
+        short r = 0;
         for (int i = 0; i < directByteBufferRO.capacity(); i+=2) {
             r += directByteBufferRO.getShort(i);
         }
@@ -452,8 +452,8 @@ public void testDirectLoopPutShort() {
     }
 
     @Benchmark
-    public int testDirectLoopGetShort() {
-        int r = 0;
+    public short testDirectLoopGetShort() {
+        short r = 0;
         for (int i = 0; i < directByteBuffer.capacity(); i+=2) {
             r += directByteBuffer.getShort(i);
         }
@@ -579,8 +579,8 @@ public int testDirectLoopGetInt() {
     // -- Heap_Long_Swap_RO
 
     @Benchmark
-    public int testHeapLoopGetLongSwapRO() {
-        int r = 0;
+    public long testHeapLoopGetLongSwapRO() {
+        long r = 0;
         for (int i = 0; i < heapByteBufferSwapRO.capacity(); i+=8) {
             r += heapByteBufferSwapRO.getLong(i);
         }
@@ -597,8 +597,8 @@ public void testHeapLoopPutLongSwap() {
     }
 
     @Benchmark
-    public int testHeapLoopGetLongSwap() {
-        int r = 0;
+    public long testHeapLoopGetLongSwap() {
+        long r = 0;
         for (int i = 0; i < heapByteBufferSwap.capacity(); i+=8) {
             r += heapByteBufferSwap.getLong(i);
         }
@@ -608,8 +608,8 @@ public int testHeapLoopGetLongSwap() {
     // -- Heap_Long__RO
 
     @Benchmark
-    public int testHeapLoopGetLongRO() {
-        int r = 0;
+    public long testHeapLoopGetLongRO() {
+        long r = 0;
         for (int i = 0; i < heapByteBufferRO.capacity(); i+=8) {
             r += heapByteBufferRO.getLong(i);
         }
@@ -626,8 +626,8 @@ public void testHeapLoopPutLong() {
     }
 
     @Benchmark
-    public int testHeapLoopGetLong() {
-        int r = 0;
+    public long testHeapLoopGetLong() {
+        long r = 0;
         for (int i = 0; i < heapByteBuffer.capacity(); i+=8) {
             r += heapByteBuffer.getLong(i);
         }
@@ -637,8 +637,8 @@ public int testHeapLoopGetLong() {
     // -- Direct_Long_Swap_RO
 
     @Benchmark
-    public int testDirectLoopGetLongSwapRO() {
-        int r = 0;
+    public long testDirectLoopGetLongSwapRO() {
+        long r = 0;
         for (int i = 0; i < directByteBufferSwapRO.capacity(); i+=8) {
             r += directByteBufferSwapRO.getLong(i);
         }
@@ -655,8 +655,8 @@ public void testDirectLoopPutLongSwap() {
     }
 
     @Benchmark
-    public int testDirectLoopGetLongSwap() {
-        int r = 0;
+    public long testDirectLoopGetLongSwap() {
+        long r = 0;
         for (int i = 0; i < directByteBufferSwap.capacity(); i+=8) {
             r += directByteBufferSwap.getLong(i);
         }
@@ -666,8 +666,8 @@ public int testDirectLoopGetLongSwap() {
     // -- Direct_Long__RO
 
     @Benchmark
-    public int testDirectLoopGetLongRO() {
-        int r = 0;
+    public long testDirectLoopGetLongRO() {
+        long r = 0;
         for (int i = 0; i < directByteBufferRO.capacity(); i+=8) {
             r += directByteBufferRO.getLong(i);
         }
@@ -684,8 +684,8 @@ public void testDirectLoopPutLong() {
     }
 
     @Benchmark
-    public int testDirectLoopGetLong() {
-        int r = 0;
+    public long testDirectLoopGetLong() {
+        long r = 0;
         for (int i = 0; i < directByteBuffer.capacity(); i+=8) {
             r += directByteBuffer.getLong(i);
         }
@@ -695,8 +695,8 @@ public int testDirectLoopGetLong() {
     // -- Heap_Float_Swap_RO
 
     @Benchmark
-    public int testHeapLoopGetFloatSwapRO() {
-        int r = 0;
+    public float testHeapLoopGetFloatSwapRO() {
+        float r = 0;
         for (int i = 0; i < heapByteBufferSwapRO.capacity(); i+=4) {
             r += heapByteBufferSwapRO.getFloat(i);
         }
@@ -713,8 +713,8 @@ public void testHeapLoopPutFloatSwap() {
     }
 
     @Benchmark
-    public int testHeapLoopGetFloatSwap() {
-        int r = 0;
+    public float testHeapLoopGetFloatSwap() {
+        float r = 0;
         for (int i = 0; i < heapByteBufferSwap.capacity(); i+=4) {
             r += heapByteBufferSwap.getFloat(i);
         }
@@ -724,8 +724,8 @@ public int testHeapLoopGetFloatSwap() {
     // -- Heap_Float__RO
 
     @Benchmark
-    public int testHeapLoopGetFloatRO() {
-        int r = 0;
+    public float testHeapLoopGetFloatRO() {
+        float r = 0;
         for (int i = 0; i < heapByteBufferRO.capacity(); i+=4) {
             r += heapByteBufferRO.getFloat(i);
         }
@@ -742,8 +742,8 @@ public void testHeapLoopPutFloat() {
     }
 
     @Benchmark
-    public int testHeapLoopGetFloat() {
-        int r = 0;
+    public float testHeapLoopGetFloat() {
+        float r = 0;
         for (int i = 0; i < heapByteBuffer.capacity(); i+=4) {
             r += heapByteBuffer.getFloat(i);
         }
@@ -753,8 +753,8 @@ public int testHeapLoopGetFloat() {
     // -- Direct_Float_Swap_RO
 
     @Benchmark
-    public int testDirectLoopGetFloatSwapRO() {
-        int r = 0;
+    public float testDirectLoopGetFloatSwapRO() {
+        float r = 0;
         for (int i = 0; i < directByteBufferSwapRO.capacity(); i+=4) {
             r += directByteBufferSwapRO.getFloat(i);
         }
@@ -771,8 +771,8 @@ public void testDirectLoopPutFloatSwap() {
     }
 
     @Benchmark
-    public int testDirectLoopGetFloatSwap() {
-        int r = 0;
+    public float testDirectLoopGetFloatSwap() {
+        float r = 0;
         for (int i = 0; i < directByteBufferSwap.capacity(); i+=4) {
             r += directByteBufferSwap.getFloat(i);
         }
@@ -782,8 +782,8 @@ public int testDirectLoopGetFloatSwap() {
     // -- Direct_Float__RO
 
     @Benchmark
-    public int testDirectLoopGetFloatRO() {
-        int r = 0;
+    public float testDirectLoopGetFloatRO() {
+        float r = 0;
         for (int i = 0; i < directByteBufferRO.capacity(); i+=4) {
             r += directByteBufferRO.getFloat(i);
         }
@@ -800,8 +800,8 @@ public void testDirectLoopPutFloat() {
     }
 
     @Benchmark
-    public int testDirectLoopGetFloat() {
-        int r = 0;
+    public float testDirectLoopGetFloat() {
+        float r = 0;
         for (int i = 0; i < directByteBuffer.capacity(); i+=4) {
             r += directByteBuffer.getFloat(i);
         }
@@ -811,8 +811,8 @@ public int testDirectLoopGetFloat() {
     // -- Heap_Double_Swap_RO
 
     @Benchmark
-    public int testHeapLoopGetDoubleSwapRO() {
-        int r = 0;
+    public double testHeapLoopGetDoubleSwapRO() {
+        double r = 0;
         for (int i = 0; i < heapByteBufferSwapRO.capacity(); i+=8) {
             r += heapByteBufferSwapRO.getDouble(i);
         }
@@ -829,8 +829,8 @@ public void testHeapLoopPutDoubleSwap() {
     }
 
     @Benchmark
-    public int testHeapLoopGetDoubleSwap() {
-        int r = 0;
+    public double testHeapLoopGetDoubleSwap() {
+        double r = 0;
         for (int i = 0; i < heapByteBufferSwap.capacity(); i+=8) {
             r += heapByteBufferSwap.getDouble(i);
         }
@@ -840,8 +840,8 @@ public int testHeapLoopGetDoubleSwap() {
     // -- Heap_Double__RO
 
     @Benchmark
-    public int testHeapLoopGetDoubleRO() {
-        int r = 0;
+    public double testHeapLoopGetDoubleRO() {
+        double r = 0;
         for (int i = 0; i < heapByteBufferRO.capacity(); i+=8) {
             r += heapByteBufferRO.getDouble(i);
         }
@@ -858,8 +858,8 @@ public void testHeapLoopPutDouble() {
     }
 
     @Benchmark
-    public int testHeapLoopGetDouble() {
-        int r = 0;
+    public double testHeapLoopGetDouble() {
+        double r = 0;
         for (int i = 0; i < heapByteBuffer.capacity(); i+=8) {
             r += heapByteBuffer.getDouble(i);
         }
@@ -869,8 +869,8 @@ public int testHeapLoopGetDouble() {
     // -- Direct_Double_Swap_RO
 
     @Benchmark
-    public int testDirectLoopGetDoubleSwapRO() {
-        int r = 0;
+    public double testDirectLoopGetDoubleSwapRO() {
+        double r = 0;
         for (int i = 0; i < directByteBufferSwapRO.capacity(); i+=8) {
             r += directByteBufferSwapRO.getDouble(i);
         }
@@ -887,8 +887,8 @@ public void testDirectLoopPutDoubleSwap() {
     }
 
     @Benchmark
-    public int testDirectLoopGetDoubleSwap() {
-        int r = 0;
+    public double testDirectLoopGetDoubleSwap() {
+        double r = 0;
         for (int i = 0; i < directByteBufferSwap.capacity(); i+=8) {
             r += directByteBufferSwap.getDouble(i);
         }
@@ -898,8 +898,8 @@ public int testDirectLoopGetDoubleSwap() {
     // -- Direct_Double__RO
 
     @Benchmark
-    public int testDirectLoopGetDoubleRO() {
-        int r = 0;
+    public double testDirectLoopGetDoubleRO() {
+        double r = 0;
         for (int i = 0; i < directByteBufferRO.capacity(); i+=8) {
             r += directByteBufferRO.getDouble(i);
         }
@@ -916,8 +916,8 @@ public void testDirectLoopPutDouble() {
     }
 
     @Benchmark
-    public int testDirectLoopGetDouble() {
-        int r = 0;
+    public double testDirectLoopGetDouble() {
+        double r = 0;
         for (int i = 0; i < directByteBuffer.capacity(); i+=8) {
             r += directByteBuffer.getDouble(i);
         }