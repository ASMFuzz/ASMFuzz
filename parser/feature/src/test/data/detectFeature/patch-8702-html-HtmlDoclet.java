@@ -314,19 +314,7 @@ private void copyJqueryFiles() throws DocletException {
         List<String> files = Arrays.asList(
                 DocPaths.JQUERY_JS.getPath(),
                 DocPaths.JQUERY_UI_JS.getPath(),
-                DocPaths.JQUERY_UI_CSS.getPath(),
-                DocPaths.JQUERY_UI_STRUCTURE_CSS.getPath(),
-                "images/ui-bg_glass_65_dadada_1x400.png",
-                "images/ui-icons_454545_256x240.png",
-                "images/ui-bg_glass_95_fef1ec_1x400.png",
-                "images/ui-bg_glass_75_dadada_1x400.png",
-                "images/ui-bg_highlight-soft_75_cccccc_1x100.png",
-                "images/ui-icons_888888_256x240.png",
-                "images/ui-icons_2e83ff_256x240.png",
-                "images/ui-icons_cd0a0a_256x240.png",
-                "images/ui-bg_glass_55_fbf9ee_1x400.png",
-                "images/ui-icons_222222_256x240.png",
-                "images/ui-bg_glass_75_e6e6e6_1x400.png");
+                DocPaths.JQUERY_UI_CSS.getPath());
         DocFile f;
         for (String file : files) {
             DocPath filePath = DocPaths.SCRIPT_DIR.resolve(file);