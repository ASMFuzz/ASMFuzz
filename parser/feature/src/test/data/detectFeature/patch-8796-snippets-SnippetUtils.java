@@ -24,6 +24,7 @@
 package snippets;
 
 import java.io.File;
+import java.io.FileNotFoundException;
 import java.io.IOException;
 import java.io.PrintWriter;
 import java.net.URI;
@@ -86,6 +87,16 @@
  * code to compile and run snippets, where that is appropriate.
  */
 public class SnippetUtils {
+    /**
+     * Exception used to report a configuration issue that prevents
+     * the test from executing as expected.
+     */
+    public static class ConfigurationException extends Exception {
+        public ConfigurationException(String message) {
+            super(message);
+        }
+    }
+
     private static final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
 
     private final StandardJavaFileManager fileManager;
@@ -105,8 +116,10 @@ public class SnippetUtils {
      * @param modules the modules
      *
      * @throws IllegalArgumentException if no modules are specified
+     * @throws ConfigurationException if the main source directory cannot be found
+     *                                or if a module's source directory cannot be found
      */
-    public SnippetUtils(String... modules) {
+    public SnippetUtils(String... modules) throws ConfigurationException {
         this(findSourceDir(), null, null, Set.of(modules));
     }
 
@@ -126,13 +139,29 @@ public SnippetUtils(String... modules) {
      * @param modules the modules
      *
      * @throws IllegalArgumentException if no modules are specified
+     * @throws ConfigurationException if {@code srcDir} does not exist
+     *                                or if a module's source directory cannot be found
      */
-    public SnippetUtils(Path srcDir, PrintWriter pw, DiagnosticListener<JavaFileObject> dl, Set<String> modules) {
+    public SnippetUtils(Path srcDir, PrintWriter pw, DiagnosticListener<JavaFileObject> dl, Set<String> modules)
+            throws ConfigurationException {
         if (modules.isEmpty()) {
             throw new IllegalArgumentException("no modules specified");
         }
 
+        if (!Files.exists(srcDir)) {
+            throw new ConfigurationException("directory not found: " + srcDir);
+        }
+
         this.srcDir = srcDir;
+
+        for (var m : modules) {
+            var moduleSourceDir = getModuleSourceDir(m);
+            if (!Files.exists(moduleSourceDir)) {
+                throw new ConfigurationException(("cannot find source directory for " + m
+                        + ": " + moduleSourceDir));
+            }
+        }
+
         fileManager = compiler.getStandardFileManager(dl, null, null);
 
         List<String> opts = new ArrayList<>();
@@ -528,7 +557,7 @@ public SourceKind inferSourceKind(String s) {
         return SourceKind.OTHER;
     }
 
-    private static Path findSourceDir() {
+    private static Path findSourceDir() throws ConfigurationException {
         String testSrc = System.getProperty("test.src");
         Path p = Path.of(testSrc).toAbsolutePath();
         while (p.getParent() != null) {
@@ -538,6 +567,6 @@ private static Path findSourceDir() {
             }
             p = p.getParent();
         }
-        throw new IllegalArgumentException("Cannot find src/ from " + testSrc);
+        throw new ConfigurationException("Cannot find src/ from " + testSrc);
     }
 }
\ No newline at end of file