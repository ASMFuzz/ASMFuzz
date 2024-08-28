@@ -57,7 +57,7 @@ public class OSXOffScreenSurfaceData extends OSXSurfaceData // implements Raster
     // these are extra image types we can handle
     private static final int TYPE_3BYTE_RGB = BufferedImage.TYPE_BYTE_INDEXED + 1;
 
-    // these are for callbacks when pixes have been touched
+    // these are for callbacks when pixels have been touched
     protected ByteBuffer fImageInfo;
     IntBuffer fImageInfoInt;
     private static final int kNeedToSyncFromJavaPixelsIndex = 0;
@@ -505,7 +505,7 @@ public boolean copyArea(SunGraphics2D sg2d, int x, int y, int w, int h, int dx,
         // src coordinates are in the coordinate space of the image)
         // sg2d.drawImage expects the destination rect to be in the coord space
         // of the graphics2d. <rdar://3746194> (vm)
-        // we need to substract the transX and transY to move it
+        // we need to subtract the transX and transY to move it
         // to the coordinate space of the graphics2d.
         int dstX = x + dx - sg2d.transX;
         int dstY = y + dy - sg2d.transY;