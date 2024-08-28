@@ -25,14 +25,99 @@
 
 package javax.swing.plaf;
 
+import java.awt.event.KeyEvent;
+import java.awt.FontMetrics;
+
+import javax.swing.AbstractButton;
+import javax.swing.JComponent;
+import javax.swing.JToolTip;
+import javax.swing.KeyStroke;
+import javax.swing.UIManager;
+
+import sun.swing.SwingUtilities2;
+
 /**
  * Pluggable look and feel interface for JToolTip.
  *
  * @author Dave Moore
  */
 public abstract class ToolTipUI extends ComponentUI {
+
+    /**
+     * Delimiter for Accelerator String.
+     */
+    private String acceleratorDelimiter;
+
+    /**
+     * The space between strings.
+     */
+    public static final int padSpaceBetweenStrings = 12;
+
     /**
      * Constructor for subclasses to call.
      */
     protected ToolTipUI() {}
+
+    /**
+     * If the accelerator is hidden, the method returns {@code true},
+     * otherwise, returns {@code false}.
+     *
+     * @return {@code true} if the accelerator is hidden.
+     */
+    protected boolean isAcceleratorHidden() {
+        Boolean b = (Boolean)UIManager.get("ToolTip.hideAccelerator");
+        return b != null && b.booleanValue();
+    }
+
+    /**
+     * Returns the accelerator string.
+     *
+     * @param tip ToolTip.
+     * @return the accelerator string.
+     */
+
+    public String getAcceleratorString(JToolTip tip) {
+
+        if (tip == null || isAcceleratorHidden()) {
+            return "";
+        }
+        JComponent comp = tip.getComponent();
+        if (!(comp instanceof AbstractButton)) {
+            return "";
+        }
+
+        KeyStroke[] keys = comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).keys();
+        if (keys == null) {
+            return "";
+        }
+
+        String controlKeyStr = "";
+
+        acceleratorDelimiter = UIManager.getString( "MenuItem.acceleratorDelimiter" );
+        if ( acceleratorDelimiter == null ) { acceleratorDelimiter = "-"; }
+
+        for (int i = 0; i < keys.length; i++) {
+            int mod = keys[i].getModifiers();
+            controlKeyStr = KeyEvent.getModifiersExText(mod) +
+                    acceleratorDelimiter +
+                    KeyEvent.getKeyText(keys[i].getKeyCode());
+            break;
+        }
+
+        return controlKeyStr;
+    }
+
+    /**
+     * Calculates the Accelerator Spacing Value.
+     * @param c JComponent
+     * @param fm FontMetrics
+     * @param accel String
+     * @return Accelerator Spacing.
+     */
+    protected int calcAcceleratorSpacing(JComponent c, FontMetrics fm, String accel) {
+        return accel.isEmpty()
+                ? 0
+                : padSpaceBetweenStrings +
+                SwingUtilities2.stringWidth(c, fm, accel);
+    }
 }