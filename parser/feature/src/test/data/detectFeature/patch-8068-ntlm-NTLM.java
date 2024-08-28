@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2010, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2010, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -84,9 +84,7 @@ protected NTLM(String version) throws NTLMException {
             md4 = sun.security.provider.MD4.getInstance();
             hmac = Mac.getInstance("HmacMD5");
             md5 = MessageDigest.getInstance("MD5");
-        } catch (NoSuchPaddingException e) {
-            throw new AssertionError();
-        } catch (NoSuchAlgorithmException e) {
+        } catch (NoSuchPaddingException | NoSuchAlgorithmException e) {
             throw new AssertionError();
         }
     }
@@ -346,11 +344,7 @@ byte[] calcResponse (byte[] key, byte[] text) {
             return result;
         } catch (IllegalBlockSizeException ex) {    // None will happen
             assert false;
-        } catch (BadPaddingException ex) {
-            assert false;
-        } catch (InvalidKeySpecException ex) {
-            assert false;
-        } catch (InvalidKeyException ex) {
+        } catch (BadPaddingException | InvalidKeyException | InvalidKeySpecException ex) {
             assert false;
         }
         return null;
@@ -364,9 +358,7 @@ byte[] hmacMD5(byte[] key, byte[] text) {
                     new SecretKeySpec(Arrays.copyOf(key, 16), "HmacMD5");
             hmac.init(skey);
             return hmac.doFinal(text);
-        } catch (InvalidKeyException ex) {
-            assert false;
-        } catch (RuntimeException e) {
+        } catch (InvalidKeyException | RuntimeException e) {
             assert false;
         }
         return null;