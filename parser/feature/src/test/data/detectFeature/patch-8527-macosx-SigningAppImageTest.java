@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2019, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2019, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -22,8 +22,11 @@
  */
 
 import java.nio.file.Path;
+import java.util.List;
+
 import jdk.jpackage.test.JPackageCommand;
 import jdk.jpackage.test.Annotations.Test;
+import jdk.jpackage.test.Annotations.Parameter;
 import jdk.jpackage.test.AdditionalLauncher;
 
 /**
@@ -59,26 +62,31 @@
 public class SigningAppImageTest {
 
     @Test
-    public static void test() throws Exception {
+    @Parameter("true")
+    @Parameter("false")
+    public void test(boolean doSign) throws Exception {
         SigningCheck.checkCertificates();
 
         JPackageCommand cmd = JPackageCommand.helloAppImage();
-        cmd.addArguments("--mac-sign", "--mac-signing-key-user-name",
-                SigningBase.DEV_NAME, "--mac-signing-keychain",
-                SigningBase.KEYCHAIN);
-
+        if (doSign) {
+            cmd.addArguments("--mac-sign", "--mac-signing-key-user-name",
+                    SigningBase.DEV_NAME, "--mac-signing-keychain",
+                    SigningBase.KEYCHAIN);
+        }
         AdditionalLauncher testAL = new AdditionalLauncher("testAL");
         testAL.applyTo(cmd);
         cmd.executeAndAssertHelloAppImageCreated();
 
         Path launcherPath = cmd.appLauncherPath();
-        SigningBase.verifyCodesign(launcherPath, true);
+        SigningBase.verifyCodesign(launcherPath, doSign);
 
         Path testALPath = launcherPath.getParent().resolve("testAL");
-        SigningBase.verifyCodesign(testALPath, true);
+        SigningBase.verifyCodesign(testALPath, doSign);
 
         Path appImage = cmd.outputBundle();
-        SigningBase.verifyCodesign(appImage, true);
-        SigningBase.verifySpctl(appImage, "exec");
+        SigningBase.verifyCodesign(appImage, doSign);
+        if (doSign) {
+            SigningBase.verifySpctl(appImage, "exec");
+        }
     }
 }