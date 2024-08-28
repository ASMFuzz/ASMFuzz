@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -27,8 +27,8 @@
 
 import java.awt.Transparency;
 import java.awt.geom.Path2D;
-import sun.java2d.InvalidPipeException;
 import sun.java2d.SunGraphics2D;
+import sun.java2d.SurfaceData;
 import sun.java2d.loops.GraphicsPrimitive;
 import sun.java2d.pipe.BufferedRenderPipe;
 import sun.java2d.pipe.ParallelogramPipe;
@@ -47,12 +47,8 @@ protected void validateContext(SunGraphics2D sg2d) {
         int ctxflags =
             sg2d.paint.getTransparency() == Transparency.OPAQUE ?
                 OGLContext.SRC_IS_OPAQUE : OGLContext.NO_CONTEXT_FLAGS;
-        OGLSurfaceData dstData;
-        try {
-            dstData = (OGLSurfaceData)sg2d.surfaceData;
-        } catch (ClassCastException e) {
-            throw new InvalidPipeException("wrong surface data type: " + sg2d.surfaceData);
-        }
+        OGLSurfaceData dstData = SurfaceData.convertTo(OGLSurfaceData.class,
+                                                       sg2d.surfaceData);
         OGLContext.validateContext(dstData, dstData,
                                    sg2d.getCompClip(), sg2d.composite,
                                    null, sg2d.paint, sg2d, ctxflags);
@@ -61,12 +57,8 @@ protected void validateContext(SunGraphics2D sg2d) {
     @Override
     protected void validateContextAA(SunGraphics2D sg2d) {
         int ctxflags = OGLContext.NO_CONTEXT_FLAGS;
-        OGLSurfaceData dstData;
-        try {
-            dstData = (OGLSurfaceData)sg2d.surfaceData;
-        } catch (ClassCastException e) {
-            throw new InvalidPipeException("wrong surface data type: " + sg2d.surfaceData);
-        }
+        OGLSurfaceData dstData = SurfaceData.convertTo(OGLSurfaceData.class,
+                                                       sg2d.surfaceData);
         OGLContext.validateContext(dstData, dstData,
                                    sg2d.getCompClip(), sg2d.composite,
                                    null, sg2d.paint, sg2d, ctxflags);
@@ -80,12 +72,8 @@ void copyArea(SunGraphics2D sg2d,
             int ctxflags =
                 sg2d.surfaceData.getTransparency() == Transparency.OPAQUE ?
                     OGLContext.SRC_IS_OPAQUE : OGLContext.NO_CONTEXT_FLAGS;
-            OGLSurfaceData dstData;
-            try {
-                dstData = (OGLSurfaceData)sg2d.surfaceData;
-            } catch (ClassCastException e) {
-                throw new InvalidPipeException("wrong surface data type: " + sg2d.surfaceData);
-            }
+            OGLSurfaceData dstData = SurfaceData.convertTo(OGLSurfaceData.class,
+                                                           sg2d.surfaceData);
             OGLContext.validateContext(dstData, dstData,
                                        sg2d.getCompClip(), sg2d.composite,
                                        null, null, null, ctxflags);