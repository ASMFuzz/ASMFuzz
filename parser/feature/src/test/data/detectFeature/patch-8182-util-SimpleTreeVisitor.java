@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -703,22 +703,6 @@ public R visitParenthesizedPattern(ParenthesizedPatternTree node, P p) {
         return defaultAction(node, p);
     }
 
-    /**
-     * {@inheritDoc}
-     *
-     * @implSpec This implementation calls {@code defaultAction}.
-     *
-     * @param node {@inheritDoc}
-     * @param p {@inheritDoc}
-     * @return  the result of {@code defaultAction}
-     * @since 17
-     */
-    @Override
-    @PreviewFeature(feature=PreviewFeature.Feature.SWITCH_PATTERN_MATCHING, reflective=true)
-    public R visitGuardedPattern(GuardedPatternTree node, P p) {
-        return defaultAction(node, p);
-    }
-
     /**
      * {@inheritDoc}
      *