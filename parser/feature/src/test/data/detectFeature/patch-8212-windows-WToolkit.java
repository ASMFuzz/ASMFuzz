@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1996, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -39,8 +39,6 @@
 import java.awt.Dimension;
 import java.awt.EventQueue;
 import java.awt.FileDialog;
-import java.awt.Font;
-import java.awt.FontMetrics;
 import java.awt.Frame;
 import java.awt.GraphicsConfiguration;
 import java.awt.GraphicsDevice;
@@ -137,9 +135,6 @@
 import sun.awt.datatransfer.DataTransferer;
 import sun.awt.util.PerformanceLogger;
 import sun.awt.util.ThreadGroupUtils;
-import sun.font.FontManager;
-import sun.font.FontManagerFactory;
-import sun.font.SunFontManager;
 import sun.java2d.d3d.D3DRenderQueue;
 import sun.java2d.opengl.OGLRenderQueue;
 import sun.print.PrintJob2D;
@@ -216,7 +211,7 @@ public Void run() {
      * will lead to undefined behavior.
      *
      * embeddedInit must be called before the WToolkit() constructor.
-     * embeddedDispose should be called before the applicaton terminates the
+     * embeddedDispose should be called before the application terminates the
      * Java VM. It is currently unsafe to reinitialize the toolkit again
      * after it has been disposed. Instead, awt.dll must be reloaded and the
      * class loader which loaded WToolkit must be finalized before it is
@@ -937,7 +932,7 @@ public DragSourceContextPeer createDragSourceContextPeer(DragGestureEvent dge) t
     @Override
     protected Object lazilyLoadDesktopProperty(String name) {
         if (name.startsWith(prefix)) {
-            String cursorName = name.substring(prefix.length(), name.length()) + postfix;
+            String cursorName = name.substring(prefix.length()) + postfix;
 
             try {
                 return Cursor.getSystemCustomCursor(cursorName);