@@ -54,7 +54,7 @@ protected RootPaneContainer createFloatingWindow(final JToolBar toolbar) {
         return window;
     }
 
-    /* ToolBarBorder and drag-off handle, based loosly on MetalBumps */
+    /* ToolBarBorder and drag-off handle, based loosely on MetalBumps */
     @SuppressWarnings("serial") // Superclass is not serializable across versions
     static class ToolBarBorder extends AbstractBorder implements UIResource, javax.swing.SwingConstants {
         protected void fillHandle(final Graphics g, final int x1, final int y1, final int x2, final int y2, final boolean horizontal) {