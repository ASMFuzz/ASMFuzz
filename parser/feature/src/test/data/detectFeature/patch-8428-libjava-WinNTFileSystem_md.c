@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2001, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2001, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -23,11 +23,6 @@
  * questions.
  */
 
-/* Access APIs for WinXP and above */
-#ifndef _WIN32_WINNT
-#define _WIN32_WINNT 0x0501
-#endif
-
 #include <assert.h>
 #include <stdio.h>
 #include <stdlib.h>