@@ -25,16 +25,20 @@
 
 import java.io.BufferedReader;
 import java.io.IOException;
+import java.util.regex.Matcher;
+import java.util.regex.Pattern;
 
 /**
  * Base class of a read line from the hotspot_pid* file.
  */
 abstract class AbstractLine {
     private final BufferedReader reader;
     protected String line;
+    private final Pattern compileIdPatternForTestClass;
 
-    public AbstractLine(BufferedReader reader) {
+    public AbstractLine(BufferedReader reader, Pattern compileIdPatternForTestClass) {
         this.reader = reader;
+        this.compileIdPatternForTestClass = compileIdPatternForTestClass;
     }
 
     public String getLine() {
@@ -48,4 +52,37 @@ public boolean readLine() throws IOException {
         line = reader.readLine();
         return line != null;
     }
+
+    /**
+     * Is this line a start of a method in the test class? We only care about test class entries. There might be non-class
+     * entries as well if the user specified additional compile commands. Ignore these.
+     */
+    public boolean isTestClassCompilation() {
+        if (isCompilation()) {
+            Matcher matcher = compileIdPatternForTestClass.matcher(line);
+            return matcher.find();
+        }
+        return false;
+    }
+
+    /**
+     * Is this header a C2 non-OSR compilation header entry?
+     */
+    public boolean isCompilation() {
+        return line.startsWith("<task_queued") && notOSRCompilation() && notC2Compilation();
+    }
+
+    /**
+     * OSR compilations have compile_kind set.
+     */
+    protected boolean notOSRCompilation() {
+        return !line.contains("compile_kind='");
+    }
+
+    /**
+     * Non-C2 compilations have level set.
+     */
+    private boolean notC2Compilation() {
+        return !line.contains("level='");
+    }
 }