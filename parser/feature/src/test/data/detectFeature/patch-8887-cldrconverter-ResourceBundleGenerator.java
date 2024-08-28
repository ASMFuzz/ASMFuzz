@@ -165,15 +165,15 @@ public void generateBundle(String packageName, String baseName, String localeID,
                             if (val instanceof String[]) {
                                 fmt.format("        final String[] %s = new String[] {\n", metaVal);
                                 for (String s : (String[]) val) {
-                                    fmt.format("               \"%s\",\n", CLDRConverter.saveConvert(s, useJava));
+                                    fmt.format("            \"%s\",\n", CLDRConverter.saveConvert(s, useJava));
                                 }
-                                fmt.format("            };\n");
+                                fmt.format("        };\n");
                             } else if (val instanceof List) {
                                 fmt.format("        final String[] %s = new String[] {\n", metaVal);
                                 for (String s : (List<String>) val) {
-                                    fmt.format("               \"%s\",\n", CLDRConverter.saveConvert(s, useJava));
+                                    fmt.format("            \"%s\",\n", CLDRConverter.saveConvert(s, useJava));
                                 }
-                                fmt.format("            };\n");
+                                fmt.format("        };\n");
                             } else {
                                 fmt.format("        final String %s = \"%s\";\n", metaVal, CLDRConverter.saveConvert((String)val, useJava));
                             }
@@ -268,27 +268,29 @@ public void generateMetaInfo(Map<String, SortedSet<String>> metaInfo) throws IOE
         try (PrintWriter out = new PrintWriter(file, "us-ascii")) {
             out.printf(CopyrightHeaders.getOpenJDKCopyright(CLDRConverter.copyrightYear));
 
-            out.printf((CLDRConverter.isBaseModule ? "package sun.util.cldr;\n\n" :
-                                  "package sun.util.resources.cldr.provider;\n\n")
-                      + "import java.util.HashMap;\n"
-                      + "import java.util.Locale;\n"
-                      + "import java.util.Map;\n"
-                      + "import sun.util.locale.provider.LocaleDataMetaInfo;\n"
-                      + "import sun.util.locale.provider.LocaleProviderAdapter;\n\n");
-            out.printf("public class %s implements LocaleDataMetaInfo {\n", className);
-            out.printf("    private static final Map<String, String> resourceNameToLocales = new HashMap<>(" +
-                                ((int)(metaInfo.keySet().stream()
-                                    .filter(k -> k.equals("AvailableLocales"))
-                                    .count() / 0.75f) + 1) + ");\n" +
-                    (CLDRConverter.isBaseModule ?
-                       "    private static final Map<Locale, String[]> parentLocalesMap = new HashMap<>(" +
-                                ((int)(metaInfo.keySet().stream()
-                                    .filter(k -> k.startsWith(CLDRConverter.PARENT_LOCALE_PREFIX))
-                                    .count() / 0.75f) + 1) + ");\n" +
-                       "    private static final Map<String, String> languageAliasMap = new HashMap<>(" +
-                                ((int)(CLDRConverter.handlerSupplMeta.getLanguageAliasData().size() / 0.75f) + 1) + ");\n\n" :
-                       "\n") +
-                       "    static {\n");
+            out.printf("""
+                package sun.util.%s;
+
+                import java.util.HashMap;
+                import java.util.Locale;
+                import java.util.Map;
+                import sun.util.locale.provider.LocaleDataMetaInfo;
+                import sun.util.locale.provider.LocaleProviderAdapter;
+
+                public class %s implements LocaleDataMetaInfo {
+                    private static final Map<String, String> resourceNameToLocales = HashMap.newHashMap(%d);
+                %s
+                    static {
+                """, CLDRConverter.isBaseModule ? "cldr" : "resources.cldr.provider",
+                className, metaInfo.keySet().stream().filter(k -> k.equals("AvailableLocales")).count(),
+                CLDRConverter.isBaseModule ?
+                    """
+                        private static final Map<Locale, String[]> parentLocalesMap = HashMap.newHashMap(%d);
+                        private static final Map<String, String> languageAliasMap = HashMap.newHashMap(%d);
+                    """.formatted(
+                        metaInfo.keySet().stream().filter(k -> k.startsWith(CLDRConverter.PARENT_LOCALE_PREFIX)).count(),
+                        CLDRConverter.handlerSupplMeta.getLanguageAliasData().size()) :
+                    "");
 
             for (String key : metaInfo.keySet()) {
                 if (key.startsWith(CLDRConverter.PARENT_LOCALE_PREFIX)) {
@@ -301,23 +303,23 @@ public void generateMetaInfo(Map<String, SortedSet<String>> metaInfo) throws IOE
                     }
                     String[] children = toLocaleList(metaInfo.get(key), true).split(" ");
                     Arrays.sort(children);
-                    out.printf("             new String[] {\n" +
-                               "                 ");
+                    out.printf("            new String[] {\n" +
+                               "                ");
                     int count = 0;
                     for (int i = 0; i < children.length; i++) {
                         String child = children[i];
                         out.printf("\"%s\", ", child);
                         count += child.length() + 4;
                         if (i != children.length - 1 && count > 64) {
-                            out.printf("\n                 ");
+                            out.printf("\n                ");
                             count = 0;
                         }
                     }
-                    out.printf("\n             });\n");
+                    out.printf("\n            });\n");
                 } else {
                     if ("AvailableLocales".equals(key)) {
                         out.printf("        resourceNameToLocales.put(\"%s\",\n", key);
-                        out.printf("              \"%s\");\n", toLocaleList(applyLanguageAliases(metaInfo.get(key)), false));
+                        out.printf("            \"%s\");\n", toLocaleList(applyLanguageAliases(metaInfo.get(key)), false));
                     }
                 }
             }
@@ -334,10 +336,11 @@ public void generateMetaInfo(Map<String, SortedSet<String>> metaInfo) throws IOE
 
             // Canonical TZ names for delayed initialization
             if (CLDRConverter.isBaseModule) {
-                out.printf("    private static class TZCanonicalIDMapHolder {\n");
-                out.printf("        static final Map<String, String> tzCanonicalIDMap = new HashMap<>(" +
-                        ((int)(CLDRConverter.handlerTimeZone.getData().size() / 0.75f) + 1) + ");\n");
-                out.printf("        static {\n");
+                out.printf("""
+                               private static class TZCanonicalIDMapHolder {
+                                   static final Map<String, String> tzCanonicalIDMap = HashMap.newHashMap(%d);
+                                   static {
+                           """, CLDRConverter.handlerTimeZone.getData().size());
                 CLDRConverter.handlerTimeZone.getData().entrySet().stream()
                     .forEach(e -> {
                         String[] ids = ((String)e.getValue()).split("\\s");
@@ -351,31 +354,35 @@ public void generateMetaInfo(Map<String, SortedSet<String>> metaInfo) throws IOE
                 out.printf("        }\n    }\n\n");
             }
 
-            out.printf("    @Override\n" +
-                        "    public LocaleProviderAdapter.Type getType() {\n" +
-                        "        return LocaleProviderAdapter.Type.CLDR;\n" +
-                        "    }\n\n");
+            out.printf("""
+                    @Override
+                    public LocaleProviderAdapter.Type getType() {
+                        return LocaleProviderAdapter.Type.CLDR;
+                    }
 
-            out.printf("    @Override\n" +
-                        "    public String availableLanguageTags(String category) {\n" +
-                        "        return resourceNameToLocales.getOrDefault(category, \"\");\n" +
-                        "    }\n\n");
+                    @Override
+                    public String availableLanguageTags(String category) {
+                        return resourceNameToLocales.getOrDefault(category, "");
+                    }
+                    %s
+                }
+                """,
+                CLDRConverter.isBaseModule ? """
 
-            if (CLDRConverter.isBaseModule) {
-                out.printf("    @Override\n" +
-                           "    public Map<String, String> getLanguageAliasMap() {\n" +
-                           "        return languageAliasMap;\n" +
-                           "    }\n\n");
-                out.printf("    @Override\n" +
-                           "    public Map<String, String> tzCanonicalIDs() {\n" +
-                           "        return TZCanonicalIDMapHolder.tzCanonicalIDMap;\n" +
-                           "    }\n\n");
-                out.printf("    public Map<Locale, String[]> parentLocales() {\n" +
-                           "        return parentLocalesMap;\n" +
-                           "    }\n}");
-            } else {
-                out.printf("}");
-            }
+                    @Override
+                    public Map<String, String> getLanguageAliasMap() {
+                        return languageAliasMap;
+                    }
+
+                    @Override
+                    public Map<String, String> tzCanonicalIDs() {
+                        return TZCanonicalIDMapHolder.tzCanonicalIDMap;
+                    }
+
+                    public Map<Locale, String[]> parentLocales() {
+                        return parentLocalesMap;
+                    }
+                """ : "");
         }
     }
 