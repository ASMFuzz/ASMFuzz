@@ -111,7 +111,7 @@ public class AquaTabbedPaneCopyFromBasicUI extends TabbedPaneUI implements Swing
     @Deprecated
     protected KeyStroke rightKey;
 
-// Transient variables (recalculated each time TabbedPane is layed out)
+// Transient variables (recalculated each time TabbedPane is laid out)
 
     protected int[] tabRuns = new int[10];
     protected int runCount = 0;
@@ -2243,7 +2243,7 @@ public void layoutContainer(final Container parent) {
 
             // In order to allow programs to use a single component
             // as the display for multiple tabs, we will not change
-            // the visible compnent if the currently selected tab
+            // the visible component if the currently selected tab
             // has a null component.  This is a bit dicey, as we don't
             // explicitly state we support this in the spec, but since
             // programs are now depending on this, we're making it work.
@@ -2742,7 +2742,7 @@ public void layoutContainer(final Container parent) {
 
             // In order to allow programs to use a single component
             // as the display for multiple tabs, we will not change
-            // the visible compnent if the currently selected tab
+            // the visible component if the currently selected tab
             // has a null component.  This is a bit dicey, as we don't
             // explicitly state we support this in the spec, but since
             // programs are now depending on this, we're making it work.