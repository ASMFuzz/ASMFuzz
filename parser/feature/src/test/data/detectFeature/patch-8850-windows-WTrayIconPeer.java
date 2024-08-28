@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,17 +25,20 @@
 
 package sun.awt.windows;
 
-import java.awt.Graphics2D;
 import java.awt.AWTEvent;
 import java.awt.Frame;
+import java.awt.Graphics2D;
 import java.awt.GraphicsEnvironment;
-import java.awt.PopupMenu;
+import java.awt.Image;
 import java.awt.Point;
+import java.awt.PopupMenu;
 import java.awt.TrayIcon;
-import java.awt.Image;
 import java.awt.geom.AffineTransform;
+import java.awt.image.BufferedImage;
+import java.awt.image.DataBufferInt;
+import java.awt.image.ImageObserver;
+import java.awt.image.Raster;
 import java.awt.peer.TrayIconPeer;
-import java.awt.image.*;
 
 import sun.awt.AWTAccessor;
 import sun.awt.SunToolkit;
@@ -49,14 +52,11 @@ final class WTrayIconPeer extends WObjectPeer implements TrayIconPeer {
 
     IconObserver observer = new IconObserver();
     boolean firstUpdate = true;
-    Frame popupParent = new Frame("PopupMessageWindow");
+    final Frame popupParent = new Frame("PopupMessageWindow");
     PopupMenu popup;
 
     @Override
     protected void disposeImpl() {
-        if (popupParent != null) {
-            popupParent.dispose();
-        }
         popupParent.dispose();
         _dispose();
         WToolkit.targetDisposedPeer(target, this);