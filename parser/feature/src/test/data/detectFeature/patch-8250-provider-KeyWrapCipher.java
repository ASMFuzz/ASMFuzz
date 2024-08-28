@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2004, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2004, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -545,7 +545,7 @@ protected int engineDoFinal(byte[] in, int inOfs, int inLen,
     // actual impl for various engineDoFinal(...) methods.
     // prepare 'out' buffer with the buffered bytes in 'dataBuf',
     // and the to-be-processed bytes in 'in', then perform single-part
-    // encryption/decrytion over 'out' buffer
+    // encryption/decryption over 'out' buffer
     private int implDoFinal(byte[] in, int inOfs, int inLen, byte[] out)
         throws IllegalBlockSizeException, BadPaddingException,
             ShortBufferException {