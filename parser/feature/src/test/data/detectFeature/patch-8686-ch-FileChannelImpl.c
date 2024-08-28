@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -110,7 +110,7 @@ Java_sun_nio_ch_FileChannelImpl_map0(JNIEnv *env, jobject this,
         mapAccess,           /* Read and write access */
         highOffset,          /* High word of offset */
         lowOffset,           /* Low word of offset */
-        (DWORD)len);         /* Number of bytes to map */
+        (SIZE_T)len);        /* Number of bytes to map */
     mapError = GetLastError();
 
     result = CloseHandle(mapping);