@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2002, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2002, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -239,6 +239,7 @@ public enum Feature {
         CASE_NULL(JDK17, Fragments.FeatureCaseNull, DiagKind.NORMAL),
         PATTERN_SWITCH(JDK17, Fragments.FeaturePatternSwitch, DiagKind.PLURAL),
         REDUNDANT_STRICTFP(JDK17),
+        UNCONDITIONAL_PATTERN_IN_INSTANCEOF(JDK19, Fragments.FeatureUnconditionalPatternsInInstanceof, DiagKind.PLURAL),
         ;
 
         enum DiagKind {