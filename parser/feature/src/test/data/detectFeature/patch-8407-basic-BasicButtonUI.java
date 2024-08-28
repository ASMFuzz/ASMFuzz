@@ -25,22 +25,40 @@
 
 package javax.swing.plaf.basic;
 
-import sun.swing.SwingUtilities2;
 import sun.awt.AppContext;
-
-import java.awt.*;
-import java.awt.event.*;
-import java.io.Serializable;
-import javax.swing.*;
-import javax.swing.border.*;
-import java.awt.*;
-import java.awt.event.*;
+import sun.swing.SwingUtilities2;
+import java.awt.AWTKeyStroke;
+import java.awt.Component;
+import java.awt.Dimension;
+import java.awt.FontMetrics;
+import java.awt.Graphics;
+import java.awt.Insets;
+import java.awt.KeyboardFocusManager;
+import java.awt.Rectangle;
+import java.awt.event.ActionEvent;
+import java.awt.event.KeyEvent;
+import java.awt.event.KeyListener;
+import java.awt.event.MouseMotionListener;
 import java.util.Enumeration;
 import java.util.HashSet;
 import java.util.Set;
+
+import javax.swing.AbstractAction;
+import javax.swing.AbstractButton;
+import javax.swing.ButtonGroup;
+import javax.swing.ButtonModel;
+import javax.swing.DefaultButtonModel;
+import javax.swing.Icon;
+import javax.swing.JComponent;
+import javax.swing.JRadioButton;
+import javax.swing.JToggleButton;
+import javax.swing.KeyStroke;
+import javax.swing.LookAndFeel;
+import javax.swing.SwingUtilities;
+import javax.swing.UIManager;
 import javax.swing.plaf.ButtonUI;
-import javax.swing.plaf.UIResource;
 import javax.swing.plaf.ComponentUI;
+import javax.swing.plaf.UIResource;
 import javax.swing.text.View;
 
 /**
@@ -580,7 +598,15 @@ public Component.BaselineResizeBehavior getBaselineResizeBehavior(
 
     private String layout(AbstractButton b, FontMetrics fm,
                           int width, int height) {
-        Insets i = b.getInsets();
+        Insets i;
+
+        final View v = (View)b.getClientProperty(BasicHTML.propertyKey);
+        if (v != null) {
+            i = new Insets(0, 0, 0, 0);
+        } else {
+            i = b.getInsets();
+        }
+
         viewRect.x = i.left;
         viewRect.y = i.top;
         viewRect.width = width - (i.right + viewRect.x);