@@ -3751,6 +3751,22 @@ void checkDivZero(final DiagnosticPosition pos, Symbol operator, Type operand) {
         }
     }
 
+    /**
+     *  Check for possible loss of precission
+     *  @param pos           Position for error reporting.
+     *  @param found    The computed type of the tree
+     *  @param req  The computed type of the tree
+     */
+    void checkLossOfPrecision(final DiagnosticPosition pos, Type found, Type req) {
+        if (found.isNumeric() && req.isNumeric() && !types.isAssignable(found, req)) {
+            deferredLintHandler.report(() -> {
+                if (lint.isEnabled(LintCategory.LOSSY_CONVERSIONS))
+                    log.warning(LintCategory.LOSSY_CONVERSIONS,
+                            pos, Warnings.PossibleLossOfPrecision(found, req));
+            });
+        }
+    }
+
     /**
      * Check for empty statements after if
      */