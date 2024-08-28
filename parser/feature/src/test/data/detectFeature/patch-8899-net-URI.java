@@ -2106,7 +2106,7 @@ private String toString(String scheme,
     // -- Normalization, resolution, and relativization --
 
     // RFC2396 5.2 (6)
-    private static String resolvePath(String base, String child)
+    private static String resolvePath(String base, String child, boolean absolute)
     {
         int i = base.lastIndexOf('/');
         int cn = child.length();
@@ -2117,12 +2117,13 @@ private static String resolvePath(String base, String child)
             if (i >= 0)
                 path = base.substring(0, i + 1);
         } else {
-            // 5.2 (6a)
-            if (i >= 0)
+            // 5.2 (6a-b)
+            if (i >= 0 || !absolute) {
                 path = base.substring(0, i + 1).concat(child);
-            // 5.2 (6b)
-            else
-                path = child;
+            } else {
+                path = "/".concat(child);
+            }
+
         }
 
         // 5.2 (6c-f)
@@ -2183,7 +2184,7 @@ private static URI resolve(URI base, URI child) {
                 ru.path = child.path;
             } else {
                 // 5.2 (6): Resolve relative path
-                ru.path = resolvePath(base.path, cp);
+                ru.path = resolvePath(base.path, cp, base.isAbsolute());
             }
         } else {
             ru.authority = child.authority;