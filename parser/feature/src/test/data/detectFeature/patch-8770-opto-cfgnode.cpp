@@ -2165,7 +2165,7 @@ Node *PhiNode::Ideal(PhaseGVN *phase, bool can_reshape) {
           doit = false;
           break;
         }
-        if (in(i)->in(AddPNode::Offset) != base) {
+        if (in(i)->in(AddPNode::Base) != base) {
           base = NULL;
         }
         if (in(i)->in(AddPNode::Offset) != offset) {