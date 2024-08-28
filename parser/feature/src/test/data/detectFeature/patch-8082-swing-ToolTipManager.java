@@ -54,7 +54,7 @@
  * @author Rich Schiavi
  * @since 1.2
  */
-public class ToolTipManager extends MouseAdapter implements MouseMotionListener  {
+public final class ToolTipManager extends MouseAdapter implements MouseMotionListener  {
     Timer enterTimer, exitTimer, insideTimer;
     String toolTipText;
     Point  preferredLocation;