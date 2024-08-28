@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2008, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2008, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -108,7 +108,7 @@ Java_sun_nio_fs_BsdNativeDispatcher_getfsstat(JNIEnv* env, jclass this)
     }
 
     // It's possible that a new filesystem gets mounted between
-    // the first getfsstat and the second so loop until consistant
+    // the first getfsstat and the second so loop until consistent
 
     while (nentries != iter->nentries) {
         if (iter->buf != NULL)