@@ -97,7 +97,7 @@ public static class Attribute implements Serializable {
         private String name;
 
         // table of all instances in this class, used by readResolve
-        private static final Map<String, Attribute> instanceMap = new HashMap<>(7);
+        private static final Map<String, Attribute> instanceMap = HashMap.newHashMap(7);
 
         /**
          * Constructs an {@code Attribute} with the given name.