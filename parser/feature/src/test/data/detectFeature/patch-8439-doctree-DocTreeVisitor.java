@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2011, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2011, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -302,6 +302,22 @@ default R visitSnippet(SnippetTree node, P p) {
         return visitOther(node, p);
     }
 
+    /**
+     * Visits a {@code SpecTree} node.
+     *
+     * @implSpec Visits the provided {@code SpecTree} node
+     * by calling {@code visitOther(node, p)}.
+     *
+     * @param node the node being visited
+     * @param p a parameter value
+     * @return a result value
+     *
+     * @since 20
+     */
+    default R visitSpec(SpecTree node, P p) {
+        return visitOther(node, p);
+    }
+
     /**
      * Visits a {@code StartElementTree} node.
      * @param node the node being visited