@@ -866,7 +866,7 @@ public void propertyChange(final PropertyChangeEvent e) {
         }
     }
 
-    // Syncronizes the ToolTip text for the components within the spinner
+    // Synchronizes the ToolTip text for the components within the spinner
     // to be the same value as the spinner ToolTip text.
     void updateToolTipTextForChildren(final JComponent spinnerComponent) {
         final String toolTipText = spinnerComponent.getToolTipText();