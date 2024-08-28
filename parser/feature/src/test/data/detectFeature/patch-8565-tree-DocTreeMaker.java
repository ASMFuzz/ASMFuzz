@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2011, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2011, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -480,8 +480,13 @@ public DCUses newUsesTree(ReferenceTree name, List<? extends DocTree> descriptio
 
     @Override @DefinedBy(Api.COMPILER_TREE)
     public DCValue newValueTree(ReferenceTree ref) {
+        return newValueTree(null, ref);
+    }
+
+    @Override @DefinedBy(Api.COMPILER_TREE)
+    public DCValue newValueTree(TextTree format, ReferenceTree ref) {
         // TODO: verify the reference is to a constant value
-        DCValue tree = new DCValue((DCReference) ref);
+        DCValue tree = new DCValue((DCText) format, (DCReference) ref);
         tree.pos = pos;
         return tree;
     }