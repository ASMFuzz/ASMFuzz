@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2015, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -142,19 +142,19 @@ private void getResult(XObject resultObject) throws TransformerException {
      */
     static <T> T getValue(XObject resultObject, Class<T> type) throws TransformerException {
         Objects.requireNonNull(type);
-        if (type.isAssignableFrom(XPathEvaluationResult.class)) {
+        if (type == XPathEvaluationResult.class) {
             return type.cast(new XPathResultImpl<T>(resultObject, type));
         }
         int resultType = classToInternalType(type);
         switch (resultType) {
             case XObject.CLASS_BOOLEAN:
                 return type.cast(resultObject.bool());
             case XObject.CLASS_NUMBER:
-                if (Double.class.isAssignableFrom(type)) {
+                if (Double.class == type) {
                     return type.cast(resultObject.num());
-                } else if (Integer.class.isAssignableFrom(type)) {
+                } else if (Integer.class == type) {
                     return type.cast((int)resultObject.num());
-                } else if (Long.class.isAssignableFrom(type)) {
+                } else if (Long.class == type) {
                     return type.cast((long)resultObject.num());
                 }
                 /*
@@ -185,15 +185,15 @@ static <T> T getValue(XObject resultObject, Class<T> type) throws TransformerExc
      * @return the internal XObject type.
      */
     static <T> int classToInternalType(Class<T> type) {
-        if (type.isAssignableFrom(Boolean.class)) {
+        if (type == Boolean.class) {
             return XObject.CLASS_BOOLEAN;
         } else if (Number.class.isAssignableFrom(type)) {
             return XObject.CLASS_NUMBER;
-        } else if (type.isAssignableFrom(String.class)) {
+        } else if (type == String.class) {
             return XObject.CLASS_STRING;
-        } else if (type.isAssignableFrom(XPathNodes.class)) {
+        } else if (type == XPathNodes.class) {
             return XObject.CLASS_NODESET;
-        } else if (type.isAssignableFrom(Node.class)) {
+        } else if (type == Node.class) {
             return XObject.CLASS_RTREEFRAG;
         }
         return XObject.CLASS_NULL;