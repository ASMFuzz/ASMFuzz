@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2011, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2011, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -487,7 +487,7 @@ public void engineSetCertificateEntry(String alias, Certificate cert)
                 if (value instanceof TrustedCertEntry) {
                     TrustedCertEntry tce = (TrustedCertEntry)value;
                     if (tce.cert.equals(cert)) {
-                        throw new KeyStoreException("Keychain does not support mulitple copies of same certificate.");
+                        throw new KeyStoreException("Keychain does not support multiple copies of same certificate.");
                     }
                 }
             }