@@ -1,6 +1,6 @@
 /*
- * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
- * Copyright (c) 2021, JetBrains s.r.o.. All rights reserved.
+ * Copyright (c) 2021, 2022, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2021, 2022, JetBrains s.r.o.. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -29,6 +29,7 @@
 @interface TableAccessibility : CommonComponentAccessibility <NSAccessibilityTable>
 {
     NSMutableDictionary<NSNumber*, id> *rowCache;
+    BOOL cacheValid;
 }
 
 - (BOOL)isAccessibleChildSelectedFromIndex:(int)index;