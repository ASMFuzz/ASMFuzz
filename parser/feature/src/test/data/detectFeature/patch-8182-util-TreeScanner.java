@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -771,7 +771,9 @@ public R visitInstanceOf(InstanceOfTree node, P p) {
      */
     @Override
     public R visitBindingPattern(BindingPatternTree node, P p) {
-        return scan(node.getVariable(), p);
+        R r = scan(node.getVariable(), p);
+        r = scanAndReduce(node.getGuard(), p, r);
+        return r;
     }
 
     /**
@@ -833,24 +835,9 @@ public R visitMemberSelect(MemberSelectTree node, P p) {
     @Override
     @PreviewFeature(feature=PreviewFeature.Feature.SWITCH_PATTERN_MATCHING, reflective=true)
     public R visitParenthesizedPattern(ParenthesizedPatternTree node, P p) {
-        return scan(node.getPattern(), p);
-    }
-
-    /**
-     * {@inheritDoc}
-     *
-     * @implSpec This implementation scans the children in left to right order.
-     *
-     * @param node  {@inheritDoc}
-     * @param p  {@inheritDoc}
-     * @return the result of scanning
-     * @since 17
-     */
-    @Override
-    @PreviewFeature(feature=PreviewFeature.Feature.SWITCH_PATTERN_MATCHING, reflective=true)
-    public R visitGuardedPattern(GuardedPatternTree node, P p) {
         R r = scan(node.getPattern(), p);
-        return scanAndReduce(node.getExpression(), p, r);
+        r = scanAndReduce(node.getGuard(), p, r);
+        return r;
     }
 
     /**