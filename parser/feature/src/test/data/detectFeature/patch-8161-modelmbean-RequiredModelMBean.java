@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -1176,9 +1176,7 @@ public Object run() {
                     try {
                         ReflectUtil.checkPackageAccess(method.getDeclaringClass());
                         return MethodUtil.invoke(method, targetObject, opArgs);
-                    } catch (InvocationTargetException e) {
-                        caughtException[0] = e;
-                    } catch (IllegalAccessException e) {
+                    } catch (InvocationTargetException | IllegalAccessException e) {
                         caughtException[0] = e;
                     }
                     return null;
@@ -1192,10 +1190,6 @@ public Object run() {
                 }
             }
             return rslt;
-        } catch (RuntimeErrorException ree) {
-            throw new RuntimeOperationsException(ree,
-                      "RuntimeException occurred in RequiredModelMBean "+
-                      "while trying to invoke operation " + opName);
         } catch (RuntimeException re) {
             throw new RuntimeOperationsException(re,
                       "RuntimeException occurred in RequiredModelMBean "+
@@ -1649,10 +1643,8 @@ public Class<?> run() {
                     "attribute value through a RequiredModelMBean");
             }
 
-        } catch (MBeanException mbe) {
-            throw mbe;
-        } catch (AttributeNotFoundException t) {
-            throw t;
+        } catch (MBeanException | AttributeNotFoundException e) {
+            throw e;
         } catch (Exception e) {
             if (tracing) {
                 MODELMBEAN_LOGGER.log(Level.TRACE,
@@ -2246,9 +2238,7 @@ boolean hasNotification(final ModelMBeanInfo info,
         try {
             if (info == null) return false;
             else return (info.getNotification(notifName)!=null);
-        } catch (MBeanException x) {
-            return false;
-        } catch (RuntimeOperationsException r) {
+        } catch (MBeanException | RuntimeOperationsException x) {
             return false;
         }
     }