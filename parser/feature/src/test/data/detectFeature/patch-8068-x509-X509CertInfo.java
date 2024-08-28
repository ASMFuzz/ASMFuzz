@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -229,9 +229,7 @@ public byte[] getEncodedInfo() throws CertificateEncodingException {
                 rawCertInfo = tmp.toByteArray();
             }
             return rawCertInfo.clone();
-        } catch (IOException e) {
-            throw new CertificateEncodingException(e.toString());
-        } catch (CertificateException e) {
+        } catch (IOException | CertificateException e) {
             throw new CertificateEncodingException(e.toString());
         }
     }