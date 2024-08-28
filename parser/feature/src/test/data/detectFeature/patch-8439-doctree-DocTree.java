@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2011, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2011, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -218,6 +218,14 @@ enum Kind {
          */
         SNIPPET("snippet"),
 
+        /**
+         * Used for instances of {@link SpecTree}
+         * representing an {@code @spec} tag.
+         *
+         * @since 20
+         */
+        SPEC("spec"),
+
         /**
          * Used for instances of {@link EndElementTree}
          * representing the start of an HTML element.