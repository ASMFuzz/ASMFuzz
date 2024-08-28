@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2015, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2015, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -26,7 +26,6 @@
 package jdk.javadoc.internal.doclets.toolkit.util;
 
 import java.util.ArrayList;
-import java.util.Collections;
 import java.util.List;
 import java.util.stream.Collectors;
 
@@ -677,7 +676,7 @@ public List<? extends DocTree> visitUses(UsesTree node, Void p) {
 
             @Override
             protected List<? extends DocTree> defaultAction(DocTree node, Void p) {
-               return Collections.emptyList();
+               return List.of();
             }
         }.visit(dtree, null);
     }