@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2002, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2002, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -162,7 +162,7 @@ private static final int[] expandToSubKey(int[][] kr, boolean decrypting) {
     private static final byte[] rcon = new byte[30];
 
 
-    // Static code - to intialise S-boxes and T-boxes
+    // Static code - to initialise S-boxes and T-boxes
     static
     {
         int ROOT = 0x11B;