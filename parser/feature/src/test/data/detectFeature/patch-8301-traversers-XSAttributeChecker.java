@@ -145,9 +145,9 @@ public class XSAttributeChecker {
 
     // used to store the map from element name to attribute list
     // for 14 global elements
-    private static final Map<String, Container> fEleAttrsMapG = new HashMap<>(29);
+    private static final Map<String, Container> fEleAttrsMapG = HashMap.newHashMap(14);
     // for 39 local elememnts
-    private static final Map<String, Container> fEleAttrsMapL = new HashMap<>(79);
+    private static final Map<String, Container> fEleAttrsMapL = HashMap.newHashMap(39);
 
     // used to initialize fEleAttrsMap
     // step 1: all possible data types