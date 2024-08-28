@@ -5,7 +5,7 @@
  *   ANSI-specific library and header configuration file (specification
  *   only).
  *
- * Copyright (C) 2002-2020 by
+ * Copyright (C) 2002-2022 by
  * David Turner, Robert Wilhelm, and Werner Lemberg.
  *
  * This file is part of the FreeType project, and may only be used,
@@ -43,7 +43,8 @@
    *
    * `UINT_MAX` and `ULONG_MAX` are used to automatically compute the size of
    * `int` and `long` in bytes at compile-time.  So far, this works for all
-   * platforms the library has been tested on.
+   * platforms the library has been tested on.  We also check `ULLONG_MAX`
+   * to see whether we can use 64-bit `long long` later on.
    *
    * Note that on the extremely rare platforms that do not provide integer
    * types that are _exactly_ 16 and 32~bits wide (e.g., some old Crays where
@@ -66,6 +67,15 @@
 #define FT_LONG_MIN    LONG_MIN
 #define FT_LONG_MAX    LONG_MAX
 #define FT_ULONG_MAX   ULONG_MAX
+#ifdef LLONG_MAX
+#define FT_LLONG_MAX   LLONG_MAX
+#endif
+#ifdef LLONG_MIN
+#define FT_LLONG_MIN   LLONG_MIN
+#endif
+#ifdef ULLONG_MAX
+#define FT_ULLONG_MAX  ULLONG_MAX
+#endif
 
 
   /**************************************************************************