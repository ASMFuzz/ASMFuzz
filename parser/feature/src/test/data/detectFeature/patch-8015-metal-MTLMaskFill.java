@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2019, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2019, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -24,8 +24,8 @@
  */
 package sun.java2d.metal;
 
-import sun.java2d.InvalidPipeException;
 import sun.java2d.SunGraphics2D;
+import sun.java2d.SurfaceData;
 import sun.java2d.loops.CompositeType;
 import sun.java2d.loops.GraphicsPrimitive;
 import sun.java2d.loops.GraphicsPrimitiveMgr;
@@ -70,13 +70,8 @@ protected native void maskFill(int x, int y, int w, int h,
     protected void validateContext(SunGraphics2D sg2d,
                                    Composite comp, int ctxflags)
     {
-        MTLSurfaceData dstData;
-        try {
-            dstData = (MTLSurfaceData) sg2d.surfaceData;
-        } catch (ClassCastException e) {
-            throw new InvalidPipeException("wrong surface data type: " +
-                    sg2d.surfaceData);
-        }
+        MTLSurfaceData dstData = SurfaceData.convertTo(MTLSurfaceData.class,
+                                                       sg2d.surfaceData);
 
         MTLContext.validateContext(dstData, dstData,
                 sg2d.getCompClip(), comp,