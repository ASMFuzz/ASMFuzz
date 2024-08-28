@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -225,12 +225,9 @@ public byte[] evaluateResponse(byte[] responseData)
         } catch (NoSuchAlgorithmException e) {
             aborted = true;
             throw new SaslException("MD5 algorithm not available on platform", e);
-        } catch (UnsupportedCallbackException e) {
-            aborted = true;
-            throw new SaslException("CRAM-MD5 authentication failed", e);
         } catch (SaslException e) {
             throw e; // rethrow
-        } catch (IOException e) {
+        } catch (UnsupportedCallbackException | IOException e) {
             aborted = true;
             throw new SaslException("CRAM-MD5 authentication failed", e);
         }