@@ -425,11 +425,11 @@ private Runnable doLoadAttributes(final XMBean mbean, MBeanInfo infoOrNull)
 
         final MBeanAttributeInfo[] attrsInfo = curMBeanInfo.getAttributes();
         final HashMap<String, Object> attrs =
-            new HashMap<String, Object>(attrsInfo.length);
+            HashMap.newHashMap(attrsInfo.length);
         final HashMap<String, Object> unavailableAttrs =
-            new HashMap<String, Object>(attrsInfo.length);
+            HashMap.newHashMap(attrsInfo.length);
         final HashMap<String, Object> viewableAttrs =
-            new HashMap<String, Object>(attrsInfo.length);
+            HashMap.newHashMap(attrsInfo.length);
         AttributeList list = null;
 
         try {