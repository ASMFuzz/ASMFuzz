@@ -31,44 +31,8 @@
  * Class representing a normal line read from the hotspot_pid* file.
  */
 class Line extends AbstractLine {
-    private final Pattern compileIdPatternForTestClass;
-
     public Line(BufferedReader reader, Pattern compileIdPatternForTestClass) {
-        super(reader);
-        this.compileIdPatternForTestClass = compileIdPatternForTestClass;
-    }
-
-    /**
-     * Is this line a start of a @Test annotated method? We only care about test class entries. There might be non-class
-     * entries as well if user specified additional compile commands. Ignore these.
-     */
-    public boolean isTestClassCompilation() {
-        if (isCompilation()) {
-            Matcher matcher = compileIdPatternForTestClass.matcher(line);
-            return matcher.find();
-        }
-        return false;
-    }
-
-    /**
-     * Is this header a C2 non-OSR compilation header entry?
-     */
-    public boolean isCompilation() {
-        return line.startsWith("<task_queued") && notOSRCompilation() && notC2Compilation();
-    }
-
-    /**
-     * OSR compilations have compile_kind set.
-     */
-    private boolean notOSRCompilation() {
-        return !line.contains("compile_kind='");
-    }
-
-    /**
-     * Non-C2 compilations have level set.
-     */
-    private boolean notC2Compilation() {
-        return !line.contains("level='");
+        super(reader, compileIdPatternForTestClass);
     }
 
     /**