@@ -406,6 +406,16 @@ bool LibraryCallKit::inline_vector_nary_operation(int n) {
   BasicType elem_bt = elem_type->basic_type();
   int num_elem = vlen->get_con();
   int opc = VectorSupport::vop2ideal(opr->get_con(), elem_bt);
+
+  // For byte elements, unsigned right shift is equal to signed right shift if the shift_cnt <= 24.
+  // For short elements, unsigned right shift is equal to signed right shift if the shift_cnt <= 16.
+  // To support unsigned right shift of negative byte/short elements, we replace the unsigned right
+  // shift operation with the signed right shift operation. This is fine because for vector api, the
+  // shift count will be masked to shift_cnt <= 7 for bytes and shift_cnt <= 15 for shorts.
+  if (opc == Op_URShiftB || opc == Op_URShiftS) {
+    opc = Op_RShiftI;
+  }
+
   int sopc = VectorNode::opcode(opc, elem_bt);
   if ((opc != Op_CallLeafVector) && (sopc == 0)) {
     if (C->print_intrinsics()) {
@@ -2246,6 +2256,15 @@ bool LibraryCallKit::inline_vector_broadcast_int() {
   BasicType elem_bt = elem_type->basic_type();
   int opc = VectorSupport::vop2ideal(opr->get_con(), elem_bt);
 
+  // For byte elements, unsigned right shift is equal to signed right shift if the shift_cnt <= 24.
+  // For short elements, unsigned right shift is equal to signed right shift if the shift_cnt <= 16.
+  // To support unsigned right shift of negative byte/short elements, we replace the unsigned right
+  // shift operation with the signed right shift operation. This is fine because for vector api, the
+  // shift count will be masked to shift_cnt <= 7 for bytes and shift_cnt <= 15 for shorts.
+  if (opc == Op_URShiftB || opc == Op_URShiftS) {
+    opc = Op_RShiftI;
+  }
+
   bool is_shift  = VectorNode::is_shift_opcode(opc);
   bool is_rotate = VectorNode::is_rotate_opcode(opc);
 