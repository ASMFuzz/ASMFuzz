@@ -57,6 +57,8 @@ public class TooSmallStackSize {
     static final String ThreadStackSizeString = "Java thread stack size";
     static final String VMThreadStackSizeString = "VMThreadStackSize";
 
+    static String testShadowSize = null;
+
     /*
      * Returns the minimum stack size this platform will allowed based on the
      * contents of the error message the JVM outputs when too small of a
@@ -90,6 +92,25 @@ static String getMinStackAllowed(String testOutput) {
         throw new RuntimeException("test fails");
     }
 
+    static ProcessBuilder createProcessWithOptions(String stackOption, String stackSize) throws Exception {
+        if (testShadowSize == null) {
+            return ProcessTools.createJavaProcessBuilder(
+                stackOption + stackSize,
+                // Uncomment the following to get log output
+                // that shows actual thread creation sizes.
+                // "-Xlog:os+thread",
+                "-version");
+        } else {
+            return ProcessTools.createJavaProcessBuilder(
+                stackOption + stackSize,
+                // Uncomment the following to get log output
+                // that shows actual thread creation sizes.
+                // "-Xlog:os+thread",
+                "-XX:StackShadowPages=" + testShadowSize,
+                "-version");
+        }
+    }
+
     /*
      * Run the JVM with the specified stack size.
      *
@@ -101,13 +122,7 @@ static String checkStack(String stackOption, String optionMesg, String stackSize
 
         System.out.println("*** Testing " + stackOption + stackSize);
 
-        ProcessBuilder pb = ProcessTools.createJavaProcessBuilder(
-            stackOption + stackSize,
-            // Uncomment the following to get log output
-            // that shows actual thread creation sizes.
-            // "-Xlog:os+thread",
-            "-version");
-
+        ProcessBuilder pb = createProcessWithOptions(stackOption, stackSize);
         OutputAnalyzer output = new OutputAnalyzer(pb.start());
 
         if (verbose) {
@@ -144,20 +159,14 @@ static String checkStack(String stackOption, String optionMesg, String stackSize
     static void checkMinStackAllowed(String stackOption, String optionMesg, String stackSize) throws Exception {
         System.out.println("*** Testing " + stackOption + stackSize);
 
-        ProcessBuilder pb = ProcessTools.createJavaProcessBuilder(
-            stackOption + stackSize,
-            // Uncomment the following to get log output
-            // that shows actual thread creation sizes.
-            // "-Xlog:os+thread",
-            "-version");
-
+        ProcessBuilder pb = createProcessWithOptions(stackOption, stackSize);
         OutputAnalyzer output = new OutputAnalyzer(pb.start());
         output.shouldHaveExitValue(0);
 
         System.out.println("PASSED: VM launched with " + stackOption + stackSize);
     }
 
-    public static void main(String... args) throws Exception {
+    public static void test(String... args) throws Exception {
         /*
          * The result of a 16k stack size should be a quick exit with a complaint
          * that the stack size is too small. However, for some win32 builds, the
@@ -209,4 +218,13 @@ public static void main(String... args) throws Exception {
         checkMinStackAllowed("-XX:VMThreadStackSize=", VMThreadStackSizeString, "513");
         checkMinStackAllowed("-XX:VMThreadStackSize=", VMThreadStackSizeString, "0");
     }
+
+    // aarch64 StackShadowPage size range is 25-55
+    static String shadowSizes[] = { null, "30" };
+    public static void main(java.lang.String[] unused) throws Exception {
+        for (String sz : shadowSizes) {
+            testShadowSize = sz;
+            test();
+        }
+    }
 }