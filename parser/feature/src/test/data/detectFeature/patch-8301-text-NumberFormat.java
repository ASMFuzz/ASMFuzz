@@ -1239,7 +1239,7 @@ public static class Field extends Format.Field {
         private static final long serialVersionUID = 7494728892700160890L;
 
         // table of all instances in this class, used by readResolve
-        private static final Map<String, Field> instanceMap = new HashMap<>(11);
+        private static final Map<String, Field> instanceMap = HashMap.newHashMap(13);
 
         /**
          * Creates a Field instance with the specified