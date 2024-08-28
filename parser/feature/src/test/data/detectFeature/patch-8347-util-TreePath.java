@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2006, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2006, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -66,6 +66,7 @@ class Result extends Error {
             @SuppressWarnings("serial") // Type of field is not Serializable
             TreePath path;
             Result(TreePath path) {
+                super(null, null, true, false);
                 this.path = path;
             }
         }