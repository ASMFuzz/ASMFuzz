@@ -1310,14 +1310,16 @@ public static Type primaryPatternType(JCTree pat) {
         return switch (pat.getTag()) {
             case BINDINGPATTERN -> pat.type;
             case PARENTHESIZEDPATTERN -> primaryPatternType(((JCParenthesizedPattern) pat).pattern);
+            case RECORDPATTERN -> ((JCRecordPattern) pat).type;
             default -> throw new AssertionError();
         };
     }
 
-    public static JCBindingPattern primaryPatternTree(JCTree pat) {
+    public static JCTree primaryPatternTypeTree(JCTree pat) {
         return switch (pat.getTag()) {
-            case BINDINGPATTERN -> (JCBindingPattern) pat;
-            case PARENTHESIZEDPATTERN -> primaryPatternTree(((JCParenthesizedPattern) pat).pattern);
+            case BINDINGPATTERN -> ((JCBindingPattern) pat).var.vartype;
+            case PARENTHESIZEDPATTERN -> primaryPatternTypeTree(((JCParenthesizedPattern) pat).pattern);
+            case RECORDPATTERN -> ((JCRecordPattern) pat).deconstructor;
             default -> throw new AssertionError();
         };
     }