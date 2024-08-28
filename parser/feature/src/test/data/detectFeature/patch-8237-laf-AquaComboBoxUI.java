@@ -619,13 +619,6 @@ public Dimension getMinimumSize(final JComponent c) {
             size = super.getMinimumSize(c);
         }
 
-        final Border border = c.getBorder();
-        if (border != null) {
-            final Insets insets = border.getBorderInsets(c);
-            size.height += insets.top + insets.bottom;
-            size.width += insets.left + insets.right;
-        }
-
         cachedMinimumSize.setSize(size.width, size.height);
         isMinimumSizeDirty = false;
 