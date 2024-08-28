@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2016, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -159,7 +159,7 @@ private static void testCertOutput() throws Throwable {
                 .shouldContain("Certificate #1:")
                 .shouldContain("Certificate #2:")
                 .shouldContain("Signer #2:")
-                .shouldMatch("The certificate #.* of signer #.*" + "uses the SHA1withRSA.*will be disabled")
+                .shouldMatch("The certificate #.* of signer #.*" + "uses the SHA1withRSA.*considered a security risk")
                 .shouldMatch("The certificate #.* of signer #.*" + "uses a 512-bit RSA key.*is disabled")
                 .shouldHaveExitValue(0);
 