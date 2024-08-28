@@ -1,5 +1,5 @@
 /*
-  * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
+  * Copyright (c) 2021, 2022, Oracle and/or its affiliates. All rights reserved.
   * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
   *
   * This code is free software; you can redistribute it and/or modify it
@@ -145,17 +145,17 @@ MemoryAddress address() {
     }
 
     @Benchmark
-    public int test() {
-        int sum = 0;
+    public long test() {
+        long sum = 0;
         for (int i = 0 ; i < ELEM_SIZE ; i++) {
             sum += ptr_ptr.get(i).address().toRawLongValue();
         }
         return sum;
     }
 
     @Benchmark
-    public int testFlat() {
-        int sum = 0;
+    public long testFlat() {
+        long sum = 0;
         for (int i = 0 ; i < ELEM_SIZE ; i++) {
             sum += ptr_ptr_flat.get(i).address().toRawLongValue();
         }