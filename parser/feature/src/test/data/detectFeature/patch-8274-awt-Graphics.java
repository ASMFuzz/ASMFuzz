@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1995, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1995, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -24,9 +24,6 @@
  */
 package java.awt;
 
-import java.io.*;
-import java.lang.*;
-import java.util.*;
 import java.awt.image.ImageObserver;
 import java.text.AttributedCharacterIterator;
 
@@ -714,9 +711,9 @@ public abstract void drawPolyline(int[] xPoints, int[] yPoints,
      * 1&nbsp;&le;&nbsp;<i>i</i>&nbsp;&le;&nbsp;{@code nPoints}.
      * The figure is automatically closed by drawing a line connecting
      * the final point to the first point, if those points are different.
-     * @param        xPoints   a an array of {@code x} coordinates.
-     * @param        yPoints   a an array of {@code y} coordinates.
-     * @param        nPoints   a the total number of points.
+     * @param        xPoints   an array of {@code x} coordinates.
+     * @param        yPoints   an array of {@code y} coordinates.
+     * @param        nPoints   the total number of points.
      * @see          java.awt.Graphics#fillPolygon
      * @see          java.awt.Graphics#drawPolyline
      */
@@ -749,9 +746,9 @@ public void drawPolygon(Polygon p) {
      * <p>
      * The area inside the polygon is defined using an
      * even-odd fill rule, also known as the alternating rule.
-     * @param        xPoints   a an array of {@code x} coordinates.
-     * @param        yPoints   a an array of {@code y} coordinates.
-     * @param        nPoints   a the total number of points.
+     * @param        xPoints   an array of {@code x} coordinates.
+     * @param        yPoints   an array of {@code y} coordinates.
+     * @param        nPoints   the total number of points.
      * @see          java.awt.Graphics#drawPolygon(int[], int[], int)
      */
     public abstract void fillPolygon(int[] xPoints, int[] yPoints,