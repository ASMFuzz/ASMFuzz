@@ -599,7 +599,7 @@ public Map<ObjectName, MBeanInfo> getMBeans(String domain)
         }
         Set<ObjectName> mbeans = server.queryNames(name, null);
         Map<ObjectName,MBeanInfo> result =
-            new HashMap<ObjectName,MBeanInfo>(mbeans.size());
+            HashMap.newHashMap(mbeans.size());
         Iterator<ObjectName> iterator = mbeans.iterator();
         while (iterator.hasNext()) {
             Object object = iterator.next();