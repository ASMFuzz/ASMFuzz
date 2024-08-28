@@ -1,5 +1,5 @@
 #!/bin/bash
-# Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
+# Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
 # DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 #
 # This code is free software; you can redistribute it and/or modify it
@@ -106,14 +106,7 @@ public class $i {
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
 