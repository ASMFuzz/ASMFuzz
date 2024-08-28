@@ -317,7 +317,7 @@ private static Map<String, String> deserializeProperties(byte[] serializedProper
         DataInputStream in = new DataInputStream(new ByteArrayInputStream(serializedProperties));
         int utf8Props = in.readInt();
         int nonUtf8Props = in.readInt();
-        Map<String, String> props = new HashMap<>(utf8Props + nonUtf8Props);
+        Map<String, String> props = HashMap.newHashMap(utf8Props + nonUtf8Props);
         int index = 0;
         while (in.available() != 0) {
             if (index < utf8Props) {