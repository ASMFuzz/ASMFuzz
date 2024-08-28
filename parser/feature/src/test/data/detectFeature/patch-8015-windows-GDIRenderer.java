@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -292,12 +292,8 @@ void doShape(SunGraphics2D sg2d, Shape s, boolean isfill) {
     // method that could be filled by the doShape method more quickly.
     public void doFillSpans(SunGraphics2D sg2d, SpanIterator si) {
         int[] box = new int[4];
-        GDIWindowSurfaceData sd;
-        try {
-            sd = (GDIWindowSurfaceData)sg2d.surfaceData;
-        } catch (ClassCastException e) {
-            throw new InvalidPipeException("wrong surface data type: " + sg2d.surfaceData);
-        }
+        GDIWindowSurfaceData sd = SurfaceData.convertTo(GDIWindowSurfaceData.class,
+                                                        sg2d.surfaceData);
         Region clip = sg2d.getCompClip();
         Composite comp = sg2d.composite;
         int eargb = sg2d.eargb;