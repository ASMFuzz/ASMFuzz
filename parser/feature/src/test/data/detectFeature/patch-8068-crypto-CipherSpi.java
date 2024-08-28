@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,14 +25,10 @@
 
 package javax.crypto;
 
-import java.util.StringTokenizer;
-import java.util.NoSuchElementException;
 import java.security.AlgorithmParameters;
-import java.security.Provider;
 import java.security.Key;
 import java.security.SecureRandom;
 import java.security.NoSuchAlgorithmException;
-import java.security.NoSuchProviderException;
 import java.security.InvalidKeyException;
 import java.security.InvalidAlgorithmParameterException;
 import java.security.ProviderException;
@@ -558,10 +554,7 @@ protected int engineUpdate(ByteBuffer input, ByteBuffer output)
             throws ShortBufferException {
         try {
             return bufferCrypt(input, output, true);
-        } catch (IllegalBlockSizeException e) {
-            // never thrown for engineUpdate()
-            throw new ProviderException("Internal error in update()");
-        } catch (BadPaddingException e) {
+        } catch (IllegalBlockSizeException | BadPaddingException e) {
             // never thrown for engineUpdate()
             throw new ProviderException("Internal error in update()");
         }