@@ -24,13 +24,25 @@
  */
 package javax.swing.plaf.synth;
 
-import sun.swing.SwingUtilities2;
 import sun.swing.MenuItemLayoutHelper;
-
-import java.awt.*;
-import javax.swing.*;
+import sun.swing.SwingUtilities2;
+import java.awt.Color;
+import java.awt.Component;
+import java.awt.Dimension;
+import java.awt.Font;
+import java.awt.FontMetrics;
+import java.awt.Graphics;
+import java.awt.Insets;
+import java.awt.Rectangle;
+
+import javax.swing.ButtonModel;
+import javax.swing.Icon;
+import javax.swing.JButton;
+import javax.swing.JComponent;
+import javax.swing.JMenuItem;
+import javax.swing.SwingUtilities;
 import javax.swing.plaf.basic.BasicHTML;
-import javax.swing.text.*;
+import javax.swing.text.View;
 
 /**
  * Wrapper for primitive graphics calls.
@@ -380,10 +392,19 @@ public void paintText(SynthContext ss, Graphics g, String text,
         FontMetrics fm = SwingUtilities2.getFontMetrics(c, g);
         Insets insets = SynthLookAndFeel.getPaintingInsets(ss, paintInsets);
 
-        paintViewR.x = insets.left;
-        paintViewR.y = insets.top;
-        paintViewR.width = c.getWidth() - (insets.left + insets.right);
-        paintViewR.height = c.getHeight() - (insets.top + insets.bottom);
+        final View v = (View)c.getClientProperty(BasicHTML.propertyKey);
+
+        if (c instanceof JButton && v != null) {
+            paintViewR.x = 0;
+            paintViewR.y = 0;
+            paintViewR.width = c.getWidth();
+            paintViewR.height = c.getHeight();
+        } else {
+            paintViewR.x = insets.left;
+            paintViewR.y = insets.top;
+            paintViewR.width = c.getWidth() - (insets.left + insets.right);
+            paintViewR.height = c.getHeight() - (insets.top + insets.bottom);
+        }
 
         paintIconR.x = paintIconR.y = paintIconR.width = paintIconR.height = 0;
         paintTextR.x = paintTextR.y = paintTextR.width = paintTextR.height = 0;
@@ -409,8 +430,6 @@ public void paintText(SynthContext ss, Graphics g, String text,
         }
 
         if (text != null) {
-            View v = (View) c.getClientProperty(BasicHTML.propertyKey);
-
             if (v != null) {
                 v.paint(g, paintTextR);
             } else {