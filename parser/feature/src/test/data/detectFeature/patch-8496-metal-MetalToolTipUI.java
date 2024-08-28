@@ -61,7 +61,6 @@ public class MetalToolTipUI extends BasicToolTipUI {
      * The space between strings.
      */
     public static final int padSpaceBetweenStrings = 12;
-    private String acceleratorDelimiter;
 
     /**
      * Constructs an instance of the {@code MetalToolTipUI}.
@@ -85,8 +84,6 @@ public void installUI(JComponent c) {
         tip = (JToolTip)c;
         Font f = c.getFont();
         smallFont = new Font( f.getName(), f.getStyle(), f.getSize() - 2 );
-        acceleratorDelimiter = UIManager.getString( "MenuItem.acceleratorDelimiter" );
-        if ( acceleratorDelimiter == null ) { acceleratorDelimiter = "-"; }
     }
 
     public void uninstallUI(JComponent c) {
@@ -110,7 +107,7 @@ public void paint(Graphics g, JComponent c) {
 
         String accelString = getAcceleratorString(tip);
         FontMetrics accelMetrics = SwingUtilities2.getFontMetrics(c, g, smallFont);
-        int accelSpacing = calcAccelSpacing(c, accelMetrics, accelString);
+        int accelSpacing = calcAcceleratorSpacing(c, accelMetrics, accelString);
 
         Insets insets = tip.getInsets();
         Rectangle paintTextR = new Rectangle(
@@ -147,80 +144,8 @@ public void paint(Graphics g, JComponent c) {
         }
     }
 
-    private int calcAccelSpacing(JComponent c, FontMetrics fm, String accel) {
-        return accel.isEmpty()
-               ? 0
-               : padSpaceBetweenStrings +
-                 SwingUtilities2.stringWidth(c, fm, accel);
-    }
-
     public Dimension getPreferredSize(JComponent c) {
         Dimension d = super.getPreferredSize(c);
-
-        String key = getAcceleratorString((JToolTip)c);
-        if (!key.isEmpty()) {
-            d.width += calcAccelSpacing(c, c.getFontMetrics(smallFont), key);
-        }
         return d;
     }
-
-    /**
-     * If the accelerator is hidden, the method returns {@code true},
-     * otherwise, returns {@code false}.
-     *
-     * @return {@code true} if the accelerator is hidden.
-     */
-    protected boolean isAcceleratorHidden() {
-        Boolean b = (Boolean)UIManager.get("ToolTip.hideAccelerator");
-        return b != null && b.booleanValue();
-    }
-
-    private String getAcceleratorString(JToolTip tip) {
-        this.tip = tip;
-
-        String retValue = getAcceleratorString();
-
-        this.tip = null;
-        return retValue;
-    }
-
-    /**
-     * Returns the accelerator string.
-     *
-     * @return the accelerator string.
-     */
-    // NOTE: This requires the tip field to be set before this is invoked.
-    // As MetalToolTipUI is shared between all JToolTips the tip field is
-    // set appropriately before this is invoked. Unfortunately this means
-    // that subclasses that randomly invoke this method will see varying
-    // results. If this becomes an issue, MetalToolTipUI should no longer be
-    // shared.
-    @SuppressWarnings("deprecation")
-    public String getAcceleratorString() {
-        if (tip == null || isAcceleratorHidden()) {
-            return "";
-        }
-        JComponent comp = tip.getComponent();
-        if (!(comp instanceof AbstractButton)) {
-            return "";
-        }
-
-        KeyStroke[] keys = comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).keys();
-        if (keys == null) {
-            return "";
-        }
-
-        String controlKeyStr = "";
-
-        for (int i = 0; i < keys.length; i++) {
-            int mod = keys[i].getModifiers();
-            controlKeyStr = KeyEvent.getKeyModifiersText(mod) +
-                            acceleratorDelimiter +
-                            KeyEvent.getKeyText(keys[i].getKeyCode());
-            break;
-        }
-
-        return controlKeyStr;
-    }
-
 }