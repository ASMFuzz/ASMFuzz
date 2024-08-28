@@ -24,14 +24,15 @@
 package compiler.lib.ir_framework.driver.irmatching.parser;
 
 import java.io.BufferedReader;
+import java.util.regex.Pattern;
 
 /**
  * Class representing a block line inside a PrintIdeal or PrintOptoAssembly output block read from the hotspot_pid* file.
  */
 class BlockLine extends AbstractLine {
 
-    public BlockLine(BufferedReader reader) {
-        super(reader);
+    public BlockLine(BufferedReader reader, Pattern compileIdPatternForTestClass) {
+        super(reader, compileIdPatternForTestClass);
     }
 
     /**