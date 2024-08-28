@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2010, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -27,6 +27,7 @@
 
 import sun.awt.*;
 import sun.java2d.SunGraphics2D;
+import sun.java2d.SurfaceData;
 import sun.java2d.pipe.GlyphListPipe;
 import sun.java2d.xr.*;
 
@@ -61,8 +62,7 @@ protected void drawGlyphList(SunGraphics2D sg2d, GlyphList gl) {
 
         try {
             SunToolkit.awtLock();
-
-            XRSurfaceData x11sd = (XRSurfaceData) sg2d.surfaceData;
+            XRSurfaceData x11sd = SurfaceData.convertTo(XRSurfaceData.class, sg2d.surfaceData);
             x11sd.validateAsDestination(null, sg2d.getCompClip());
             x11sd.maskBuffer.validateCompositeState(sg2d.composite, sg2d.transform, sg2d.paint, sg2d);
 