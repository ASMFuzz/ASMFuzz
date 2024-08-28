@@ -74,9 +74,9 @@ static boolean containsADRP(String input) {
             }
             int dump = (int)Long.parseLong(match, 16);
             int encoding = Integer.reverseBytes(dump);
-            if (isADRP(encoding)) {
-                return true;
-            }
+            // Check the first instruction only. The raw pointer can be confused with the encoded adrp instruction:
+            // emit_exception_handler() = far_call() + should_not_reach_here() = ADRP + ADD + BLR + DCPS1 + raw_pointer
+            return isADRP(encoding);
         }
         return false;
     }