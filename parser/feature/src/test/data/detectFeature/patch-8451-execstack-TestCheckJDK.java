@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2017, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2017, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -48,7 +48,7 @@ public class TestCheckJDK {
     static void checkExecStack(Path file) {
         String filename = file.toString();
         Path parent = file.getParent();
-        if (parent.endsWith("bin") || filename.endsWith(".so")) {
+        if ((parent.endsWith("bin") && !filename.endsWith(".diz")) || filename.endsWith(".so")) {
             if (!WB.checkLibSpecifiesNoexecstack(filename)) {
                 System.out.println("Library does not have the noexecstack bit set: " + filename);
                 testPassed = false;