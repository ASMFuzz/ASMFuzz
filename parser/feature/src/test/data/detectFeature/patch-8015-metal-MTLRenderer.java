@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2019, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2019, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,8 +25,8 @@
 
 package sun.java2d.metal;
 
-import sun.java2d.InvalidPipeException;
 import sun.java2d.SunGraphics2D;
+import sun.java2d.SurfaceData;
 import sun.java2d.loops.GraphicsPrimitive;
 import sun.java2d.pipe.BufferedRenderPipe;
 import sun.java2d.pipe.ParallelogramPipe;
@@ -49,12 +49,8 @@ protected void validateContext(SunGraphics2D sg2d) {
         int ctxflags =
                 sg2d.paint.getTransparency() == Transparency.OPAQUE ?
                         MTLContext.SRC_IS_OPAQUE : MTLContext.NO_CONTEXT_FLAGS;
-        MTLSurfaceData dstData;
-        try {
-            dstData = (MTLSurfaceData)sg2d.surfaceData;
-        } catch (ClassCastException e) {
-            throw new InvalidPipeException("wrong surface data type: " + sg2d.surfaceData);
-        }
+        MTLSurfaceData dstData = SurfaceData.convertTo(MTLSurfaceData.class,
+                                                       sg2d.surfaceData);
         MTLContext.validateContext(dstData, dstData,
                 sg2d.getCompClip(), sg2d.composite,
                 null, sg2d.paint, sg2d, ctxflags);
@@ -63,12 +59,8 @@ protected void validateContext(SunGraphics2D sg2d) {
     @Override
     protected void validateContextAA(SunGraphics2D sg2d) {
         int ctxflags = MTLContext.NO_CONTEXT_FLAGS;
-        MTLSurfaceData dstData;
-        try {
-            dstData = (MTLSurfaceData)sg2d.surfaceData;
-        } catch (ClassCastException e) {
-            throw new InvalidPipeException("wrong surface data type: " + sg2d.surfaceData);
-        }
+        MTLSurfaceData dstData = SurfaceData.convertTo(MTLSurfaceData.class,
+                                                       sg2d.surfaceData);
         MTLContext.validateContext(dstData, dstData,
                 sg2d.getCompClip(), sg2d.composite,
                 null, sg2d.paint, sg2d, ctxflags);
@@ -82,12 +74,8 @@ void copyArea(SunGraphics2D sg2d,
             int ctxflags =
                     sg2d.surfaceData.getTransparency() == Transparency.OPAQUE ?
                             MTLContext.SRC_IS_OPAQUE : MTLContext.NO_CONTEXT_FLAGS;
-            MTLSurfaceData dstData;
-            try {
-                dstData = (MTLSurfaceData)sg2d.surfaceData;
-            } catch (ClassCastException e) {
-                throw new InvalidPipeException("wrong surface data type: " + sg2d.surfaceData);
-            }
+            MTLSurfaceData dstData = SurfaceData.convertTo(MTLSurfaceData.class,
+                                                           sg2d.surfaceData);
             MTLContext.validateContext(dstData, dstData,
                     sg2d.getCompClip(), sg2d.composite,
                     null, null, null, ctxflags);