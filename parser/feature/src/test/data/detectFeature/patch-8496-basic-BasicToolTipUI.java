@@ -27,6 +27,7 @@
 
 import sun.swing.SwingUtilities2;
 import java.awt.*;
+import java.awt.event.KeyEvent;
 import java.beans.PropertyChangeEvent;
 import java.beans.PropertyChangeListener;
 
@@ -47,6 +48,13 @@
 public class BasicToolTipUI extends ToolTipUI
 {
     static BasicToolTipUI sharedInstance = new BasicToolTipUI();
+    private JToolTip tip;
+
+    /**
+     * The space between strings.
+     */
+    public static final int padSpaceBetweenStrings = 12;
+
     /**
      * Global <code>PropertyChangeListener</code> that
      * <code>createPropertyChangeListener</code> returns.
@@ -76,13 +84,17 @@ public void installUI(JComponent c) {
         installDefaults(c);
         installComponents(c);
         installListeners(c);
+
+        tip = (JToolTip)c;
+
     }
 
     public void uninstallUI(JComponent c) {
         // REMIND: this is NOT getting called
         uninstallDefaults(c);
         uninstallComponents(c);
         uninstallListeners(c);
+        tip = null;
     }
 
     /**
@@ -152,8 +164,10 @@ private PropertyChangeListener createPropertyChangeListener(JComponent c) {
 
     public void paint(Graphics g, JComponent c) {
         Font font = c.getFont();
+        JToolTip tip = (JToolTip)c;
         FontMetrics metrics = SwingUtilities2.getFontMetrics(c, g, font);
         Dimension size = c.getSize();
+        int accelBL;
 
         g.setColor(c.getForeground());
         // fix for bug 4153892
@@ -162,19 +176,41 @@ public void paint(Graphics g, JComponent c) {
             tipText = "";
         }
 
-        Insets insets = c.getInsets();
+        String accelString = getAcceleratorString(tip);
+        FontMetrics accelMetrics = SwingUtilities2.getFontMetrics(c, g, font);
+        int accelSpacing = calcAcceleratorSpacing(c, accelMetrics, accelString);
+
+        Insets insets = ((JToolTip)c).getInsets();
         Rectangle paintTextR = new Rectangle(
-            insets.left + 3,
-            insets.top,
-            size.width - (insets.left + insets.right) - 6,
-            size.height - (insets.top + insets.bottom));
+                insets.left + 3,
+                insets.top,
+                size.width - (insets.left + insets.right) - 6 - accelSpacing,
+                size.height - (insets.top + insets.bottom));
+
+        if (paintTextR.width <= 0 || paintTextR.height <= 0) {
+            return;
+        }
+
         View v = (View) c.getClientProperty(BasicHTML.propertyKey);
         if (v != null) {
             v.paint(g, paintTextR);
+            accelBL = BasicHTML.getHTMLBaseline(v, paintTextR.width,
+                    paintTextR.height);
         } else {
             g.setFont(font);
             SwingUtilities2.drawString(c, g, tipText, paintTextR.x,
-                                  paintTextR.y + metrics.getAscent());
+                    paintTextR.y + metrics.getAscent());
+            accelBL = metrics.getAscent();
+        }
+
+        if (!accelString.isEmpty()) {
+            g.setFont(font);
+            SwingUtilities2.drawString(tip, g, accelString,
+                    tip.getWidth() - 1 - insets.right
+                            - accelSpacing
+                            + padSpaceBetweenStrings
+                            - 3,
+                    paintTextR.y + accelBL);
         }
     }
 
@@ -184,7 +220,7 @@ public Dimension getPreferredSize(JComponent c) {
         Insets insets = c.getInsets();
 
         Dimension prefSize = new Dimension(insets.left+insets.right,
-                                           insets.top+insets.bottom);
+                insets.top+insets.bottom);
         String text = ((JToolTip)c).getTipText();
 
         if (text == null) {
@@ -200,9 +236,40 @@ public Dimension getPreferredSize(JComponent c) {
                 prefSize.height += fm.getHeight();
             }
         }
+
+        String key = getAcceleratorString((JToolTip)c);
+        if (!key.isEmpty()) {
+            prefSize.width += calcAcceleratorSpacing(c, c.getFontMetrics(font), key);
+        }
+
         return prefSize;
     }
 
+    /**
+     * get Accelerator String
+     * @param tip JToolTip Object
+     * @return Accelerator String
+     */
+    public String getAcceleratorString(JToolTip tip) {
+        this.tip = tip;
+
+        String retValue = super.getAcceleratorString(tip);
+
+        this.tip = null;
+        return retValue;
+    }
+
+    /**
+     * get Accelerator String
+     * @return Accelerator String
+     */
+    public String getAcceleratorString() {
+
+        String retValue = super.getAcceleratorString(this.tip);
+
+        return retValue;
+    }
+
     public Dimension getMinimumSize(JComponent c) {
         Dimension d = getPreferredSize(c);
         View v = (View) c.getClientProperty(BasicHTML.propertyKey);
@@ -242,26 +309,26 @@ private void componentChanged(JComponent c) {
             }
             if (UIManager.getColor("ToolTip.backgroundInactive") != null) {
                 LookAndFeel.installColors(c,"ToolTip.backgroundInactive",
-                                          "ToolTip.foregroundInactive");
+                        "ToolTip.foregroundInactive");
             }
             else {
                 LookAndFeel.installColors(c,"ToolTip.background",
-                                          "ToolTip.foreground");
+                        "ToolTip.foreground");
             }
         } else {
             LookAndFeel.installBorder(c, "ToolTip.border");
             LookAndFeel.installColors(c, "ToolTip.background",
-                                      "ToolTip.foreground");
+                    "ToolTip.foreground");
         }
     }
 
 
     private static class PropertyChangeHandler implements
-                                 PropertyChangeListener {
+            PropertyChangeListener {
         public void propertyChange(PropertyChangeEvent e) {
             String name = e.getPropertyName();
             if (name.equals("tiptext") || "foreground".equals(name)
-                || "font".equals(name) || SwingUtilities2.isScaleChanged(e)) {
+                    || "font".equals(name) || SwingUtilities2.isScaleChanged(e)) {
                 // remove the old html view client property if one
                 // existed, and install a new one if the text installed
                 // into the JLabel is html source.