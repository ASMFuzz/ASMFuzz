@@ -4,7 +4,7 @@
  *
  *   User-selectable configuration macros (specification only).
  *
- * Copyright (C) 1996-2020 by
+ * Copyright (C) 1996-2022 by
  * David Turner, Robert Wilhelm, and Werner Lemberg.
  *
  * This file is part of the FreeType project, and may only be used,
@@ -105,8 +105,7 @@ FT_BEGIN_HEADER
    *
    * ```
    *   FREETYPE_PROPERTIES=truetype:interpreter-version=35 \
-   *                       cff:no-stem-darkening=1 \
-   *                       autofitter:warping=1
+   *                       cff:no-stem-darkening=1
    * ```
    *
    */
@@ -220,6 +219,10 @@ FT_BEGIN_HEADER
    *   If you use a build system like cmake or the `configure` script,
    *   options set by those programs have precedence, overwriting the value
    *   here with the configured one.
+   *
+   *   If you use the GNU make build system directly (that is, without the
+   *   `configure` script) and you define this macro, you also have to pass
+   *   `SYSTEM_ZLIB=yes` as an argument to make.
    */
 /* #define FT_CONFIG_OPTION_SYSTEM_ZLIB */
 
@@ -431,6 +434,23 @@ FT_BEGIN_HEADER
 /* #define FT_DEBUG_LEVEL_TRACE */
 
 
+  /**************************************************************************
+   *
+   * Logging
+   *
+   *   Compiling FreeType in debug or trace mode makes FreeType write error
+   *   and trace log messages to `stderr`.  Enabling this macro
+   *   automatically forces the `FT_DEBUG_LEVEL_ERROR` and
+   *   `FT_DEBUG_LEVEL_TRACE` macros and allows FreeType to write error and
+   *   trace log messages to a file instead of `stderr`.  For writing logs
+   *   to a file, FreeType uses an the external `dlg` library (the source
+   *   code is in `src/dlg`).
+   *
+   *   This option needs a C99 compiler.
+   */
+/* #define FT_DEBUG_LOGGING */
+
+
   /**************************************************************************
    *
    * Autofitter debugging
@@ -507,6 +527,20 @@ FT_BEGIN_HEADER
 #undef FT_CONFIG_OPTION_USE_MODULE_ERRORS
 
 
+  /**************************************************************************
+   *
+   * OpenType SVG Glyph Support
+   *
+   *   Setting this macro enables support for OpenType SVG glyphs.  By
+   *   default, FreeType can only fetch SVG documents.  However, it can also
+   *   render them if external rendering hook functions are plugged in at
+   *   runtime.
+   *
+   *   More details on the hooks can be found in file `otsvg.h`.
+   */
+/* #define FT_CONFIG_OPTION_SVG */
+
+
   /**************************************************************************
    *
    * Error Strings
@@ -892,24 +926,6 @@ FT_BEGIN_HEADER
 #endif
 
 
-  /**************************************************************************
-   *
-   * Compile 'autofit' module with warp hinting.  The idea of the warping
-   * code is to slightly scale and shift a glyph within a single dimension so
-   * that as much of its segments are aligned (more or less) on the grid.  To
-   * find out the optimal scaling and shifting value, various parameter
-   * combinations are tried and scored.
-   *
-   * You can switch warping on and off with the `warping` property of the
-   * auto-hinter (see file `ftdriver.h` for more information; by default it
-   * is switched off).
-   *
-   * This experimental option is not active if the rendering mode is
-   * `FT_RENDER_MODE_LIGHT`.
-   */
-#define AF_CONFIG_OPTION_USE_WARPER
-
-
   /**************************************************************************
    *
    * Use TrueType-like size metrics for 'light' auto-hinting.
@@ -961,6 +977,21 @@ FT_BEGIN_HEADER
 #endif
 
 
+  /*
+   * The TT_SUPPORT_COLRV1 macro is defined to indicate to clients that this
+   * version of FreeType has support for 'COLR' v1 API.  This definition is
+   * useful to FreeType clients that want to build in support for 'COLR' v1
+   * depending on a tip-of-tree checkout before it is officially released in
+   * FreeType, and while the feature cannot yet be tested against using
+   * version macros.  Don't change this macro.  This may be removed once the
+   * feature is in a FreeType release version and version macros can be used
+   * to test for availability.
+   */
+#ifdef TT_CONFIG_OPTION_COLOR_LAYERS
+#define  TT_SUPPORT_COLRV1
+#endif
+
+
   /*
    * Check CFF darkening parameters.  The checks are the same as in function
    * `cff_property_set` in file `cffdrivr.c`.
@@ -989,8 +1020,8 @@ FT_BEGIN_HEADER
 #error "Invalid CFF darkening parameters!"
 #endif
 
-FT_END_HEADER
 
+FT_END_HEADER
 
 #endif /* FTOPTION_H_ */
 