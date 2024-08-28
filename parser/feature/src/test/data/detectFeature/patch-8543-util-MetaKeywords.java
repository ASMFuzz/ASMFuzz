@@ -70,39 +70,35 @@ public MetaKeywords(BaseConfiguration configuration) {
      * definitions are on separate pages.
      */
     public List<String> getMetaKeywords(TypeElement typeElement) {
-        ArrayList<String> results = new ArrayList<>();
+        var results = new ArrayList<String>();
 
         // Add field and method keywords only if -keywords option is used
         if (options.keywords()) {
             results.addAll(getClassKeyword(typeElement));
             results.addAll(getMemberKeywords(utils.getFields(typeElement)));
             results.addAll(getMemberKeywords(utils.getMethods(typeElement)));
         }
-        ((ArrayList)results).trimToSize();
+        results.trimToSize();
         return results;
     }
 
     /**
-     * Get the current class for a meta tag keyword, as the first
-     * and only element of an array list.
+     * Get the current class for a meta tag keyword, as a singleton list.
      */
     protected List<String> getClassKeyword(TypeElement typeElement) {
-        ArrayList<String> metakeywords = new ArrayList<>(1);
         String cltypelower = utils.isPlainInterface(typeElement) ? "interface" : "class";
-        metakeywords.add(utils.getFullyQualifiedName(typeElement) + " " + cltypelower);
-        return metakeywords;
+        return List.of(utils.getFullyQualifiedName(typeElement) + " " + cltypelower);
     }
 
     /**
      * Get the package keywords.
      */
     public List<String> getMetaKeywords(PackageElement packageElement) {
-        List<String> result = new ArrayList<>(1);
         if (options.keywords()) {
-            String pkgName = utils.getPackageName(packageElement);
-            result.add(pkgName + " " + "package");
+            return List.of(utils.getPackageName(packageElement) + " " + "package");
+        } else {
+            return List.of();
         }
-        return result;
     }
 
     /**
@@ -122,16 +118,16 @@ public List<String> getMetaKeywordsForModule(ModuleElement mdle) {
      * Get the overview keywords.
      */
     public List<String> getOverviewMetaKeywords(String title, String docTitle) {
-         List<String> result = new ArrayList<>(1);
         if (options.keywords()) {
             String windowOverview = resources.getText(title);
             if (docTitle.length() > 0) {
-                result.add(windowOverview + ", " + docTitle);
+                return List.of(windowOverview + ", " + docTitle);
             } else {
-                result.add(windowOverview);
+                return List.of(windowOverview);
             }
+        } else {
+            return List.of();
         }
-        return result;
     }
 
     /**
@@ -144,16 +140,16 @@ public List<String> getOverviewMetaKeywords(String title, String docTitle) {
      * @param members  array of members to be added to keywords
      */
     protected List<String> getMemberKeywords(List<? extends Element> members) {
-        ArrayList<String> results = new ArrayList<>();
+        var results = new ArrayList<String>();
         for (Element member : members) {
-            String membername = utils.isMethod(member)
+            String memberName = utils.isMethod(member)
                     ? utils.getSimpleName(member) + "()"
                     : utils.getSimpleName(member);
-            if (!results.contains(membername)) {
-                results.add(membername);
+            if (!results.contains(memberName)) {
+                results.add(memberName);
             }
         }
-        ((ArrayList)results).trimToSize();
+        results.trimToSize();
         return results;
     }
 }