@@ -27,15 +27,24 @@
  * @bug       6385277
  * @summary   Tests that override redirect window gets activated on click.
  * @author    anton.tarasov@sun.com: area=awt.focus
- * @library   ../../regtesthelpers
- * @build     Util
  * @run       main SimpleWindowActivationTest
  */
-import java.awt.*;
-import java.awt.event.*;
-import java.util.concurrent.Callable;
-import javax.swing.SwingUtilities;
-import test.java.awt.regtesthelpers.Util;
+
+import java.awt.AWTEvent;
+import java.awt.Button;
+import java.awt.Component;
+import java.awt.Dimension;
+import java.awt.FlowLayout;
+import java.awt.Frame;
+import java.awt.Label;
+import java.awt.Point;
+import java.awt.Robot;
+import java.awt.Toolkit;
+import java.awt.Window;
+import java.awt.event.AWTEventListener;
+import java.awt.event.FocusEvent;
+import java.awt.event.InputEvent;
+import java.awt.event.WindowEvent;
 
 public class SimpleWindowActivationTest {
 
@@ -59,9 +68,11 @@ public void eventDispatched(AWTEvent e) {
 
         createAndShowWindow();
         robot.waitForIdle();
+        robot.delay(500);
 
         createAndShowFrame();
         robot.waitForIdle();
+        robot.delay(500);
 
         // click on Frame
         clickOn(getClickPoint(frame));
@@ -130,8 +141,8 @@ static void clickOn(Point point) {
         robot.mouseMove(point.x, point.y);
         robot.waitForIdle();
 
-        robot.mousePress(InputEvent.BUTTON1_MASK);
-        robot.mouseRelease(InputEvent.BUTTON1_MASK);
+        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
+        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
 
         robot.waitForIdle();
     }