@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1996, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -1507,9 +1507,7 @@ protected void engineUpdate(byte[] b, int off, int len)
         protected byte[] engineSign() throws SignatureException {
             try {
                 return cipher.doFinal();
-            } catch (IllegalBlockSizeException e) {
-                throw new SignatureException("doFinal() failed", e);
-            } catch (BadPaddingException e) {
+            } catch (IllegalBlockSizeException | BadPaddingException e) {
                 throw new SignatureException("doFinal() failed", e);
             }
         }