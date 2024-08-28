@@ -25,27 +25,36 @@
 
 import java.io.BufferedReader;
 import java.io.IOException;
+import java.util.ArrayList;
+import java.util.List;
+import java.util.regex.Pattern;
 
 /**
  * Class to read all lines of a PrintIdeal or PrintOptoAssembly block.
  */
 class BlockOutputReader {
-    private final BufferedReader reader;
+    private final BlockLine line;
 
-    public BlockOutputReader(BufferedReader reader) {
-        this.reader = reader;
+    public BlockOutputReader(BufferedReader reader, Pattern compileIdPatternForTestClass) {
+        this.line = new BlockLine(reader, compileIdPatternForTestClass);
     }
 
     /**
      * Read all lines belonging to a PrintIdeal or PrintOptoAssembly output block.
      */
-    public String readBlock() throws IOException {
-        BlockLine line = new BlockLine(reader);
+    public Block readBlock() throws IOException {
         StringBuilder builder = new StringBuilder();
+        List<String> testClassCompilations = new ArrayList<>();
         while (line.readLine() && !line.isBlockEnd()) {
+            if (line.isTestClassCompilation()) {
+                // Could have safepointed while writing the block (see IRMatcher.SAFEPOINT_WHILE_PRINTING_MESSAGE)
+                // and enqueuing the next test class method for compilation during the interruption. Record this
+                // method to ensure that we read the PrintIdeal/PrintOptoAssembly blocks for that method later.
+                testClassCompilations.add(line.getLine());
+            }
             builder.append(escapeXML(line.getLine())).append(System.lineSeparator());
         }
-        return builder.toString();
+        return new Block(builder.toString(), testClassCompilations);
     }
 
     /**