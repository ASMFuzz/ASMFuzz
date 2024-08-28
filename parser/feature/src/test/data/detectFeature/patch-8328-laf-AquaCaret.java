@@ -209,7 +209,7 @@ protected synchronized void damage(final Rectangle r) {
     // See <rdar://problem/3833837> 1.4.2_05-141.3: JTextField performance with
     // Aqua L&F. We are getting into a circular condition with the BasicCaret
     // paint code since it doesn't know about the fact that our damage routine
-    // above elminates the border. Sadly we can't easily change either one, so
+    // above eliminates the border. Sadly we can't easily change either one, so
     // we will add a painting flag and not damage during a repaint.
     @Override
     public void paint(final Graphics g) {