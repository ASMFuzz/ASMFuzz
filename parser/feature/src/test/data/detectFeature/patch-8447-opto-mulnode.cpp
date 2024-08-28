@@ -1759,6 +1759,10 @@ bool MulNode::AndIL_shift_and_mask_is_always_zero(PhaseGVN* phase, Node* shift,
   if (mask == NULL || shift == NULL) {
     return false;
   }
+  shift = shift->uncast();
+  if (shift == NULL) {
+    return false;
+  }
   const TypeInteger* mask_t = phase->type(mask)->isa_integer(bt);
   const TypeInteger* shift_t = phase->type(shift)->isa_integer(bt);
   if (mask_t == NULL || shift_t == NULL) {
@@ -1771,6 +1775,10 @@ bool MulNode::AndIL_shift_and_mask_is_always_zero(PhaseGVN* phase, Node* shift,
     if (val == NULL) {
       return false;
     }
+    val = val->uncast();
+    if (val == NULL) {
+      return false;
+    }
     if (val->Opcode() == Op_LShiftI) {
       shift_bt = T_INT;
       shift = val;