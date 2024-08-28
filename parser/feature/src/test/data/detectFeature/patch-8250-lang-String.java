@@ -3256,7 +3256,7 @@ static String join(String prefix, String suffix, String delimiter, String[] elem
             icoder |= delimiter.coder();
         }
         // assert len > 0L; // max: (long) Integer.MAX_VALUE << 32
-        // following loop wil add max: (long) Integer.MAX_VALUE * Integer.MAX_VALUE to len
+        // following loop will add max: (long) Integer.MAX_VALUE * Integer.MAX_VALUE to len
         // so len can overflow at most once
         for (int i = 0; i < size; i++) {
             var el = elements[i];