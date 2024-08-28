@@ -65,7 +65,8 @@ Node* PhaseIdealLoop::split_thru_phi(Node* n, Node* region, int policy) {
   // phi p of a trip-counted (integer) loop whose inputs could be zero (include zero in their type range). p could have a more precise type
   // range that does not necessarily include all values of its inputs. Since each of these inputs will be a divisor of the newly cloned nodes
   // of 'n', we need to bail out of one of these divisors could be zero (zero in its type range).
-  if ((n->Opcode() == Op_DivI || n->Opcode() == Op_ModI) && n->in(0) == NULL
+  if ((n->Opcode() == Op_DivI || n->Opcode() == Op_NoOvfDivI || n->Opcode() == Op_ModI || n->Opcode() == Op_NoOvfModI)
+      && n->in(0) == NULL
       && region->is_CountedLoop() && n->in(2) == region->as_CountedLoop()->phi()) {
     Node* phi = region->as_CountedLoop()->phi();
     for (uint i = 1; i < phi->req(); i++) {