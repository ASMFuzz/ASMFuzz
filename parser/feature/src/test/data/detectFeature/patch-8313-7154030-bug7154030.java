@@ -74,6 +74,8 @@ public static void main(String[] args) throws Exception {
                 @Override
                 public void run() {
                     JDesktopPane desktop = new JDesktopPane();
+                    desktop.setBackground(Color.WHITE);
+                    desktop.setForeground(Color.BLACK);
                     button = new JButton("button");
                     frame = new JFrame();
                     frame.setUndecorated(true);