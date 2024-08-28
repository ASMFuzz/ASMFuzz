@@ -104,7 +104,7 @@ static void genClass0(InputStream isB2C,
             boolean[] b2cBmp = new boolean[0x100];
             boolean[] b2cSupp = new boolean[0x100];
             // pua should be in range of e000-f8ff. Expand
-            // it to 0xf93b becase the hkscs2001.c2b has
+            // it to 0xf93b because the hkscs2001.c2b has
             // the f920-f93b filled
             //char[] pua = new char[0xF8FF - 0xE000 + 1];
             char[] pua = new char[0xF93b - 0xE000 + 1];