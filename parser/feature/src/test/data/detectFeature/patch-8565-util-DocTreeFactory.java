@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2011, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2011, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -413,6 +413,19 @@ default SummaryTree newSummaryTree(List<? extends DocTree> summary) {
      */
     ValueTree newValueTree(ReferenceTree ref);
 
+    /**
+     * Creates a new {@code ValueTree} object, to represent a {@code {@value }} tag.
+     * @param format a format string for the value
+     * @param ref a reference to the value
+     * @return a {@code ValueTree} object
+     *
+     * @implSpec This implementation calls {@link #newValueTree(ReferenceTree) newValueTree(ref)}.
+     * @since 19
+     */
+    default ValueTree newValueTree(TextTree format, ReferenceTree ref) {
+        return newValueTree(ref);
+    }
+
     /**
      * Creates a new {@code VersionTree} object, to represent a {@code {@version }} tag.
      * @param text the content of the tag