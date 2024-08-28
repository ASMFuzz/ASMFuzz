@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2006, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2006, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -51,7 +51,6 @@ public static void main(String[] args)
         GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
         GraphicsDevice[] gds = ge.getScreenDevices();
         for (GraphicsDevice gd : gds) {
-
             GraphicsConfiguration gc = gd.getDefaultConfiguration();
             Rectangle gcBounds = gc.getBounds();
             Insets gcInsets = Toolkit.getDefaultToolkit().getScreenInsets(gc);
@@ -100,7 +99,13 @@ public static void main(String[] args)
                                          gcBounds.y + gcBounds.height - fBounds.y - fBounds.height,
                                          gcBounds.x + gcBounds.width - fBounds.x - fBounds.width);
 
-            if (!expected.equals(gcInsets))
+            // On Windows 10 and up system allows undecorated maximized windows
+            // to be placed over the taskbar so calculated insets might
+            // be smaller than reported ones depending on the taskbar position
+            if (gcInsets.top < expected.top
+                    || gcInsets.bottom < expected.bottom
+                    || gcInsets.left < expected.left
+                    || gcInsets.right < expected.right)
             {
                 passed = false;
                 System.err.println("Wrong insets for GraphicsConfig: " + gc);