@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -107,10 +107,7 @@ private Krb5InitCredential(Krb5NameElement name,
                                               endTime,
                                               renewTill,
                                               clientAddresses);
-        } catch (KrbException e) {
-            throw new GSSException(GSSException.NO_CRED, -1,
-                                   e.getMessage());
-        } catch (IOException e) {
+        } catch (KrbException | IOException e) {
             throw new GSSException(GSSException.NO_CRED, -1,
                                    e.getMessage());
         }