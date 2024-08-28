@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -151,7 +151,7 @@ protected String getKeymapName() {
         String nm = getClass().getName();
         int index = nm.lastIndexOf('.');
         if (index >= 0) {
-            nm = nm.substring(index+1, nm.length());
+            nm = nm.substring(index+1);
         }
         return nm;
     }
@@ -249,7 +249,7 @@ private void updateBackground(JTextComponent c) {
 
             /* In an ideal situation, the following check would not be necessary
              * and we would replace the color any time the previous color was a
-             * UIResouce. However, it turns out that there is existing code that
+             * UIResource. However, it turns out that there is existing code that
              * uses the following inadvisable pattern to turn a text area into
              * what appears to be a multi-line label:
              *