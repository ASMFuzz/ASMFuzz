@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2002, 2014, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2002, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -23,11 +23,6 @@
  * questions.
  */
 
-/* Need to define this to get CAPI functions included */
-#ifndef _WIN32_WINNT
-#define _WIN32_WINNT 0x0400
-#endif
-
 #include <windows.h>
 #include <wincrypt.h>
 #include <jni.h>