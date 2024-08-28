@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2016, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -63,6 +63,30 @@ public interface ToolProvider {
      */
     String name();
 
+    /**
+     * {@return a short description of the tool, or an empty
+     * {@code Optional} if no description is available}
+     *
+     * @apiNote It is recommended that the description fits into a single
+     * line in order to allow creating concise overviews like the following:
+     * <pre>{@code
+     * jar
+     *   Create, manipulate, and extract an archive of classes and resources.
+     * javac
+     *   Read Java declarations and compile them into class files.
+     * jlink
+     *   Assemble a set of modules (...) into a custom runtime image.
+     * }
+     * </pre>
+     *
+     * @implSpec This implementation returns an empty {@code Optional}.
+     *
+     * @since 19
+     */
+    default Optional<String> description() {
+        return Optional.empty();
+    }
+
     /**
      * Runs an instance of the tool, returning zero for a successful run.
      * Any non-zero return value indicates a tool-specific error during the