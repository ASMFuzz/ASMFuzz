@@ -104,7 +104,7 @@ public static void checkAction() {
     public static void main(String[] args) throws Throwable {
         try {
             Robot robot = new Robot();
-            robot.setAutoDelay(250);
+            robot.setAutoDelay(100);
 
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
 
@@ -116,12 +116,14 @@ public void run() {
                     frame.setContentPane(createPanel(frame));
                     frame.setJMenuBar(createMenuBar());
                     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
+                    frame.setLocationRelativeTo(null);
                     frame.pack();
                     frame.setVisible(true);
                 }
             });
 
             robot.waitForIdle();
+            robot.delay(1000);
 
             // Change the default button to
             // force a call to BasicRootPaneUI.updateDefaultButtonBindings()