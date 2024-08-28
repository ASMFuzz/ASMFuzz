@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -108,17 +108,6 @@ inline int g_isnan(jdouble f)                    { return _isnan(f); }
 inline int g_isfinite(jfloat  f)                 { return _finite(f); }
 inline int g_isfinite(jdouble f)                 { return _finite(f); }
 
-// Miscellaneous
-
-// Visual Studio 2005 deprecates POSIX names - use ISO C++ names instead
-#define open _open
-#define close _close
-#define read  _read
-#define write _write
-#define lseek _lseek
-#define unlink _unlink
-#define strdup _strdup
-
 // Formatting.
 #define FORMAT64_MODIFIER "I64"
 