@@ -169,18 +169,13 @@ public static void generate(HtmlConfiguration configuration, ClassTree classtree
 
     private Map<PackageElement, List<Element>> pkgDivide(Map<TypeElement, ? extends List<? extends Element>> classMap) {
         Map<PackageElement, List<Element>> map = new HashMap<>();
-        List<? extends Element> elements = (List<? extends Element>) classMap.get(typeElement);
+        List<? extends Element> elements = classMap.get(typeElement);
         if (elements != null) {
             elements.sort(comparators.makeClassUseComparator());
             for (Element e : elements) {
                 PackageElement pkg = utils.containingPackage(e);
                 pkgSet.add(pkg);
-                List<Element> inPkg = map.get(pkg);
-                if (inPkg == null) {
-                    inPkg = new ArrayList<>();
-                    map.put(pkg, inPkg);
-                }
-                inPkg.add(e);
+                map.computeIfAbsent(pkg, k -> new ArrayList<>()).add(e);
             }
         }
         return map;