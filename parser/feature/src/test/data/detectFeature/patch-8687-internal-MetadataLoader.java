@@ -111,7 +111,7 @@ public TypeElement(DataInputStream dis) throws IOException {
     }
 
     // <Field>
-    private static class FieldElement {
+    private static final class FieldElement {
         private final String name;
         private final String label;
         private final String description;