@@ -53,19 +53,7 @@ public static void main(String... args) throws Exception {
         out.shouldContain("Verification for BadMap50 failed");
         out.shouldContain("Fail over class verification to old verifier for: BadMap50");
 
-        // (2)
-        if (Platform.isDebugBuild()) {
-            pb = ProcessTools.createJavaProcessBuilder("-Xlog:class+init=info",
-                                                       "-Xverify:all",
-                                                       "-XX:+EagerInitialization",
-                                                       "-Xmx128m",
-                                                       InnerClass.class.getName());
-            out = new OutputAnalyzer(pb.start());
-            out.shouldContain("[Initialized").shouldContain("without side effects]");
-            out.shouldHaveExitValue(0);
-        }
-
-        // (3) class+init should turn off.
+        // (2) class+init should turn off.
         pb = ProcessTools.createJavaProcessBuilder("-Xlog:class+init=off",
                                                    "-Xverify:all",
                                                    "-Xmx128m",