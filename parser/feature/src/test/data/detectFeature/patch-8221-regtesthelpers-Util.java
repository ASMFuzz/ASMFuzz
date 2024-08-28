@@ -307,8 +307,13 @@ public static void waitTillShown(final Component comp) {
      *     {@code InputEvent.BUTTON3_MASK}
      */
     public static void drag(Robot robot, Point startPoint, Point endPoint, int button) {
-        if (!(button == InputEvent.BUTTON1_MASK || button == InputEvent.BUTTON2_MASK
-                || button == InputEvent.BUTTON3_MASK))
+        if (!(button == InputEvent.BUTTON1_MASK
+                || button == InputEvent.BUTTON2_MASK
+                || button == InputEvent.BUTTON3_MASK
+                || button == InputEvent.BUTTON1_DOWN_MASK
+                || button == InputEvent.BUTTON2_DOWN_MASK
+                || button == InputEvent.BUTTON3_DOWN_MASK
+        ))
         {
             throw new IllegalArgumentException("invalid mouse button");
         }