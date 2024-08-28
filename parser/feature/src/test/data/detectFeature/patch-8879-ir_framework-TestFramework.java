@@ -23,11 +23,13 @@
 
 package compiler.lib.ir_framework;
 
-import compiler.lib.ir_framework.driver.*;
+import compiler.lib.ir_framework.driver.FlagVMProcess;
+import compiler.lib.ir_framework.driver.TestVMException;
+import compiler.lib.ir_framework.driver.TestVMProcess;
 import compiler.lib.ir_framework.driver.irmatching.IRMatcher;
 import compiler.lib.ir_framework.driver.irmatching.IRViolationException;
 import compiler.lib.ir_framework.shared.*;
-import compiler.lib.ir_framework.test.*;
+import compiler.lib.ir_framework.test.TestVM;
 import jdk.test.lib.Platform;
 import jdk.test.lib.Utils;
 import jdk.test.lib.helpers.ClassFileInstaller;
@@ -36,6 +38,10 @@
 import java.io.PrintWriter;
 import java.io.StringWriter;
 import java.lang.reflect.Method;
+import java.net.MalformedURLException;
+import java.net.URL;
+import java.net.URLClassLoader;
+import java.nio.file.Path;
 import java.util.*;
 import java.util.stream.Collectors;
 
@@ -137,7 +143,6 @@ public class TestFramework {
     public static final boolean EXCLUDELIST = !System.getProperty("Exclude", "").isEmpty();
     private static final boolean REPORT_STDOUT = Boolean.getBoolean("ReportStdout");
     // Only used for internal testing and should not be used for normal user testing.
-    private static final boolean SKIP_WHITEBOX_INSTALL = Boolean.getBoolean("SkipWhiteBoxInstall");
 
     private static final String RERUN_HINT = """
                                                #############################################################
@@ -314,7 +319,7 @@ public TestFramework addScenarios(Scenario... scenarios) {
      * set test class.
      */
     public void start() {
-        if (!SKIP_WHITEBOX_INSTALL) {
+        if (shouldInstallWhiteBox()) {
             installWhiteBox();
         }
         disableIRVerificationIfNotFeasible();
@@ -336,6 +341,28 @@ public void start() {
         }
     }
 
+    /**
+     * Try to load the Whitebox class from the user directory with a custom class loader. If the user has already built the
+     * Whitebox, we can load it. Otherwise, the framework needs to install it.
+     *
+     * @return true if the framework needs to install the Whitebox
+     */
+    private boolean shouldInstallWhiteBox() {
+        try {
+            URL url = Path.of(System.getProperty("user.dir")).toUri().toURL();
+            URLClassLoader userDirClassLoader =
+                    URLClassLoader.newInstance(new URL[] {url}, TestFramework.class.getClassLoader().getParent());
+            Class.forName(WhiteBox.class.getName(), false, userDirClassLoader);
+        } catch (MalformedURLException e) {
+            throw new TestFrameworkException("corrupted user.dir property", e);
+        } catch (ClassNotFoundException e) {
+            // We need to manually install the WhiteBox if we cannot load the WhiteBox class from the user directory.
+            // This happens when the user test does not explicitly install the WhiteBox as part of the test.
+            return true;
+        }
+        return false;
+    }
+
     /**
      * Set a new default warm-up (overriding the framework default of 2000 at
      * {@link TestVM#WARMUP_ITERATIONS}) to be applied for all tests that do not specify an explicit