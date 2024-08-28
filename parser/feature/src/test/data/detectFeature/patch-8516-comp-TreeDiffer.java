@@ -1,6 +1,6 @@
 /*
  * Copyright (c) 2018, Google LLC. All rights reserved.
- * Copyright (c) 2018, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -71,6 +71,7 @@
 import com.sun.tools.javac.tree.JCTree.JCPackageDecl;
 import com.sun.tools.javac.tree.JCTree.JCPrimitiveTypeTree;
 import com.sun.tools.javac.tree.JCTree.JCProvides;
+import com.sun.tools.javac.tree.JCTree.JCRecordPattern;
 import com.sun.tools.javac.tree.JCTree.JCRequires;
 import com.sun.tools.javac.tree.JCTree.JCReturn;
 import com.sun.tools.javac.tree.JCTree.JCSwitch;
@@ -264,6 +265,14 @@ public void visitBindingPattern(JCBindingPattern tree) {
         }
     }
 
+    @Override
+    public void visitRecordPattern(JCTree.JCRecordPattern tree) {
+        JCRecordPattern that = (JCRecordPattern) parameter;
+        result =
+                scan(tree.deconstructor, that.deconstructor)
+                        && scan(tree.nested, that.nested);
+    }
+
     @Override
     public void visitBlock(JCBlock tree) {
         JCBlock that = (JCBlock) parameter;