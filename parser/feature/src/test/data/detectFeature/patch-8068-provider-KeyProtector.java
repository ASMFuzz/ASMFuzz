@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1998, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1998, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -221,10 +221,8 @@ Key recover(EncryptedPrivateKeyInfo encrInfo)
             // Note: this catch needed to be here because of the
             // later catch of GeneralSecurityException
             throw ex;
-        } catch (IOException ioe) {
-            throw new UnrecoverableKeyException(ioe.getMessage());
-        } catch (GeneralSecurityException gse) {
-            throw new UnrecoverableKeyException(gse.getMessage());
+        } catch (IOException | GeneralSecurityException e) {
+            throw new UnrecoverableKeyException(e.getMessage());
         } finally {
             if (plain != null) Arrays.fill(plain, (byte) 0x00);
             if (sKey != null) {
@@ -403,12 +401,8 @@ Key unseal(SealedObject so, int maxLength)
             // Note: this catch needed to be here because of the
             // later catch of GeneralSecurityException
             throw ex;
-        } catch (IOException ioe) {
-            throw new UnrecoverableKeyException(ioe.getMessage());
-        } catch (ClassNotFoundException cnfe) {
-            throw new UnrecoverableKeyException(cnfe.getMessage());
-        } catch (GeneralSecurityException gse) {
-            throw new UnrecoverableKeyException(gse.getMessage());
+        } catch (IOException | GeneralSecurityException | ClassNotFoundException e) {
+            throw new UnrecoverableKeyException(e.getMessage());
         } finally {
             if (sKey != null) {
                 try {