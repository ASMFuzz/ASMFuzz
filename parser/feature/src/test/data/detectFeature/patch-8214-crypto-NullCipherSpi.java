@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -58,8 +58,7 @@ protected int engineGetOutputSize(int inputLen) {
     }
 
     protected byte[] engineGetIV() {
-        byte[] x = new byte[8];
-        return x;
+        return new byte[8];
     }
 
     protected AlgorithmParameters engineGetParameters() {