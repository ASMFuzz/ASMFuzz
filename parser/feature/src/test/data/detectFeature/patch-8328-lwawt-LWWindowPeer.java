@@ -417,7 +417,7 @@ public Point getLocationOnScreen() {
     /**
      * Overridden from LWContainerPeer to return the correct insets.
      * Insets are queried from the delegate and are kept up to date by
-     * requiering when needed (i.e. when the window geometry is changed).
+     * requerying when needed (i.e. when the window geometry is changed).
      */
     @Override
     public Insets getInsets() {
@@ -1367,7 +1367,7 @@ private boolean isOneOfOwnersOf(LWWindowPeer peer) {
      */
     protected void changeFocusedWindow(boolean becomesFocused, Window opposite) {
         if (focusLog.isLoggable(PlatformLogger.Level.FINE)) {
-            focusLog.fine((becomesFocused?"gaining":"loosing") + " focus window: " + this);
+            focusLog.fine((becomesFocused?"gaining":"losing") + " focus window: " + this);
         }
         if (skipNextFocusChange) {
             focusLog.fine("skipping focus change");
@@ -1405,7 +1405,7 @@ protected void changeFocusedWindow(boolean becomesFocused, Window opposite) {
         KeyboardFocusManagerPeer kfmPeer = LWKeyboardFocusManagerPeer.getInstance();
 
         if (!becomesFocused && kfmPeer.getCurrentFocusedWindow() != getTarget()) {
-            // late window focus lost event - ingoring
+            // late window focus lost event - ignoring
             return;
         }
 