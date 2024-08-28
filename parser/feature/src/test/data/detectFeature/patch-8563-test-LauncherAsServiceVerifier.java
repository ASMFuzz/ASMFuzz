@@ -227,12 +227,13 @@ private void applyToMainLauncher(PackageTest pkg) {
         pkg.addInstallVerifier(cmd -> {
             if (canVerifyInstall(cmd)) {
                 delayInstallVerify();
+                Path outputFilePath = appOutputFilePathVerify(cmd);
                 HelloApp.assertApp(cmd.appLauncherPath())
                         .addParam("jpackage.test.appOutput",
-                                appOutputFilePathVerify(cmd).toString())
+                                outputFilePath.toString())
                         .addDefaultArguments(expectedValue)
                         .verifyOutput();
-                TKit.deleteIfExists(appOutputFileName);
+                TKit.deleteIfExists(outputFilePath);
             }
         });
         pkg.addInstallVerifier(cmd -> {
@@ -247,7 +248,7 @@ protected void verify(JPackageCommand cmd) throws IOException {
                 if (canVerifyInstall(cmd)) {
                     delayInstallVerify();
                     super.verify(cmd);
-                    TKit.deleteIfExists(appOutputFileName);
+                    TKit.deleteIfExists(appOutputFilePathVerify(cmd));
                 }
                 LauncherAsServiceVerifier.verify(cmd, launcherName);
             }
@@ -320,7 +321,7 @@ private Path appOutputFilePathInitialize() {
         if (TKit.isWindows()) {
             dir = Path.of("$ROOTDIR");
         } else {
-            dir = Path.of(System.getProperty("java.io.tmpdir"));
+            dir = Path.of("/tmp");
         }
         return dir.resolve(appOutputFileName);
     }