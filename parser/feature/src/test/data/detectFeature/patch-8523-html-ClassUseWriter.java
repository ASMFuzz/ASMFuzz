@@ -143,11 +143,11 @@ public ClassUseWriter(HtmlConfiguration configuration,
      * Write out class use pages.
      *
      * @param configuration the configuration for this doclet
-     * @param classtree the class tree hierarchy
+     * @param classTree the class tree hierarchy
      * @throws DocFileIOException if there is an error while generating the documentation
      */
-    public static void generate(HtmlConfiguration configuration, ClassTree classtree) throws DocFileIOException  {
-        ClassUseMapper mapper = new ClassUseMapper(configuration, classtree);
+    public static void generate(HtmlConfiguration configuration, ClassTree classTree) throws DocFileIOException  {
+        ClassUseMapper mapper = new ClassUseMapper(configuration, classTree);
         boolean nodeprecated = configuration.getOptions().noDeprecated();
         Utils utils = configuration.utils;
         for (TypeElement aClass : configuration.getIncludedTypeElements()) {