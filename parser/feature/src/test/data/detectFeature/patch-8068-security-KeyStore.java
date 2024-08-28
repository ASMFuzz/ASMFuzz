@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -867,10 +867,8 @@ public static KeyStore getInstance(String type)
         try {
             Object[] objs = Security.getImpl(type, "KeyStore", (String)null);
             return new KeyStore((KeyStoreSpi)objs[0], (Provider)objs[1], type);
-        } catch (NoSuchAlgorithmException nsae) {
-            throw new KeyStoreException(type + " not found", nsae);
-        } catch (NoSuchProviderException nspe) {
-            throw new KeyStoreException(type + " not found", nspe);
+        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
+            throw new KeyStoreException(type + " not found", e);
         }
     }
 