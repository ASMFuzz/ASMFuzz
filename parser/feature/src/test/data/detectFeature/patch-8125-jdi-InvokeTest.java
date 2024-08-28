@@ -399,7 +399,7 @@ Method gettoStringMethod() {
             return null;
         }
 
-        // Then find toSting
+        // Then find toString
         List meths = objectMirror.methods();
         iter = meths.iterator();
         while (iter.hasNext()) {