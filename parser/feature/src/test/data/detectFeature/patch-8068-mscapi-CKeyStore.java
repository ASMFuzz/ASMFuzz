@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -814,13 +814,7 @@ private void generateCertificate(byte[] data,
             Collection<? extends Certificate> c =
                     certificateFactory.generateCertificates(bis);
             certCollection.addAll(c);
-        } catch (CertificateException e) {
-            // Ignore the exception and skip this certificate
-            // If e is thrown, remember to deal with it in
-            // native code.
-        }
-        catch (Throwable te)
-        {
+        } catch (Throwable te) {
             // Ignore the exception and skip this certificate
             // If e is thrown, remember to deal with it in
             // native code.