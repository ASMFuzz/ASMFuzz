@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2013, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -23,7 +23,6 @@
 
 import java.awt.FlowLayout;
 import java.awt.Robot;
-import java.lang.ref.Reference;
 import java.lang.ref.WeakReference;
 import java.util.ArrayList;
 import java.util.List;
@@ -88,7 +87,12 @@ public void run() {
         //After the next caret blink it automatically TextField references
         Thread.sleep(text.get().getCaret().getBlinkRate() * 2);
         Util.waitForIdle(null);
-        assertGC();
+
+        try {
+            assertGC();
+        } finally {
+            SwingUtilities.invokeAndWait(() -> frame.dispose());
+        }
     }
 
       public static void assertGC() throws Throwable {