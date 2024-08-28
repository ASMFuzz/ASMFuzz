@@ -288,7 +288,7 @@ static String getString(Object key, int len) {
     }
 
 
-    static HashMap strcache = new HashMap(tscripts.length);
+    static HashMap strcache = new HashMap((int) (Math.ceil(tscripts.length / 0.75)));
     private static String getSimpleString(Object key) {
         String s = (String)strcache.get(key);
         if (s == null) {