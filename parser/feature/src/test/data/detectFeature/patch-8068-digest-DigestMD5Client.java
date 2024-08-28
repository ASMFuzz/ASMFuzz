@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -662,10 +662,7 @@ private void validateResponseValue(byte[] fromServer) throws SaslException {
                 throw new SaslException(
                     "Server's rspauth value does not match what client expects");
             }
-        } catch (NoSuchAlgorithmException e) {
-            throw new SaslException(
-                "Problem generating response value for verification", e);
-        } catch (IOException e) {
+        } catch (NoSuchAlgorithmException | IOException e) {
             throw new SaslException(
                 "Problem generating response value for verification", e);
         }