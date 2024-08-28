@@ -227,7 +227,7 @@ public class MLet extends java.net.URLClassLoader
       */
      @SuppressWarnings("serial") // Type of field is not Serializable
      private Map<String,Class<?>> primitiveClasses =
-         new HashMap<String,Class<?>>(8) ;
+         HashMap.newHashMap(8) ;
      {
          primitiveClasses.put(Boolean.TYPE.toString(), Boolean.class);
          primitiveClasses.put(Character.TYPE.toString(), Character.class);