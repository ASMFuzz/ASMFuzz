@@ -75,7 +75,7 @@ public JdkLDAP() {
 
         final Provider p = this;
         PrivilegedAction<Void> pa = () -> {
-            HashMap<String, String> attrs = new HashMap<>(2);
+            HashMap<String, String> attrs = HashMap.newHashMap(2);
             attrs.put("LDAPSchema", "RFC2587");
             attrs.put("ImplementedIn", "Software");
 