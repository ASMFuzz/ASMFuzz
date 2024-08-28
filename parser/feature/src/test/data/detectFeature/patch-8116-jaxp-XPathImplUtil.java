@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2015, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -212,14 +212,14 @@ <T> T getXPathResult(XObject resultObject, Class<T> type)
      */
     <T> void isSupportedClassType(Class<T> type) {
         requireNonNull(type, "The class type");
-        if (type.isAssignableFrom(Boolean.class) ||
-                type.isAssignableFrom(Double.class) ||
-                type.isAssignableFrom(Integer.class) ||
-                type.isAssignableFrom(Long.class) ||
-                type.isAssignableFrom(String.class) ||
-                type.isAssignableFrom(XPathNodes.class) ||
-                type.isAssignableFrom(Node.class) ||
-                type.isAssignableFrom(XPathEvaluationResult.class)) {
+        if (type == Boolean.class ||
+                type == Double.class ||
+                type == Integer.class ||
+                type == Long.class ||
+                type == String.class ||
+                type == XPathNodes.class ||
+                type == Node.class ||
+                type == XPathEvaluationResult.class) {
             return;
         }
         String fmsg = XSLMessages.createXPATHMessage(