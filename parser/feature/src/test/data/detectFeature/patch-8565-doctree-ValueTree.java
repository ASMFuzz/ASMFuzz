@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2011, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2011, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -30,6 +30,7 @@
  *
  * <pre>
  *    {&#064;value reference}
+ *    {&#064;value format reference}
  * </pre>
  *
  * @since 1.8
@@ -40,4 +41,16 @@ public interface ValueTree extends InlineTagTree {
      * @return the reference
      */
     ReferenceTree getReference();
+
+    /**
+     * Returns the format string, or {@code null} if none was provided.
+     *
+     * @return the format string
+     *
+     * @implSpec This implementation returns {@code null}.
+     * @since 19
+     */
+    default TextTree getFormat() {
+        return null;
+    }
 }