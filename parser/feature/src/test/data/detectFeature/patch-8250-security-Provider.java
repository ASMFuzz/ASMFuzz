@@ -1605,7 +1605,7 @@ private static void addEngine(String name, boolean sp, String paramName) {
                             "java.lang.Object");
     }
 
-    // get the "standard" (mixed-case) engine name for arbitary case engine name
+    // get the "standard" (mixed-case) engine name for arbitrary case engine name
     // if there is no known engine by that name, return s
     private static String getEngineName(String s) {
         // try original case first, usually correct