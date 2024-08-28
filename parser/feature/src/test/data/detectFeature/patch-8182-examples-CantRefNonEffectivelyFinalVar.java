@@ -48,7 +48,7 @@ void test2() {
 
     void test3(Object o, int i) {
         switch (o) {
-            case String s && s.length() == i++: break;
+            case String s when s.length() == i++: break;
             default: break;
         }
     }