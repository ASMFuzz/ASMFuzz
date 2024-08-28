@@ -181,33 +181,26 @@ private AnnotationElement makeAnnotation(Element annotationElement) throws IOExc
 
     private Object objectify(String typeName, String text) throws IOException {
         try {
-            switch (typeName) {
-            case "int":
-                return Integer.valueOf(text);
-            case "long":
-                return Long.valueOf(text);
-            case "double":
-                return Double.valueOf(text);
-            case "float":
-                return Float.valueOf(text);
-            case "short":
-                return Short.valueOf(text);
-            case "char":
-                if (text.length() != 1) {
-                    throw new IOException("Unexpected size of char");
+            return switch (typeName) {
+                case "int" -> Integer.valueOf(text);
+                case "long" -> Long.valueOf(text);
+                case "double" ->   Double.valueOf(text);
+                case "float" -> Float.valueOf(text);
+                case "short" -> Short.valueOf(text);
+                case "char" -> {
+                    if (text.length() != 1) {
+                        throw new IOException("Unexpected size of char");
+                    }
+                    yield text.charAt(0);
                 }
-                return text.charAt(0);
-            case "byte":
-                return Byte.valueOf(text);
-            case "boolean":
-                return Boolean.valueOf(text);
-            case "java.lang.String":
-                return text;
-            }
+                case "byte" -> Byte.valueOf(text);
+                case "boolean" -> Boolean.valueOf(text);
+                case "java.lang.String" -> text;
+                default -> throw new IOException("Unsupported type for annotation " + typeName);
+            };
         } catch (IllegalArgumentException iae) {
             throw new IOException("Could not parse text representation of " + typeName);
         }
-        throw new IOException("Unsupported type for annotation " + typeName);
     }
 
     private Type getType(String attribute, Element element) {