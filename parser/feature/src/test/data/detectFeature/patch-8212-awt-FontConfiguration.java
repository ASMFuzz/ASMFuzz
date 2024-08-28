@@ -847,7 +847,7 @@ private static Vector<String> splitSequence(String sequence) {
             start = end + 1;
         }
         if (sequence.length() > start) {
-            parts.add(sequence.substring(start, sequence.length()));
+            parts.add(sequence.substring(start));
         }
         return parts;
     }