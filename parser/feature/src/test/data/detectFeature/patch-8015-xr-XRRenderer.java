@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2010, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2010, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -28,8 +28,8 @@
 import java.awt.*;
 import java.awt.geom.*;
 import sun.awt.SunToolkit;
-import sun.java2d.InvalidPipeException;
 import sun.java2d.SunGraphics2D;
+import sun.java2d.SurfaceData;
 import sun.java2d.loops.*;
 import sun.java2d.pipe.Region;
 import sun.java2d.pipe.PixelDrawPipe;
@@ -70,12 +70,8 @@ public XRRenderer(MaskTileManager tileManager) {
      * destination context.
      */
     private void validateSurface(SunGraphics2D sg2d) {
-        XRSurfaceData xrsd;
-        try {
-            xrsd = (XRSurfaceData) sg2d.surfaceData;
-        } catch (ClassCastException e) {
-            throw new InvalidPipeException("wrong surface data type: " + sg2d.surfaceData);
-        }
+        XRSurfaceData xrsd = SurfaceData.convertTo(XRSurfaceData.class,
+                                                   sg2d.surfaceData);
         xrsd.validateAsDestination(sg2d, sg2d.getCompClip());
         xrsd.maskBuffer.validateCompositeState(sg2d.composite, sg2d.transform,
                                                sg2d.paint, sg2d);