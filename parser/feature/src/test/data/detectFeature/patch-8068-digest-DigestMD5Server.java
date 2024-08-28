@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -614,10 +614,7 @@ private byte[] validateClientResponse(byte[][] responseVal)
                     passwd, nonce /* use own nonce */,
                     cnonce, NONCE_COUNT_VALUE, authzidBytes);
 
-            } catch (NoSuchAlgorithmException e) {
-                throw new SaslException(
-                    "DIGEST-MD5: problem duplicating client response", e);
-            } catch (IOException e) {
+            } catch (NoSuchAlgorithmException | IOException e) {
                 throw new SaslException(
                     "DIGEST-MD5: problem duplicating client response", e);
             }
@@ -705,9 +702,7 @@ private byte[] generateResponseAuth(String username, char[] passwd,
 
             return challenge;
 
-        } catch (NoSuchAlgorithmException e) {
-            throw new SaslException("DIGEST-MD5: problem generating response", e);
-        } catch (IOException e) {
+        } catch (NoSuchAlgorithmException | IOException e) {
             throw new SaslException("DIGEST-MD5: problem generating response", e);
         }
     }