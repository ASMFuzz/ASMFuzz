@@ -76,6 +76,27 @@ public void  createUI() {
         super.createUI(panel, "AccessibleJTableTest");
     }
 
+    public void  createUIDraggable() {
+        INSTRUCTIONS = "INSTRUCTIONS:\n"
+                + "Check that table is properly updated when culumn order is changed.\n\n"
+                + "Turn screen reader on, and Tab to the table.\n"
+                + "Using arrow keys navigate to the last cell in the first row in the table."
+                + "Screen reader should announce it as \"Column 3 row 1\"\n\n"
+                + "Using mouse drag the header of the last culumn so the last column becomes the first one."
+                + "Wait for the screen reader to finish announcing new position in table.\n\n"
+                + "If new position in table corresponds to the new table layout ctrl+tab further "
+                + "and press PASS, otherwise press FAIL.\n";
+
+        JTable table = new JTable(data, columnNames);
+        JPanel panel = new JPanel();
+        panel.setLayout(new FlowLayout());
+        JScrollPane scrollPane = new JScrollPane(table);
+        panel.add(scrollPane);
+        panel.setFocusable(false);
+        exceptionString = "AccessibleJTable test failed!";
+        super.createUI(panel, "AccessibleJTableTest");
+    }
+
     public void  createUINamed() {
         INSTRUCTIONS = "INSTRUCTIONS:\n"
                 + "Check a11y of named JTable.\n\n"
@@ -166,6 +187,13 @@ public static void main(String[] args) throws Exception {
             throw new RuntimeException(exceptionString);
         }
 
+        countDownLatch = test.createCountDownLatch();
+        SwingUtilities.invokeAndWait(test::createUIDraggable);
+        countDownLatch.await(15, TimeUnit.MINUTES);
+        if (!testResult) {
+            throw new RuntimeException(exceptionString);
+        }
+
         countDownLatch = test.createCountDownLatch();
         SwingUtilities.invokeAndWait(test::createUINamed);
         countDownLatch.await(15, TimeUnit.MINUTES);