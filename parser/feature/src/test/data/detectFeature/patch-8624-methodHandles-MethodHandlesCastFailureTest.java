@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -74,14 +74,7 @@ static void testImpl() throws Exception {
         String verifyOpt =
             Platform.isDebugBuild() ? "-XX:-VerifyDependencies" : "-showversion";
 
-        String[] classPaths = javaClassPath.split(File.pathSeparator);
-        String junitJar = null;
-        for (String path : classPaths) {
-            if (path.endsWith("junit.jar")) {
-                junitJar = path;
-                break;
-            }
-        }
+        String junitJar = Path.of(Test.class.getProtectionDomain().getCodeSource().getLocation().toURI()).toString();
 
         String jars = appJar + ps + junitJar;
 