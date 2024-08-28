@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -138,7 +138,7 @@ private static long mappingAddress(long address, long mappingOffset) {
         return mappingAddress(address, mappingOffset, 0);
     }
 
-    // Given an offset previously otained from calling
+    // Given an offset previously obtained from calling
     // mappingOffset(index) returns the largest page aligned address
     // of the mapping less than or equal to the address of the buffer
     // element identified by index.
@@ -147,7 +147,7 @@ private static long mappingAddress(long address, long mappingOffset, long index)
         return indexAddress - mappingOffset;
     }
 
-    // given a mappingOffset previously otained from calling
+    // given a mappingOffset previously obtained from calling
     // mappingOffset(index) return that offset added to the supplied
     // length.
     private static long mappingLength(long mappingOffset, long length) {