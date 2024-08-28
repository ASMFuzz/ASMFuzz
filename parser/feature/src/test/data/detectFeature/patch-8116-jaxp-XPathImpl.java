@@ -209,7 +209,7 @@ public <T> T evaluateExpression(String expression, Object item, Class<T> type)
         isSupportedClassType(type);
         try {
             XObject resultObject = eval(expression, item);
-            if (type.isAssignableFrom(XPathEvaluationResult.class)) {
+            if (type == XPathEvaluationResult.class) {
                 return getXPathResult(resultObject, type);
             } else {
                 return XPathResultImpl.getValue(resultObject, type);