@@ -30,25 +30,17 @@
 import java.util.Arrays;
 
 public class Utils {
-    public static void shouldHaveThrownException(String s) {
+    public static void shouldHaveThrownException(String output) {
         // Do not throw an exception if we hit a safepoint while printing which could possibly let the IR matching fail.
         // This happens very rarely. If there is a problem with the test, then we will catch that on the next test invocation.
-        if (!s.contains(IRMatcher.SAFEPOINT_WHILE_PRINTING_MESSAGE)) {
+        if (!output.contains(IRMatcher.SAFEPOINT_WHILE_PRINTING_MESSAGE)) {
             Asserts.fail("Should have thrown exception");
         }
     }
 
-    /**
-     * Is there at least one scenario which hit a safepoint while printing (i.e. a bailout)?
-     */
-    public static boolean anyBailedOut(Scenario... scenarios) {
-        return Arrays.stream(scenarios).anyMatch(s -> s.getTestVMOutput().contains(IRMatcher.SAFEPOINT_WHILE_PRINTING_MESSAGE));
-    }
-
-    /**
-     * Is there at least one scenario which did not hit a safepoint while printing (i.e. a bailout)?
-     */
-    public static boolean notAllBailedOut(Scenario... scenarios) {
-        return Arrays.stream(scenarios).anyMatch(s -> !s.getTestVMOutput().contains(IRMatcher.SAFEPOINT_WHILE_PRINTING_MESSAGE));
+    public static void throwIfNoSafepointPrinting(String output, RuntimeException e) {
+        if (!output.contains(IRMatcher.SAFEPOINT_WHILE_PRINTING_MESSAGE)) {
+            throw e;
+        }
     }
 }