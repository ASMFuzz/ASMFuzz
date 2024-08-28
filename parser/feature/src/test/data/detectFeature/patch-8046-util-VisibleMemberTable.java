@@ -221,7 +221,7 @@ List<VisibleMemberTable> getAllSuperinterfaces() {
      */
     public List<Element> getAllVisibleMembers(Kind kind) {
         ensureInitialized();
-        return visibleMembers.getOrDefault(kind, Collections.emptyList());
+        return visibleMembers.getOrDefault(kind, List.of());
     }
 
     /**
@@ -234,7 +234,7 @@ public List<Element> getAllVisibleMembers(Kind kind) {
     public List<Element> getVisibleMembers(Kind kind, Predicate<Element> p) {
         ensureInitialized();
 
-        return visibleMembers.getOrDefault(kind, Collections.emptyList()).stream()
+        return visibleMembers.getOrDefault(kind, List.of()).stream()
                 .filter(p)
                 .toList();
     }
@@ -799,10 +799,10 @@ class LocalMemberTable {
             // Freeze the data structures
             for (Kind kind : Kind.values()) {
                 orderedMembers.computeIfPresent(kind, (k, v) -> Collections.unmodifiableList(v));
-                orderedMembers.computeIfAbsent(kind, t -> Collections.emptyList());
+                orderedMembers.computeIfAbsent(kind, t -> List.of());
 
                 memberMap.computeIfPresent(kind, (k, v) -> Collections.unmodifiableMap(v));
-                memberMap.computeIfAbsent(kind, t -> Collections.emptyMap());
+                memberMap.computeIfAbsent(kind, t -> Map.of());
             }
         }
 
@@ -840,12 +840,12 @@ List<Element> getMembers(Element e, Kind kind) {
 
         List<Element> getMembers(String key, Kind kind) {
             Map<String, List<Element>> map = memberMap.get(kind);
-            return map.getOrDefault(key, Collections.emptyList());
+            return map.getOrDefault(key, List.of());
         }
 
         <T extends Element> List<T> getMembers(String key, Kind kind, Class<T> clazz) {
             Map<String, List<Element>> map = memberMap.get(kind);
-            return map.getOrDefault(key, Collections.emptyList())
+            return map.getOrDefault(key, List.of())
                     .stream()
                     .map(clazz::cast)
                     .toList();
@@ -901,7 +901,7 @@ private void computeVisibleProperties(LocalMemberTable lmt) {
             return;
 
         PropertyUtils pUtils = config.propertyUtils;
-        List<Element> list = visibleMembers.getOrDefault(Kind.METHODS, Collections.emptyList())
+        List<Element> list = visibleMembers.getOrDefault(Kind.METHODS, List.of())
                 .stream()
                 .filter(e -> pUtils.isPropertyMethod((ExecutableElement) e))
                 .toList();