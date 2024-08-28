@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -302,16 +302,6 @@ public interface TreeVisitor<R,P> {
      */
     R visitNewArray(NewArrayTree node, P p);
 
-    /**
-     * Visits a {@code GuardPatternTree} node.
-     * @param node the node being visited
-     * @param p a parameter value
-     * @return a result value
-     * @since 17
-     */
-    @PreviewFeature(feature=PreviewFeature.Feature.SWITCH_PATTERN_MATCHING, reflective=true)
-    R visitGuardedPattern(GuardedPatternTree node, P p);
-
     /**
      * Visits a {@code ParenthesizedPatternTree} node.
      * @param node the node being visited