@@ -282,6 +282,9 @@ public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
         // dictated by the previous two assertions
         assert sf > 0;
 
+        Rectangle bounds = table.getBounds();
+        bounds.x = bounds.y = 0;
+
         // This is in a loop for two reasons:
         // First, it allows us to catch up in case we're called starting
         // with a non-zero pageIndex. Second, we know that we can be called
@@ -303,9 +306,10 @@ public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
             // calculate the area of the table to be printed for this page
             findNextClip(scaledWidth, scaledHeight);
 
-            if (!((table.getBounds()).intersects(clip))) {
+            if (!(bounds.intersects(clip))) {
                 return NO_SUCH_PAGE;
             }
+
             last++;
         }
 
@@ -395,8 +399,6 @@ public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
         // draw a box around the table
         g2d.setColor(Color.BLACK);
 
-        Rectangle bounds = table.getBounds();
-        bounds.x = bounds.y = 0;
 
         // compute the visible portion of table and draw the rect around it
         Rectangle visibleBounds = clip.intersection(bounds);