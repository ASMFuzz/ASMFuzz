@@ -137,8 +137,8 @@ private void writeInt(DataOutput out, int v) throws IOException {
     private void buildStringPool(Element element, Set<String> pool) {
         pool.add(element.name);
         for (Attribute a : element.attributes) {
-            pool.add(a.name);
-            pool.add(a.value);
+            pool.add(a.name());
+            pool.add(a.value());
         }
         for (Element child : element.elements) {
             buildStringPool(child, pool);
@@ -149,8 +149,8 @@ private void write(DataOutput output,Element element, HashMap<String, Integer> l
         writeInt(output, lookup.get(element.name));
         writeInt(output, element.attributes.size());
         for (Attribute a : element.attributes) {
-            writeInt(output, lookup.get(a.name));
-            writeInt(output, lookup.get(a.value));
+            writeInt(output, lookup.get(a.name()));
+            writeInt(output, lookup.get(a.value()));
         }
         writeInt(output, element.elements.size());
         for (Element child : element.elements) {