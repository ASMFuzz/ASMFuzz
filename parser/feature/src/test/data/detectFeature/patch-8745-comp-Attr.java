@@ -1798,6 +1798,10 @@ private void handleSwitch(JCTree switchTree,
                                 bodyEnv.info.scope.leave();
                             }
                             matchBindings = matchBindingsComputer.caseGuard(c, afterPattern, matchBindings);
+
+                            if (TreeInfo.isBooleanWithValue(guard, 0)) {
+                                log.error(guard.pos(), Errors.GuardHasConstantExpressionFalse);
+                            }
                         }
                         boolean unguarded = TreeInfo.unguardedCaseLabel(pat);
                         boolean unconditional =