@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -1091,4 +1091,15 @@ public double getDefaultScaleX() {
     public double getDefaultScaleY() {
         return 1;
     }
+
+    /**
+     * Converts surfaceData to the particular subclass or throws InvalidPipeException
+     */
+    public static <T> T convertTo(Class<T> surfaceDataClass, SurfaceData surfaceData) {
+        try {
+            return surfaceDataClass.cast(surfaceData);
+        } catch(ClassCastException e) {
+            throw new InvalidPipeException("wrong surface data type: " + surfaceData);
+        }
+    }
 }