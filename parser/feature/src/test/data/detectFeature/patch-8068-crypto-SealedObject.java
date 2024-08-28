@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -259,10 +259,8 @@ public final Object getObject(Key key)
             // them into NoSuchAlgorithmException's with details about
             // the failing algorithm
             throw new NoSuchAlgorithmException("algorithm not found");
-        } catch (IllegalBlockSizeException ibse) {
-            throw new InvalidKeyException(ibse.getMessage());
-        } catch (BadPaddingException bpe) {
-            throw new InvalidKeyException(bpe.getMessage());
+        } catch (IllegalBlockSizeException | BadPaddingException e) {
+            throw new InvalidKeyException(e.getMessage());
         }
     }
 