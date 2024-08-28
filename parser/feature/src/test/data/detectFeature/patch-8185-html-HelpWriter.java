@@ -50,9 +50,9 @@
 public class HelpWriter extends HtmlDocletWriter {
 
     private final String[][] SEARCH_EXAMPLES = {
-            {"j.l.obj", "\"java.lang.Object\""},
-            {"InpStr", "\"java.io.InputStream\""},
-            {"HM.cK", "\"java.util.HashMap.containsKey(Object)\""}
+            {"\"j.l.obj\"", "\"java.lang.Object\""},
+            {"\"InpStr\"", "\"java.io.InputStream\""},
+            {"\"math exact long\"", "\"java.lang.Math.absExact(long)\""}
     };
 
     Content overviewLink;