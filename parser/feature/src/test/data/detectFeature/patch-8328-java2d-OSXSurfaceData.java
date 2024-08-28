@@ -837,7 +837,7 @@ void setupGraphicsState(SunGraphics2D sg2d, int primitiveType, int x, int y, int
         setupGraphicsState(sg2d, primitiveType, sg2d.font, x, y, w, h);
     }
 
-    // the method below is overriden by CPeerSurface to check the last peer used to draw
+    // the method below is overridden by CPeerSurface to check the last peer used to draw
     // if the peer changed we finish lazy drawing
     void setupGraphicsState(SunGraphics2D sg2d, int primitiveType, Font font, int x, int y, int w, int h) {
         this.fChangeFlag = 0;