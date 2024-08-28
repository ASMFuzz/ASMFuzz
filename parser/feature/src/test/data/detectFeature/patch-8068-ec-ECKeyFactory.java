@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2006, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2006, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -59,9 +59,7 @@ private static KeyFactory getInstance() {
         if (instance == null) {
             try {
                 instance = KeyFactory.getInstance("EC", "SunEC");
-            } catch (NoSuchProviderException e) {
-                throw new RuntimeException(e);
-            } catch (NoSuchAlgorithmException e) {
+            } catch (NoSuchProviderException | NoSuchAlgorithmException e) {
                 throw new RuntimeException(e);
             }
         }