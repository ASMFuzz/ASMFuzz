@@ -2015,7 +2015,7 @@ void adjustAliveRanges(int oldCP, int delta) {
             if (localVar != null) {
                 for (LocalVar.Range range: localVar.aliveRanges) {
                     if (range.closed() && range.start_pc + range.length >= oldCP) {
-                        range.length += delta;
+                        range.length += (char)delta;
                     }
                 }
             }