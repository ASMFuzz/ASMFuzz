@@ -771,7 +771,7 @@ public synchronized Map<DataFlavor,String> getNativesForFlavors(DataFlavor[] fla
             flavor_list.toArray(flavors);
         }
 
-        Map<DataFlavor, String> retval = new HashMap<>(flavors.length, 1.0f);
+        Map<DataFlavor, String> retval = HashMap.newHashMap(flavors.length);
         for (DataFlavor flavor : flavors) {
             List<String> natives = getNativesForFlavor(flavor);
             String nat = (natives.isEmpty()) ? null : natives.get(0);
@@ -812,7 +812,7 @@ public synchronized Map<String,DataFlavor> getFlavorsForNatives(String[] natives
             nativesList.toArray(natives);
         }
 
-        Map<String, DataFlavor> retval = new HashMap<>(natives.length, 1.0f);
+        Map<String, DataFlavor> retval = HashMap.newHashMap(natives.length);
         for (String aNative : natives) {
             List<DataFlavor> flavors = getFlavorsForNative(aNative);
             DataFlavor flav = (flavors.isEmpty())? null : flavors.get(0);
@@ -1059,7 +1059,7 @@ private static final class SoftCache<K, V> {
 
         public void put(K key, LinkedHashSet<V> value) {
             if (cache == null) {
-                cache = new HashMap<>(1);
+                cache = HashMap.newHashMap(1);
             }
             cache.put(key, new SoftReference<>(value));
         }