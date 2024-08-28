@@ -206,7 +206,7 @@ public void deiconifyFrame(final JInternalFrame f) {
             removeIconFor(f);
             // <rdar://problem/3712485> removed f.show(). show() is now deprecated and
             // it wasn't sending our frame to front nor selecting it. Now, we move it
-            // to front and select it manualy. (vm)
+            // to front and select it manually. (vm)
             f.moveToFront();
             try {
                 f.setSelected(true);