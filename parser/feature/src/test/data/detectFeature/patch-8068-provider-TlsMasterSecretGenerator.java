@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -148,9 +148,7 @@ protected SecretKey engineGenerateKey() {
             // Do not touch it anymore.
             return new TlsMasterSecretKey(master, premasterMajor,
                 premasterMinor);
-        } catch (NoSuchAlgorithmException e) {
-            throw new ProviderException(e);
-        } catch (DigestException e) {
+        } catch (NoSuchAlgorithmException | DigestException e) {
             throw new ProviderException(e);
         } finally {
             if (premaster != null) {