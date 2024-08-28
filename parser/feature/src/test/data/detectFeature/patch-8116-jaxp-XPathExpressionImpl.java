@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2017, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  */
 /*
  * Licensed to the Apache Software Foundation (ASF) under one or more
@@ -37,6 +37,7 @@
  * The XPathExpression interface encapsulates a (compiled) XPath expression.
  *
  * @author  Ramesh Mandava
+ * @LastModified: Apr 2022
  */
 public class XPathExpressionImpl extends XPathImplUtil implements XPathExpression {
 
@@ -136,7 +137,7 @@ public <T>T evaluateExpression(Object item, Class<T> type)
 
         try {
             XObject resultObject = eval(item, xpath);
-            if (type.isAssignableFrom(XPathEvaluationResult.class)) {
+            if (type == XPathEvaluationResult.class) {
                 return getXPathResult(resultObject, type);
             } else {
                 return XPathResultImpl.getValue(resultObject, type);