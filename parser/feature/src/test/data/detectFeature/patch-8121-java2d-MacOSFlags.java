@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2019, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2019, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -91,13 +91,12 @@ private static void initJavaFlags() {
                     PropertyState metalState = getBooleanProp("sun.java2d.metal", PropertyState.UNSPECIFIED);
 
                     // Handle invalid combinations to use the default rendering pipeline
-                    // Current default rendering pipeline is OpenGL
-                    // (The default can be changed to Metal in future just by toggling two states in this if condition block)
+                    // The default rendering pipeline is Metal
                     if ((oglState == PropertyState.UNSPECIFIED && metalState == PropertyState.UNSPECIFIED) ||
                         (oglState == PropertyState.DISABLED && metalState == PropertyState.DISABLED) ||
                         (oglState == PropertyState.ENABLED && metalState == PropertyState.ENABLED)) {
-                        oglState = PropertyState.ENABLED; // Enable default pipeline
-                        metalState = PropertyState.DISABLED; // Disable non-default pipeline
+                        metalState = PropertyState.ENABLED; // Enable default pipeline
+                        oglState = PropertyState.DISABLED; // Disable non-default pipeline
                     }
 
                     if (metalState == PropertyState.UNSPECIFIED) {