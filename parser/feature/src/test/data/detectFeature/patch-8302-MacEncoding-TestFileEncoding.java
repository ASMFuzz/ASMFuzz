@@ -57,7 +57,7 @@ public class TestFileEncoding {
     private String expectedEncoding; // Expected value for file.encoding
     private String langVar = null; // Value to set for LANG, etc
 
-    private static Set<String> envToRm = new HashSet<>(3);
+    private static Set<String> envToRm = HashSet.newHashSet(3);
     static {
         // Take these vars out of the test's run environment, possibly adding
         // our own value back in.