@@ -22,6 +22,7 @@
  */
 
 /* @test
+   @key headful
    @bug 6738668 6962725
    @summary JFileChooser cannot be created under SecurityManager
    @author Pavel Porvatov
@@ -31,11 +32,20 @@
 import java.io.File;
 import javax.swing.JFileChooser;
 import javax.swing.UIManager;
+import javax.swing.UnsupportedLookAndFeelException;
 
 public class bug6738668 {
     public static void main(String[] args) throws Exception {
         for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
-            UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
+            try {
+                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
+            } catch (UnsupportedLookAndFeelException ignored) {
+                System.out.println("Unsupported L&F: " + lookAndFeelInfo.getClassName());
+                continue;
+            } catch (ClassNotFoundException | InstantiationException
+                 | IllegalAccessException e) {
+                throw new RuntimeException(e);
+            }
 
             String tmpdir = System.getProperty("java.io.tmpdir");
             System.out.println("tmp dir " + tmpdir);