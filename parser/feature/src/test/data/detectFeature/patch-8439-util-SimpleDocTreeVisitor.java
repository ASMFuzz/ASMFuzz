@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -463,6 +463,23 @@ public R visitSnippet(SnippetTree node, P p) {
         return defaultAction(node, p);
     }
 
+    /**
+     * {@inheritDoc}
+     *
+     * @implSpec This implementation calls {@code defaultAction}.
+     *
+     * @param node {@inheritDoc}
+     * @param p    {@inheritDoc}
+     *
+     * @return  the result of {@code defaultAction}
+     *
+     * @since 20
+     */
+    @Override
+    public R visitSpec(SpecTree node, P p) {
+        return defaultAction(node, p);
+    }
+
     /**
      * {@inheritDoc}
      *