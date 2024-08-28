@@ -434,7 +434,7 @@ protected String escapeIfNecessary(String string) {
     }
 
     public Set<Attribute> makeAttributes(List<Object> names) {
-        Set<Attribute> set = new HashSet<>(Math.max(1, names.size()));
+        Set<Attribute> set = HashSet.newHashSet(names.size());
 
         for (int counter = 0; counter < names.size(); counter++) {
             set.add(makeAttribute((String)names.get(counter)));