@@ -33,7 +33,7 @@
 
 /**
  * This class exists only as a hack to work around a Sun bug which parks the
- * insertion caret at the begining of a text field when it gets clicked on.
+ * insertion caret at the beginning of a text field when it gets clicked on.
  */
 public class AquaTextFieldFormattedUI extends AquaTextFieldUI implements MouseListener {
     public static ComponentUI createUI(final JComponent c) {