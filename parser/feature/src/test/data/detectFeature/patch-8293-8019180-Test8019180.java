@@ -37,10 +37,24 @@
 public class Test8019180 implements Runnable {
     private static final CountDownLatch LATCH = new CountDownLatch(1);
     private static final String[] ITEMS = {"First", "Second", "Third", "Fourth"};
+    private static JFrame frame;
+    private static boolean selectionFail = false;
 
-    public static void main(String[] args) throws InterruptedException {
-        SwingUtilities.invokeLater(new Test8019180());
-        LATCH.await();
+    public static void main(String[] args) throws Exception {
+        try {
+            SwingUtilities.invokeLater(new Test8019180());
+            LATCH.await();
+            System.out.println("selectionFail " + selectionFail);
+            if (selectionFail) {
+                throw new RuntimeException("Combobox not selected");
+            }
+        } finally {
+            SwingUtilities.invokeAndWait(() -> {
+                if (frame != null) {
+                    frame.dispose();
+                }
+            });
+        }
     }
 
     private JComboBox<String> test;
@@ -50,8 +64,9 @@ public void run() {
         if (this.test == null) {
             this.test = new JComboBox<>(ITEMS);
             this.test.addActionListener(this.test);
-            JFrame frame = new JFrame();
+            frame = new JFrame();
             frame.add(test);
+            frame.setLocationRelativeTo(null);
             frame.pack();
             frame.setVisible(true);
             SwingUtilities.invokeLater(this);
@@ -60,9 +75,8 @@ public void run() {
             this.test.setSelectedIndex(1 + index);
             if (0 > this.test.getSelectedIndex()) {
                 System.err.println("ERROR: no selection");
-                System.exit(8019180);
+                selectionFail = true;
             }
-            SwingUtilities.getWindowAncestor(this.test).dispose();
             LATCH.countDown();
         }
     }