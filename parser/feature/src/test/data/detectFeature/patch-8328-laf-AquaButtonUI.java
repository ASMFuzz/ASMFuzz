@@ -457,7 +457,7 @@ protected void paintIcon(final Graphics g, final AbstractButton b, final Rectang
     }
 
     /**
-     * As of Java 2 platform v 1.4 this method should not be used or overriden.
+     * As of Java 2 platform v 1.4 this method should not be used or overridden.
      * Use the paintText method which takes the AbstractButton argument.
      */
     protected void paintText(final Graphics g, final JComponent c, final Rectangle localTextRect, final String text) {
@@ -549,8 +549,8 @@ protected void uninstallHierListener(final AbstractButton b) {
     }
 
     static class AquaHierarchyButtonListener implements HierarchyListener {
-        // Everytime a hierarchy is change we need to check if the button if moved on or from
-        // a toolbar. If that is the case, we need to re-set the border of the button.
+        // Every time a hierarchy is changed we need to check if the button is moved on or from
+        // the toolbar. If that is the case, we need to re-set the border of the button.
         public void hierarchyChanged(final HierarchyEvent e) {
             if ((e.getChangeFlags() & HierarchyEvent.PARENT_CHANGED) == 0) return;
 