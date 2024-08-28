@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2010, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -99,7 +99,7 @@ public void MaskFill(SunGraphics2D sg2d, SurfaceData sData, Composite comp,
         try {
             SunToolkit.awtLock();
 
-            XRSurfaceData x11sd = (XRSurfaceData) sData;
+            XRSurfaceData x11sd = SurfaceData.convertTo(XRSurfaceData.class, sData);
             x11sd.validateAsDestination(null, sg2d.getCompClip());
 
             XRCompositeManager maskBuffer = x11sd.maskBuffer;