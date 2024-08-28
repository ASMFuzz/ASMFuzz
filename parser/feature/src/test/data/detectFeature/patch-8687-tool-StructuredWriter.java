@@ -31,7 +31,7 @@ abstract class StructuredWriter {
     private final PrintWriter out;
     private final StringBuilder builder = new StringBuilder(4000);
 
-    private char[] indentionArray = new char[0];
+    private String indention = "";
     private int indent = 0;
     private int column;
     // print first event immediately so tool feels responsive
@@ -65,7 +65,7 @@ public final void flush(boolean hard) {
     }
 
     public final void printIndent() {
-        builder.append(indentionArray, 0, indent);
+        builder.append(indention, 0, indent);
         column += indent;
     }
 
@@ -114,11 +114,8 @@ public final void println(String text) {
     }
 
     private void updateIndent() {
-        if (indent > indentionArray.length) {
-            indentionArray = new char[indent];
-            for (int i = 0; i < indentionArray.length; i++) {
-                indentionArray[i] = ' ';
-            }
+        if (indent > indention.length()) {
+            indention = " ".repeat(2 * indent);
         }
     }
 }