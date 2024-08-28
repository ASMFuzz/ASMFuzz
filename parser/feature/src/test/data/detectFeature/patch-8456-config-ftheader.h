@@ -4,7 +4,7 @@
  *
  *   Build macros of the FreeType 2 library.
  *
- * Copyright (C) 1996-2020 by
+ * Copyright (C) 1996-2022 by
  * David Turner, Robert Wilhelm, and Werner Lemberg.
  *
  * This file is part of the FreeType project, and may only be used,
@@ -777,6 +777,18 @@
 #define FT_COLOR_H  <freetype/ftcolor.h>
 
 
+  /**************************************************************************
+   *
+   * @macro:
+   *   FT_OTSVG_H
+   *
+   * @description:
+   *   A macro used in `#include` statements to name the file containing the
+   *   FreeType~2 API which handles the OpenType 'SVG~' glyphs.
+   */
+#define FT_OTSVG_H  <freetype/otsvg.h>
+
+
   /* */
 
   /* These header files don't need to be included by the user. */