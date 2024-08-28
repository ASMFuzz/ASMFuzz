@@ -114,9 +114,9 @@ public Method[] run() {
                 }
             });
 
-        memberTypes = new HashMap<>(methods.length+1, 1.0f);
+        memberTypes = HashMap.newHashMap(methods.length);
         memberDefaults = new HashMap<>(0);
-        members = new HashMap<>(methods.length+1, 1.0f);
+        members = HashMap.newHashMap(methods.length);
 
         for (Method method : methods) {
             if (Modifier.isPublic(method.getModifiers()) &&