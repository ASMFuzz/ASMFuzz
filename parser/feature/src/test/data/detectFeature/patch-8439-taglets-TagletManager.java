@@ -621,6 +621,7 @@ private void initStandardTaglets() {
         allTaglets.put(factoryTaglet.getName(), factoryTaglet);
 
         addStandardTaglet(new SeeTaglet());
+        addStandardTaglet(new SpecTaglet());
 
         // Standard inline tags
         addStandardTaglet(new DocRootTaglet());