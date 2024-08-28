@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2011, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2011, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -638,7 +638,9 @@ public R visitUses(UsesTree node, P p) {
      */
     @Override
     public R visitValue(ValueTree node, P p) {
-        return scan(node.getReference(), p);
+        R r = scan(node.getFormat(), p);
+        r = scanAndReduce(node.getReference(), p, r);
+        return r;
     }
 
     /**