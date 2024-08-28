@@ -3941,6 +3941,7 @@ public void visitAssignop(JCAssignOp tree) {
             chk.checkCastable(tree.rhs.pos(),
                               operator.type.getReturnType(),
                               owntype);
+            chk.checkLossOfPrecision(tree.rhs.pos(), operand, owntype);
         }
         result = check(tree, owntype, KindSelector.VAL, resultInfo);
     }