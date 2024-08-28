@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2019, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -24,8 +24,12 @@
 package jdk.jpackage.test;
 
 import java.io.IOException;
+import java.lang.reflect.InvocationTargetException;
+import java.lang.reflect.Method;
 import java.nio.file.Files;
 import java.nio.file.Path;
+import java.util.List;
+import java.util.Optional;
 
 public final class LauncherIconVerifier {
     public LauncherIconVerifier() {
@@ -60,7 +64,11 @@ public void applyTo(JPackageCommand cmd) throws IOException {
         Path iconPath = cmd.appLayout().destktopIntegrationDirectory().resolve(
                 curLauncherName + TKit.ICON_SUFFIX);
 
-        if (expectedDefault) {
+        if (TKit.isWindows()) {
+            TKit.assertPathExists(iconPath, false);
+            WinIconVerifier.instance.verifyLauncherIcon(cmd, launcherName,
+                    expectedIcon, expectedDefault);
+        } else if (expectedDefault) {
             TKit.assertPathExists(iconPath, true);
         } else if (expectedIcon == null) {
             TKit.assertPathExists(iconPath, false);
@@ -73,6 +81,136 @@ public void applyTo(JPackageCommand cmd) throws IOException {
         }
     }
 
+    private static class WinIconVerifier {
+
+        void verifyLauncherIcon(JPackageCommand cmd, String launcherName,
+                Path expectedIcon, boolean expectedDefault) {
+            TKit.withTempDirectory("icons", tmpDir -> {
+                Path launcher = cmd.appLauncherPath(launcherName);
+                Path iconWorkDir = tmpDir.resolve(launcher.getFileName());
+                Path iconContainer = iconWorkDir.resolve("container.exe");
+                Files.createDirectories(iconContainer.getParent());
+                Files.copy(getDefaultAppLauncher(expectedIcon == null
+                        && !expectedDefault), iconContainer);
+                if (expectedIcon != null) {
+                    setIcon(expectedIcon, iconContainer);
+                }
+
+                Path extractedExpectedIcon = extractIconFromExecutable(
+                        iconWorkDir, iconContainer, "expected");
+                Path extractedActualIcon = extractIconFromExecutable(iconWorkDir,
+                        launcher, "actual");
+                TKit.assertTrue(-1 == Files.mismatch(extractedExpectedIcon,
+                        extractedActualIcon),
+                        String.format(
+                                "Check icon file [%s] of %s launcher is a copy of source icon file [%s]",
+                                extractedActualIcon,
+                                Optional.ofNullable(launcherName).orElse("main"),
+                                extractedExpectedIcon));
+            });
+        }
+
+        private WinIconVerifier() {
+            try {
+                executableRebranderClass = Class.forName(
+                        "jdk.jpackage.internal.ExecutableRebrander");
+
+                lockResource = executableRebranderClass.getDeclaredMethod(
+                        "lockResource", String.class);
+                // Note: this reflection call requires
+                // --add-opens jdk.jpackage/jdk.jpackage.internal=ALL-UNNAMED
+                lockResource.setAccessible(true);
+
+                unlockResource = executableRebranderClass.getDeclaredMethod(
+                        "unlockResource", long.class);
+                unlockResource.setAccessible(true);
+
+                iconSwap = executableRebranderClass.getDeclaredMethod("iconSwap",
+                        long.class, String.class);
+                iconSwap.setAccessible(true);
+            } catch (ClassNotFoundException | NoSuchMethodException
+                    | SecurityException ex) {
+                throw Functional.rethrowUnchecked(ex);
+            }
+        }
+
+        private Path extractIconFromExecutable(Path outputDir, Path executable,
+                String label) {
+            Path psScript = outputDir.resolve(label + ".ps1");
+            Path extractedIcon = outputDir.resolve(label + ".bmp");
+            TKit.createTextFile(psScript, List.of(
+                    "[System.Reflection.Assembly]::LoadWithPartialName('System.Drawing')",
+                    String.format(
+                            "[System.Drawing.Icon]::ExtractAssociatedIcon(\"%s\").ToBitmap().Save(\"%s\", [System.Drawing.Imaging.ImageFormat]::Bmp)",
+                            executable.toAbsolutePath().normalize(),
+                            extractedIcon.toAbsolutePath().normalize()),
+                    "exit 0"));
+
+            Executor.of("powershell", "-NoLogo", "-NoProfile", "-File",
+                    psScript.toAbsolutePath().normalize().toString()).execute();
+
+            return extractedIcon;
+        }
+
+        private Path getDefaultAppLauncher(boolean noIcon) {
+            // Create app image with the sole purpose to get the default app launcher
+            Path defaultAppOutputDir = TKit.workDir().resolve(String.format(
+                    "out-%d", ProcessHandle.current().pid()));
+            JPackageCommand cmd = JPackageCommand.helloAppImage().setFakeRuntime().setArgumentValue(
+                    "--dest", defaultAppOutputDir);
+
+            String launcherName;
+            if (noIcon) {
+                launcherName = "no-icon";
+                new AdditionalLauncher(launcherName).setNoIcon().applyTo(cmd);
+            } else {
+                launcherName = null;
+            }
+
+            if (!Files.isExecutable(cmd.appLauncherPath(launcherName))) {
+                cmd.execute();
+            }
+            return cmd.appLauncherPath(launcherName);
+        }
+
+        private void setIcon(Path iconPath, Path launcherPath) {
+            TKit.trace(String.format("Set icon of [%s] launcher to [%s] file",
+                    launcherPath, iconPath));
+            try {
+                launcherPath.toFile().setWritable(true, true);
+                try {
+                    long lock = 0;
+                    try {
+                        lock = (Long) lockResource.invoke(null, new Object[]{
+                            launcherPath.toAbsolutePath().normalize().toString()});
+                        if (lock == 0) {
+                            throw new RuntimeException(String.format(
+                                    "Failed to lock [%s] executable",
+                                    launcherPath));
+                        }
+                        iconSwap.invoke(null, new Object[]{lock,
+                            iconPath.toAbsolutePath().normalize().toString()});
+                    } finally {
+                        if (lock != 0) {
+                            unlockResource.invoke(null, new Object[]{lock});
+                        }
+                    }
+                } catch (IllegalAccessException | InvocationTargetException ex) {
+                    throw Functional.rethrowUnchecked(ex);
+                }
+            } finally {
+                launcherPath.toFile().setWritable(false, true);
+            }
+        }
+
+        final static WinIconVerifier instance = new WinIconVerifier();
+
+        private final Class executableRebranderClass;
+        private final Method lockResource;
+        private final Method unlockResource;
+        private final Method iconSwap;
+    }
+
     private String launcherName;
     private Path expectedIcon;
     private boolean expectedDefault;