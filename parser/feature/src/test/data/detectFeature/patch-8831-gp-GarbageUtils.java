@@ -50,7 +50,7 @@ public final class GarbageUtils {
         public static enum OOM_TYPE {
             ANY (),
             HEAP("Java heap space"),
-            METASPACE("Metaspace", "Compressed class space");
+            METASPACE("Metaspace");
 
             private final String[] expectedStrings;
             OOM_TYPE(String... expectedStrings) {