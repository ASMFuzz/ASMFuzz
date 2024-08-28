@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -579,7 +579,8 @@ getAllConfigs (JNIEnv *env, int screen, AwtScreenDataPtr screenDataPtr) {
        XFree (pVI8sg);
     if (n1sg != 0)
        XFree (pVI1sg);
-
+    if (nTrue != 0)
+       XFree (pVITrue);
     AWT_UNLOCK ();
 }
 