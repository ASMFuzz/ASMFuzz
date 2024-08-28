@@ -36,8 +36,10 @@
 import java.awt.Point;
 import java.awt.Rectangle;
 import java.awt.Robot;
+import java.io.File;
 import java.lang.reflect.InvocationTargetException;
 
+import javax.imageio.ImageIO;
 import javax.print.attribute.HashPrintRequestAttributeSet;
 import javax.print.attribute.PrintRequestAttributeSet;
 
@@ -75,10 +77,13 @@ public void run() {
             clearSelect();
             testRobot.waitForIdle();
             BufferedImage bufferedImageAfter = testRobot.createScreenCapture(getCaptureRect());
+
             testRobot.delay(1000);
 
             if (!compare(bufferedImageBefore, bufferedImageAfter)) {
-                throw new RuntimeException("Test Case Failed!!");
+                ImageIO.write(bufferedImageBefore, "png", new File("bufferedImageBefore.png"));
+                ImageIO.write(bufferedImageAfter, "png", new File("bufferedImageAfter.png"));
+                throw new RuntimeException("Test Case Failed!!, Last Row not Visible!!!");
             }
         } finally {
             if (frame != null) SwingUtilities.invokeAndWait(() -> frame.dispose());