@@ -41,14 +41,7 @@
  */
 public final class MetadataDescriptor {
 
-    static final class Attribute {
-        final String name;
-        final String value;
-
-        private Attribute(String name, String value) {
-            this.name = name;
-            this.value = value;
-        }
+    record Attribute(String name, String value) {
     }
 
     static final class Element {