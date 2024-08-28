@@ -1689,7 +1689,9 @@ void PhaseIterGVN::remove_speculative_types()  {
 bool PhaseIterGVN::no_dependent_zero_check(Node* n) const {
   switch (n->Opcode()) {
     case Op_DivI:
-    case Op_ModI: {
+    case Op_NoOvfDivI:
+    case Op_ModI:
+    case Op_NoOvfModI: {
       // Type of divisor includes 0?
       if (type(n->in(2)) == Type::TOP) {
         // 'n' is dead. Treat as if zero check is still there to avoid any further optimizations.
@@ -1699,7 +1701,9 @@ bool PhaseIterGVN::no_dependent_zero_check(Node* n) const {
       return (type_divisor->_hi < 0 || type_divisor->_lo > 0);
     }
     case Op_DivL:
-    case Op_ModL: {
+    case Op_NoOvfDivL:
+    case Op_ModL:
+    case Op_NoOvfModL: {
       // Type of divisor includes 0?
       if (type(n->in(2)) == Type::TOP) {
         // 'n' is dead. Treat as if zero check is still there to avoid any further optimizations.