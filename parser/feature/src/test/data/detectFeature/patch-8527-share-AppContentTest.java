@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -99,7 +99,9 @@ public void test() throws Exception {
                 }
 
             })
-            .setExpectedExitCode(testPathArgs.contains(TEST_BAD) ? 1 : 0)
+            // On macOS aarch64 we always signing app image and signing will fail, since
+            // test produces invalid app bundle.
+            .setExpectedExitCode(testPathArgs.contains(TEST_BAD) || TKit.isArmMac() ? 1 : 0)
             .run();
         }
 }