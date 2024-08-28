@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -186,6 +186,7 @@ public boolean isPreview(Feature feature) {
         return switch (feature) {
             case CASE_NULL -> true;
             case PATTERN_SWITCH -> true;
+            case UNCONDITIONAL_PATTERN_IN_INSTANCEOF -> true;
 
             //Note: this is a backdoor which allows to optionally treat all features as 'preview' (for testing).
             //When real preview features will be added, this method can be implemented to return 'true'