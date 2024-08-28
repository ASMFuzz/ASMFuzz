@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -228,14 +228,6 @@ public enum Kind {
          */
         BINDING_PATTERN(BindingPatternTree.class),
 
-        /**
-         * Used for instances of {@link GuardedPatternTree}.
-         *
-         * @since 17
-         */
-        @PreviewFeature(feature=PreviewFeature.Feature.SWITCH_PATTERN_MATCHING, reflective=true)
-        GUARDED_PATTERN(GuardedPatternTree.class),
-
         /**
          * Used for instances of {@link ParenthesizedPatternTree}.
          *