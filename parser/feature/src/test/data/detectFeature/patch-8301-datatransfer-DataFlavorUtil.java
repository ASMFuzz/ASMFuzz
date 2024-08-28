@@ -95,7 +95,7 @@ public static Comparator<DataFlavor> getTextFlavorComparator() {
     private static final Map<String, Boolean> textMIMESubtypeCharsetSupport;
 
     static {
-        Map<String, Boolean> tempMap = new HashMap<>(17);
+        Map<String, Boolean> tempMap = HashMap.newHashMap(15);
         tempMap.put("sgml", Boolean.TRUE);
         tempMap.put("xml", Boolean.TRUE);
         tempMap.put("html", Boolean.TRUE);
@@ -322,7 +322,7 @@ private static class CharsetComparator implements Comparator<String> {
         private static final String UNSUPPORTED_CHARSET = "UNSUPPORTED";
 
         static {
-            Map<String, Integer> charsetsMap = new HashMap<>(8, 1.0f);
+            Map<String, Integer> charsetsMap = HashMap.newHashMap(8);
 
             // we prefer Unicode charsets
             charsetsMap.put(UTF_16LE.name(), 4);
@@ -436,7 +436,7 @@ private static class DataFlavorComparator implements Comparator<DataFlavor> {
 
         static {
             {
-                Map<String, Integer> exactTypesMap = new HashMap<>(4, 1.0f);
+                Map<String, Integer> exactTypesMap = HashMap.newHashMap(4);
 
                 // application/x-java-* MIME types
                 exactTypesMap.put("application/x-java-file-list", 0);
@@ -448,15 +448,15 @@ private static class DataFlavorComparator implements Comparator<DataFlavor> {
             }
 
             {
-                Map<String, Integer> primaryTypesMap = new HashMap<>(1, 1.0f);
+                Map<String, Integer> primaryTypesMap = HashMap.newHashMap(1);
 
                 primaryTypesMap.put("application", 0);
 
                 primaryTypes = Collections.unmodifiableMap(primaryTypesMap);
             }
 
             {
-                Map<Class<?>, Integer> nonTextRepresentationsMap = new HashMap<>(3, 1.0f);
+                Map<Class<?>, Integer> nonTextRepresentationsMap = HashMap.newHashMap(3);
 
                 nonTextRepresentationsMap.put(java.io.InputStream.class, 0);
                 nonTextRepresentationsMap.put(java.io.Serializable.class, 1);
@@ -467,7 +467,7 @@ private static class DataFlavorComparator implements Comparator<DataFlavor> {
             }
 
             {
-                Map<String, Integer> textTypesMap = new HashMap<>(16, 1.0f);
+                Map<String, Integer> textTypesMap = HashMap.newHashMap(16);
 
                 // plain text
                 textTypesMap.put("text/plain", 0);
@@ -499,7 +499,7 @@ private static class DataFlavorComparator implements Comparator<DataFlavor> {
             }
 
             {
-                Map<Class<?>, Integer> decodedTextRepresentationsMap = new HashMap<>(4, 1.0f);
+                Map<Class<?>, Integer> decodedTextRepresentationsMap = HashMap.newHashMap(4);
 
                 decodedTextRepresentationsMap.put(char[].class, 0);
                 decodedTextRepresentationsMap.put(CharBuffer.class, 1);
@@ -511,7 +511,7 @@ private static class DataFlavorComparator implements Comparator<DataFlavor> {
             }
 
             {
-                Map<Class<?>, Integer> encodedTextRepresentationsMap = new HashMap<>(3, 1.0f);
+                Map<Class<?>, Integer> encodedTextRepresentationsMap = HashMap.newHashMap(3);
 
                 encodedTextRepresentationsMap.put(byte[].class, 0);
                 encodedTextRepresentationsMap.put(ByteBuffer.class, 1);