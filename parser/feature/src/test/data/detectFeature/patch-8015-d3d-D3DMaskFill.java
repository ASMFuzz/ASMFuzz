@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2007, 2008, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2007, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -26,8 +26,8 @@
 package sun.java2d.d3d;
 
 import java.awt.Composite;
-import sun.java2d.InvalidPipeException;
 import sun.java2d.SunGraphics2D;
+import sun.java2d.SurfaceData;
 import sun.java2d.loops.GraphicsPrimitive;
 import sun.java2d.loops.GraphicsPrimitiveMgr;
 import sun.java2d.loops.CompositeType;
@@ -68,13 +68,8 @@ protected native void maskFill(int x, int y, int w, int h,
     protected void validateContext(SunGraphics2D sg2d,
                                    Composite comp, int ctxflags)
     {
-        D3DSurfaceData dstData;
-        try {
-            dstData = (D3DSurfaceData) sg2d.surfaceData;
-        } catch (ClassCastException e) {
-            throw new InvalidPipeException("wrong surface data type: " +
-                                           sg2d.surfaceData);
-        }
+        D3DSurfaceData dstData = SurfaceData.convertTo(D3DSurfaceData.class,
+                                                       sg2d.surfaceData);
         D3DContext.validateContext(dstData, dstData,
                                    sg2d.getCompClip(), comp,
                                    null, sg2d.paint, sg2d, ctxflags);