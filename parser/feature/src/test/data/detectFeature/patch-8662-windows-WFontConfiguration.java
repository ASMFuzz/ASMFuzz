@@ -52,7 +52,10 @@ public WFontConfiguration(SunFontManager fm,
 
     @Override
     protected void initReorderMap() {
-        if (encoding.equalsIgnoreCase("windows-31j")) {
+        if (encoding.equalsIgnoreCase("windows-31j") ||
+            (encoding.equalsIgnoreCase("UTF-8") &&
+             startupLocale.getLanguage().equals("ja")))
+        {
             localeMap = new Hashtable<>();
             /* Substitute Mincho for Gothic in this one case.
              * Note the windows fontconfig files already contain the mapping:
@@ -173,14 +176,15 @@ private String findFontWithCharset(FontDescriptor[] fontDescriptors, String char
             String componentFontName = fontDescriptors[i].getNativeName();
             if (componentFontName.endsWith(charset)) {
                 fontName = componentFontName;
+                break;
             }
         }
         return fontName;
     }
 
     private static HashMap<String, String> subsetCharsetMap = new HashMap<>();
     private static HashMap<String, String> subsetEncodingMap = new HashMap<>();
-    private static String textInputCharset;
+    private static String textInputCharset = "DEFAULT_CHARSET";
 
     private void initTables(String defaultEncoding) {
         subsetCharsetMap.put("alphabetic", "ANSI_CHARSET");
@@ -237,8 +241,6 @@ private void initTables(String defaultEncoding) {
             textInputCharset = "CHINESEBIG5_CHARSET";
         } else if ("windows-1251".equals(defaultEncoding)) {
             textInputCharset = "RUSSIAN_CHARSET";
-        } else if ("UTF-8".equals(defaultEncoding)) {
-            textInputCharset = "DEFAULT_CHARSET";
         } else if ("windows-1253".equals(defaultEncoding)) {
             textInputCharset = "GREEK_CHARSET";
         } else if ("windows-1255".equals(defaultEncoding)) {
@@ -249,8 +251,25 @@ private void initTables(String defaultEncoding) {
             textInputCharset = "HANGEUL_CHARSET";
         } else if ("x-windows-874".equals(defaultEncoding)) {
             textInputCharset = "THAI_CHARSET";
-        } else {
-            textInputCharset = "DEFAULT_CHARSET";
+        } else if (defaultEncoding.startsWith("UTF-8")) {
+            String lang = startupLocale.getLanguage();
+            String country = startupLocale.getCountry();
+            textInputCharset = switch(lang) {
+                case "ar" -> "ARABIC_CHARSET";
+                case "zh" -> {
+                    yield switch(country) {
+                        case "TW", "HK" -> "CHINESEBIG5_CHARSET";
+                        default -> "GB2312_CHARSET";
+                    };
+                }
+                case "ru" -> "RUSSIAN_CHARSET";
+                case "el" -> "GREEK_CHARSET";
+                case "iw", "he" -> "HEBREW_CHARSET";
+                case "ja" -> "SHIFTJIS_CHARSET";
+                case "ko" -> "HANGEUL_CHARSET";
+                case "th" -> "THAI_CHARSET";
+                default -> "DEFAULT_CHARSET";
+            };
         }
     }
 }