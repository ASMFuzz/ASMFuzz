@@ -211,7 +211,7 @@ public Map<Field,Value> getValues(List<? extends Field> theFields) {
         if (staticFields.size() > 0) {
             map = referenceType().getValues(staticFields);
         } else {
-            map = new HashMap<Field, Value>(size);
+            map = HashMap.newHashMap(size);
         }
 
         size = instanceFields.size();