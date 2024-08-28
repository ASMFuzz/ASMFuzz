@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2017, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2017, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,10 +25,23 @@
 
 package com.sun.source.tree;
 
+import jdk.internal.javac.PreviewFeature;
+
 /**
  * A tree node used as the base class for the different kinds of
  * patterns.
  *
  * @since 16
  */
-public interface PatternTree extends Tree, CaseLabelTree {}
+public interface PatternTree extends Tree, CaseLabelTree {
+
+    /**
+     * The guard for the case.
+     *
+     * @return the guard
+     * @since 19
+     */
+    @PreviewFeature(feature=PreviewFeature.Feature.SWITCH_PATTERN_MATCHING, reflective=true)
+    ExpressionTree getGuard();
+
+}