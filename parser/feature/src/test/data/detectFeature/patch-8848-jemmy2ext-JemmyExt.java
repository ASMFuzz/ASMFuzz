@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2015, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2015, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -319,9 +319,16 @@ public String getDescription() {
         }
     }
 
+    public static BufferedImage capture() {
+        return capture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
+    }
+
     public static BufferedImage capture(ComponentOperator operator) {
-        Rectangle boundary = new Rectangle(operator.getLocationOnScreen(),
-                operator.getSize());
+        return capture(new Rectangle(operator.getLocationOnScreen(),
+                    operator.getSize()));
+    }
+
+    public static BufferedImage capture(Rectangle boundary) {
         return getRobot().createScreenCapture(boundary);
     }
 
@@ -403,7 +410,7 @@ public void registerRoot(Throwable t) {
         }
     }
 
-    private static String lafShortName() { return UIManager.getLookAndFeel().getClass().getSimpleName(); }
+    public static String lafShortName() { return UIManager.getLookAndFeel().getClass().getSimpleName(); }
 
     /**
      * Trying to capture as much information as possible. Currently it includes