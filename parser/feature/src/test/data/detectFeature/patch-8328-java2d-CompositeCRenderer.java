@@ -362,20 +362,20 @@ void composite(SunGraphics2D sg2d, OSXSurfaceData surfaceData, BufferedImage src
         int w = (int) compositingBounds.getWidth();
         int h = (int) compositingBounds.getHeight();
 
-        boolean succeded = false;
+        boolean succeeded = false;
 
         Composite composite = sg2d.getComposite();
         if (composite instanceof XORComposite) {
             // 1st native XOR try
             // we try to perform XOR using surface pixels directly
             try {
-                succeded = surfaceData.xorSurfacePixels(sg2d, srcPixels, x, y, w, h, ((XORComposite) composite).getXorColor().getRGB());
+                succeeded = surfaceData.xorSurfacePixels(sg2d, srcPixels, x, y, w, h, ((XORComposite) composite).getXorColor().getRGB());
             } catch (Exception e) {
-                succeded = false;
+                succeeded = false;
             }
         }
 
-        if (succeded == false) {
+        if (succeeded == false) {
             // create image with the original pixels of surface
             BufferedImage dstInPixels = getSurfacePixels(sg2d, surfaceData, x, y, w, h);
             BufferedImage dstOutPixels = null;
@@ -385,15 +385,15 @@ void composite(SunGraphics2D sg2d, OSXSurfaceData surfaceData, BufferedImage src
                 // we try to perform XOR on image's pixels (which were copied from surface first)
                 try {
                     OSXSurfaceData osxsd = (OSXSurfaceData) (BufImgSurfaceData.createData(dstInPixels));
-                    succeded = osxsd.xorSurfacePixels(sg2d, srcPixels, 0, 0, w, h, ((XORComposite) composite).getXorColor().getRGB());
+                    succeeded = osxsd.xorSurfacePixels(sg2d, srcPixels, 0, 0, w, h, ((XORComposite) composite).getXorColor().getRGB());
                     dstOutPixels = dstInPixels;
                 } catch (Exception e) {
-                    succeded = false;
+                    succeeded = false;
                 }
             }
 
             // either 2nd native XOR failed OR we have a case of custom compositing
-            if (succeded == false) {
+            if (succeeded == false) {
                 // create an image into which we'll composite result: we MUST use a different destination (compositing
                 // is NOT "in place" operation)
                 dstOutPixels = surfaceData.getCompositingDstOutImage(w, h);