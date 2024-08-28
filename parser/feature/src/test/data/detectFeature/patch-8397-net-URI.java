@@ -864,7 +864,7 @@ public URI(String scheme, String ssp, String fragment)
 
     private static boolean validSchemeAndPath(String scheme, String path) {
         try {
-            URI u = new URI(scheme + ":" + path);
+            URI u = new URI(scheme + ':' + path);
             return scheme.equals(u.scheme) && path.equals(u.path);
         } catch (URISyntaxException e) {
             return false;
@@ -1928,7 +1928,7 @@ private static int percentNormalizedComparison(String s, String t,
                 if ((sn != tn) && testForEquality)
                     return sn - tn;
                 int val = 0;
-                int n = sn < tn ? sn : tn;
+                int n = Math.min(sn, tn);
                 for (int i = 0; i < n; ) {
                     char c = s.charAt(i);
                     char d = t.charAt(i);
@@ -2023,18 +2023,12 @@ private void appendAuthority(StringBuilder sb,
             if (authority.startsWith("[")) {
                 // authority should (but may not) contain an embedded IPv6 address
                 int end = authority.indexOf(']');
-                String doquote = authority, dontquote = "";
+                String doquote = authority;
                 if (end != -1 && authority.indexOf(':') != -1) {
                     // the authority contains an IPv6 address
-                    if (end == authority.length()) {
-                        dontquote = authority;
-                        doquote = "";
-                    } else {
-                        dontquote = authority.substring(0 , end + 1);
-                        doquote = authority.substring(end + 1);
-                    }
+                    sb.append(authority, 0, end + 1);
+                    doquote = authority.substring(end + 1);
                 }
-                sb.append(dontquote);
                 sb.append(quote(doquote,
                             L_REG_NAME | L_SERVER,
                             H_REG_NAME | H_SERVER));
@@ -2062,15 +2056,8 @@ private void appendSchemeSpecificPart(StringBuilder sb,
             if (opaquePart.startsWith("//[")) {
                 int end =  opaquePart.indexOf(']');
                 if (end != -1 && opaquePart.indexOf(':')!=-1) {
-                    String doquote, dontquote;
-                    if (end == opaquePart.length()) {
-                        dontquote = opaquePart;
-                        doquote = "";
-                    } else {
-                        dontquote = opaquePart.substring(0,end+1);
-                        doquote = opaquePart.substring(end+1);
-                    }
-                    sb.append (dontquote);
+                    String doquote = opaquePart.substring(end + 1);
+                    sb.append(opaquePart, 0, end + 1);
                     sb.append(quote(doquote, L_URIC, H_URIC));
                 }
             } else {
@@ -2119,8 +2106,7 @@ private String toString(String scheme,
     // -- Normalization, resolution, and relativization --
 
     // RFC2396 5.2 (6)
-    private static String resolvePath(String base, String child,
-                                      boolean absolute)
+    private static String resolvePath(String base, String child)
     {
         int i = base.lastIndexOf('/');
         int cn = child.length();
@@ -2131,13 +2117,12 @@ private static String resolvePath(String base, String child,
             if (i >= 0)
                 path = base.substring(0, i + 1);
         } else {
-            StringBuilder sb = new StringBuilder(base.length() + cn);
             // 5.2 (6a)
             if (i >= 0)
-                sb.append(base, 0, i + 1);
+                path = base.substring(0, i + 1).concat(child);
             // 5.2 (6b)
-            sb.append(child);
-            path = sb.toString();
+            else
+                path = child;
         }
 
         // 5.2 (6c-f)
@@ -2192,13 +2177,13 @@ private static URI resolve(URI base, URI child) {
             ru.userInfo = base.userInfo;
             ru.port = base.port;
 
-            String cp = (child.path == null) ? "" : child.path;
+            String cp = child.path;
             if (!cp.isEmpty() && cp.charAt(0) == '/') {
                 // 5.2 (5): Child path is absolute
                 ru.path = child.path;
             } else {
                 // 5.2 (6): Resolve relative path
-                ru.path = resolvePath(base.path, cp, base.isAbsolute());
+                ru.path = resolvePath(base.path, cp);
             }
         } else {
             ru.authority = child.authority;
@@ -2768,7 +2753,7 @@ private static void appendEscape(StringBuilder sb, byte b) {
     private static void appendEncoded(CharsetEncoder encoder, StringBuilder sb, char c) {
         ByteBuffer bb = null;
         try {
-            bb = encoder.encode(CharBuffer.wrap("" + c));
+            bb = encoder.encode(CharBuffer.wrap(new char[]{c}));
         } catch (CharacterCodingException x) {
             assert false;
         }
@@ -2920,7 +2905,6 @@ private static String decode(String s, boolean ignorePercentInBrackets) {
                 continue;
             }
             bb.clear();
-            int ui = i;
             for (;;) {
                 assert (n - i >= 2);
                 bb.put(decode(s.charAt(++i), s.charAt(++i)));