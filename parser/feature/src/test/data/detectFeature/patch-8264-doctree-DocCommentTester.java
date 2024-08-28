@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2012, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -727,7 +727,9 @@ public Void visitOther(DocTree node, Void p) {
              */
             void header(DocTree node) {
                 indent();
-                out.println(simpleClassName(node) + "[" + node.getKind() + ", pos:" + ((DCTree) node).pos);
+                var n = (DCTree) node;
+                out.println(simpleClassName(node) + "[" + node.getKind() + ", pos:" + n.pos +
+                        (n.getPreferredPosition() != n.pos ? ", prefPos:" + n.getPreferredPosition() : ""));
             }
 
             /*