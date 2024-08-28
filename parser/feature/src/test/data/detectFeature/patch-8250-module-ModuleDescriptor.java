@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2009, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2009, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -1503,7 +1503,7 @@ public static final class Builder {
          *
          * If {@code strict} is {@code true} then module, package, and class
          * names are checked to ensure they are legal names. In addition, the
-         * {@link #build buid} method will add "{@code requires java.base}" if
+         * {@link #build build} method will add "{@code requires java.base}" if
          * the dependency is not declared.
          */
         Builder(String name, boolean strict, Set<Modifier> modifiers) {