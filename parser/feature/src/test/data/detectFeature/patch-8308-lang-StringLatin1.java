@@ -417,7 +417,7 @@ public static boolean regionMatchesCI_UTF16(byte[] value, int toffset,
             if (u1 == u2) {
                 continue;
             }
-            if (Character.toLowerCase(u1) == Character.toLowerCase(u2)) {
+            if (CharacterDataLatin1.instance.toLowerCase(u1) == Character.toLowerCase(u2)) {
                 continue;
             }
             return false;