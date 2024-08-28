@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -2511,7 +2511,7 @@ private LoggerBundle getEffectiveLoggerBundle() {
             return lb;
         } else if (b != null) {
             // either lb.userBundle is null or getResourceBundle() is
-            // overriden
+            // overridden
             final String rbName = getResourceBundleName();
             return LoggerBundle.get(rbName, b);
         }