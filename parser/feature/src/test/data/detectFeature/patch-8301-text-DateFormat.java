@@ -875,7 +875,7 @@ public static class Field extends Format.Field {
         private static final long serialVersionUID = 7441350119349544720L;
 
         // table of all instances in this class, used by readResolve
-        private static final Map<String, Field> instanceMap = new HashMap<>(18);
+        private static final Map<String, Field> instanceMap = HashMap.newHashMap(18);
         // Maps from Calendar constant (such as Calendar.ERA) to Field
         // constant (such as Field.ERA).
         private static final Field[] calendarToFieldMapping =