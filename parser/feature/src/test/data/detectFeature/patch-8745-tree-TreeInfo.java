@@ -1337,9 +1337,13 @@ public static boolean unguardedCaseLabel(JCCaseLabel cse) {
         if (guard == null) {
             return true;
         }
+        return isBooleanWithValue(guard, 1);
+    }
+
+    public static boolean isBooleanWithValue(JCExpression guard, int value) {
         var constValue = guard.type.constValue();
         return constValue != null &&
-               guard.type.hasTag(BOOLEAN) &&
-               ((int) constValue) == 1;
+                guard.type.hasTag(BOOLEAN) &&
+                ((int) constValue) == value;
     }
 }