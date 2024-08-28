@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -63,8 +63,14 @@ private static long codeValueOf(char c) {
         return codes[c] & 0xffffffff00000000L;
     }
 
-    private static long codeLengthOf(char c) {
-        return codes[c] & 0x00000000ffffffffL;
+    private static int codeLengthOf(char c) {
+        // codes are up to 30 bits long - and their length
+        // is coded on 5 bits which means casting to int here is safe: the
+        // returned value is expected to be in the range (5..30) and will
+        // never be negative.
+        int len = (int) (codes[c] & 0x00000000ffffffffL);
+        assert len >= 0;
+        return len;
     }
 
     private static final int EOS_LENGTH = 30;
@@ -732,7 +738,7 @@ public boolean write(ByteBuffer destination) {
                     if (c > 255) {
                         throw new IllegalArgumentException("char=" + ((int) c));
                     }
-                    long len = codeLengthOf(c);
+                    int len = codeLengthOf(c);
                     if (bufferLen + len <= 64) {
                         buffer |= (codeValueOf(c) >>> bufferLen); // append
                         bufferLen += len;