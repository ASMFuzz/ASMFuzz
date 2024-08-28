@@ -55,6 +55,7 @@
 import javax.accessibility.AccessibleSelection;
 import javax.accessibility.AccessibleState;
 import javax.accessibility.AccessibleStateSet;
+import javax.accessibility.AccessibleValue;
 import javax.swing.event.ChangeEvent;
 import javax.swing.event.ChangeListener;
 import javax.swing.plaf.TabbedPaneUI;
@@ -2074,7 +2075,7 @@ public void selectAllAccessibleSelection() {
     }
 
     private class Page extends AccessibleContext
-        implements Serializable, Accessible, AccessibleComponent {
+        implements Serializable, Accessible, AccessibleComponent, AccessibleValue {
         String title;
         Color background;
         Color foreground;
@@ -2168,7 +2169,6 @@ public AccessibleContext getAccessibleContext() {
             return this;
         }
 
-
         // AccessibleContext methods
 
         public String getAccessibleName() {
@@ -2202,6 +2202,43 @@ public AccessibleStateSet getAccessibleStateSet() {
             return states;
         }
 
+        @Override
+        public AccessibleValue getAccessibleValue() {
+            return this;
+        }
+
+        @Override
+        public Number getCurrentAccessibleValue() {
+            return (getPageIndex() == parent.getSelectedIndex() ?
+                    Integer.valueOf(1) : Integer.valueOf(0));
+        }
+
+        @Override
+        public boolean setCurrentAccessibleValue(Number n) {
+            if (getPageIndex() != parent.getSelectedIndex()) {
+                if (n.intValue() != 0) {
+                    // Set current page selected
+                    parent.setSelectedIndex(getPageIndex());
+                }
+            } else {
+                if (n.intValue() == 0) {
+                    // Can not "deselect" because what page should i select instead?
+                    return false;
+                }
+            }
+            return true;
+        }
+
+        @Override
+        public Number getMinimumAccessibleValue() {
+            return Integer.valueOf(0);
+        }
+
+        @Override
+        public Number getMaximumAccessibleValue() {
+            return Integer.valueOf(1);
+        }
+
         public int getAccessibleIndexInParent() {
             return getPageIndex();
         }
@@ -2360,7 +2397,7 @@ public void removeFocusListener(FocusListener l) {
          * one exists and the page is disabled.  Otherwise, null
          * is returned.
          */
-        public AccessibleIcon [] getAccessibleIcon() {
+        public AccessibleIcon[] getAccessibleIcon() {
             AccessibleIcon accessibleIcon = null;
             if (enabled && icon instanceof ImageIcon) {
                 AccessibleContext ac =