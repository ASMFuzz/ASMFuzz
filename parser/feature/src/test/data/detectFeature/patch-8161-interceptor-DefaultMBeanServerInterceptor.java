@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -735,9 +735,7 @@ public void setAttribute(ObjectName name, Attribute attribute)
 
         try {
             instance.setAttribute(attribute);
-        } catch (AttributeNotFoundException e) {
-            throw e;
-        } catch (InvalidAttributeValueException e) {
+        } catch (AttributeNotFoundException | InvalidAttributeValueException e) {
             throw e;
         } catch (Throwable t) {
             rethrowMaybeMBeanException(t);
@@ -821,11 +819,7 @@ private static void rethrow(Throwable t)
             throws ReflectionException {
         try {
             throw t;
-        } catch (ReflectionException e) {
-            throw e;
-        } catch (RuntimeOperationsException e) {
-            throw e;
-        } catch (RuntimeErrorException e) {
+        } catch (ReflectionException | RuntimeOperationsException | RuntimeErrorException e) {
             throw e;
         } catch (RuntimeException e) {
             throw new RuntimeMBeanException(e, e.toString());
@@ -1356,9 +1350,7 @@ public MBeanInfo getMBeanInfo(ObjectName name)
         final MBeanInfo mbi;
         try {
             mbi = moi.getMBeanInfo();
-        } catch (RuntimeMBeanException e) {
-            throw e;
-        } catch (RuntimeErrorException e) {
+        } catch (RuntimeMBeanException | RuntimeErrorException e) {
             throw e;
         } catch (RuntimeException e) {
             throw new RuntimeMBeanException(e,