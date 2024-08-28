@@ -370,6 +370,8 @@ public AppOutputVerifier addParam(String name, String value) {
                 params.put(name, value);
             } else if ("jpackage.test.appOutput".equals(name)) {
                 outputFilePath = Path.of(value);
+            } else if ("jpackage.test.exitCode".equals(name)) {
+                expectedExitCode = Integer.parseInt(value);
             }
             return this;
         }
@@ -421,8 +423,8 @@ public void executeAndVerifyOutput(boolean removePath,
             final int attempts = 3;
             final int waitBetweenAttemptsSeconds = 5;
             getExecutor(launcherArgs.toArray(new String[0])).dumpOutput().setRemovePath(
-                    removePath).executeAndRepeatUntilExitCode(0, attempts,
-                            waitBetweenAttemptsSeconds);
+                    removePath).executeAndRepeatUntilExitCode(expectedExitCode,
+                            attempts, waitBetweenAttemptsSeconds);
             verifyOutputFile(outputFilePath, appArgs, params);
         }
 
@@ -468,6 +470,7 @@ private Executor getExecutor(String...args) {
 
         private final Path launcherPath;
         private Path outputFilePath;
+        private int expectedExitCode;
         private final List<String> defaultLauncherArgs;
         private final Map<String, String> params;
     }