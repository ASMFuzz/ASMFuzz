@@ -900,6 +900,10 @@ public void visitSwitchExpression(JCSwitchExpression tree) {
     public void visitBindingPattern(JCBindingPattern patt) {
         try {
             printExpr(patt.var);
+            if (patt.guard != null) {
+                print(" when ");
+                printExpr(patt.guard);
+            }
         } catch (IOException e) {
             throw new UncheckedIOException(e);
         }
@@ -911,17 +915,10 @@ public void visitParenthesizedPattern(JCParenthesizedPattern patt) {
             print("(");
             printExpr(patt.pattern);
             print(")");
-        } catch (IOException e) {
-            throw new UncheckedIOException(e);
-        }
-    }
-
-    @Override
-    public void visitGuardPattern(JCGuardPattern patt) {
-        try {
-            printExpr(patt.patt);
-            print(" && ");
-            printExpr(patt.expr);
+            if (patt.guard != null) {
+                print(" when ");
+                printExpr(patt.guard);
+            }
         } catch (IOException e) {
             throw new UncheckedIOException(e);
         }