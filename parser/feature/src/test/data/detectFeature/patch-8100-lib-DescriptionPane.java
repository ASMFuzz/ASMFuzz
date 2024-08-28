@@ -20,26 +20,26 @@
  * or visit www.oracle.com if you need additional information or have any
  * questions.
  */
+
 package lib;
 
-import javax.swing.JEditorPane;
-import javax.swing.JPanel;
-import javax.swing.JScrollPane;
 import java.awt.BorderLayout;
 import java.awt.Dimension;
 import java.io.IOException;
-import java.net.URL;
+import java.util.function.Consumer;
+import javax.swing.JEditorPane;
+import javax.swing.JPanel;
+import javax.swing.JScrollPane;
 
 /**
  * Displays instructions provided through a URL.
  */
 class DescriptionPane extends JPanel {
 
-    DescriptionPane(URL instructions) throws IOException {
+    DescriptionPane(Consumer<JEditorPane> instructions) {
         JEditorPane editorPane = new JEditorPane();
         editorPane.setFocusable(false);
-        editorPane.setContentType("text/html");
-        editorPane.setPage(instructions);
+        instructions.accept(editorPane);
         editorPane.setEditable(false);
 
         JScrollPane esp = new JScrollPane(editorPane);
@@ -51,3 +51,4 @@ class DescriptionPane extends JPanel {
         add(esp);
     }
 }
+