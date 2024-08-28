@@ -1648,7 +1648,7 @@ private static ObjectStreamField[] getDeclaredSerialFields(Class<?> cl)
 
         ObjectStreamField[] boundFields =
             new ObjectStreamField[serialPersistentFields.length];
-        Set<String> fieldNames = new HashSet<>(serialPersistentFields.length);
+        Set<String> fieldNames = HashSet.newHashSet(serialPersistentFields.length);
 
         for (int i = 0; i < serialPersistentFields.length; i++) {
             ObjectStreamField spf = serialPersistentFields[i];