@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2016, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -147,13 +147,14 @@ public VariableDesc(String type, String name) {
     }
 
     // return mechanism and other general structure from TreePath.getPath()
-    private static class Result extends Error {
+    private static final class Result extends Error {
 
         static final long serialVersionUID = -5942088234594905629L;
         @SuppressWarnings("serial") // Not statically typed as Serializable
         final TreePath expressionPath;
 
         Result(TreePath path) {
+            super(null, null, true, false);
             this.expressionPath = path;
         }
     }