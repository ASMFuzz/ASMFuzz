@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -805,9 +805,10 @@ public static Env<AttrContext> scopeFor(List<JCTree> path) {
     public static List<JCTree> pathFor(final JCTree node, final JCCompilationUnit unit) {
         class Result extends Error {
             static final long serialVersionUID = -5942088234594905625L;
-            @SuppressWarnings("serial") // List not statically Serilizable
+            @SuppressWarnings("serial") // List not statically Serializable
             List<JCTree> path;
             Result(List<JCTree> path) {
+                super(null, null, true, false);
                 this.path = path;
             }
         }