@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -26,6 +26,7 @@
 package com.sun.tools.javac.tree;
 
 import java.io.IOException;
+import java.io.UncheckedIOException;
 import java.io.Writer;
 import java.util.List;
 
@@ -116,14 +117,6 @@ protected void printTagName(DocTree node) throws IOException {
      * Traversal methods
      *************************************************************************/
 
-    /** Exception to propagate IOException through visitXYZ methods */
-    private static class UncheckedIOException extends Error {
-        static final long serialVersionUID = -4032692679158424751L;
-        UncheckedIOException(IOException e) {
-            super(e.getMessage(), e);
-        }
-    }
-
     @Override @DefinedBy(Api.COMPILER_TREE)
     public Void visitAttribute(AttributeTree node, Void p) {
         try {