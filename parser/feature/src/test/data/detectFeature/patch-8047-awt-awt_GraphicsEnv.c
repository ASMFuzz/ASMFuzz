@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -1428,6 +1428,9 @@ Java_sun_awt_X11GraphicsDevice_getDoubleBufferVisuals(JNIEnv *env,
             break;
         }
     }
+    AWT_LOCK();
+    XdbeFreeVisualInfo(visScreenInfo);
+    AWT_UNLOCK();
 }
 
 /*