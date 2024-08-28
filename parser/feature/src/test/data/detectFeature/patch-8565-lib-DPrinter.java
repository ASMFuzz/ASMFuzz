@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2013, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2013, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -1186,6 +1186,7 @@ public Void visitUses(UsesTree node, Void p) {
         }
 
         public Void visitValue(ValueTree node, Void p) {
+            printDocTree("format", node.getFormat());
             printDocTree("value", node.getReference());
             return visitInlineTag(node, null);
         }