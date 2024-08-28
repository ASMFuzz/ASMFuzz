@@ -164,14 +164,9 @@ private static String normalize(StringBuilder sb, String path, int off) {
         int len = path.length();
         off = nextNonSlash(path, off, len);
         int start = off;
-        char lastC = 0;
         while (off < len) {
             char c = path.charAt(off);
             if (isSlash(c)) {
-                if (lastC == ' ')
-                    throw new InvalidPathException(path,
-                                                   "Trailing char <" + lastC + ">",
-                                                   off - 1);
                 sb.append(path, start, off);
                 off = nextNonSlash(path, off, len);
                 if (off != len)   //no slash at the end of normalized path
@@ -182,15 +177,10 @@ private static String normalize(StringBuilder sb, String path, int off) {
                     throw new InvalidPathException(path,
                                                    "Illegal char <" + c + ">",
                                                    off);
-                lastC = c;
                 off++;
             }
         }
         if (start != off) {
-            if (lastC == ' ')
-                throw new InvalidPathException(path,
-                                               "Trailing char <" + lastC + ">",
-                                               off - 1);
             sb.append(path, start, off);
         }
         return sb.toString();