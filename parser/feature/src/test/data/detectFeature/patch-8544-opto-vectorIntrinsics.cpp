@@ -1148,7 +1148,7 @@ bool LibraryCallKit::inline_vector_mem_operation(bool is_store) {
 //  E>
 // void storeMasked(Class<? extends V> vectorClass, Class<M> maskClass, Class<E> elementType,
 //                  int length, Object base, long offset,
-//                  V v, M m,
+//                  V v, M m, int offsetInRange,
 //                  C container, int index,  // Arguments for default implementation
 //                  StoreVectorMaskedOperation<C, V, M, E> defaultImpl) {
 //
@@ -1229,28 +1229,22 @@ bool LibraryCallKit::inline_vector_mem_masked_operation(bool is_store) {
   // If current arch does not support the predicated operations, we have to bail
   // out when current case uses the predicate feature.
   if (!supports_predicate) {
-    bool use_predicate = false;
-    if (is_store) {
-      // Masked vector store always uses the predicated store.
-      use_predicate = true;
-    } else {
-      // Masked vector load with IOOBE always uses the predicated load.
-      const TypeInt* offset_in_range = gvn().type(argument(8))->isa_int();
-      if (!offset_in_range->is_con()) {
-        if (C->print_intrinsics()) {
-          tty->print_cr("  ** missing constant: offsetInRange=%s",
-                        NodeClassNames[argument(8)->Opcode()]);
-        }
-        set_map(old_map);
-        set_sp(old_sp);
-        return false;
+    const TypeInt* offset_in_range = gvn().type(is_store ? argument(9) : argument(8))->isa_int();
+    if (!offset_in_range->is_con()) {
+      if (C->print_intrinsics()) {
+        tty->print_cr("  ** missing constant: offsetInRange=%s",
+                      is_store ? NodeClassNames[argument(9)->Opcode()]
+                               : NodeClassNames[argument(8)->Opcode()]);
       }
-      use_predicate = (offset_in_range->get_con() == 0);
+      set_map(old_map);
+      set_sp(old_sp);
+      return false;
     }
 
-    if (use_predicate) {
+    // Masked vector load/store with IOOBE always use the predicated load/store instruction.
+    if (offset_in_range->get_con() == 0) {
       if (C->print_intrinsics()) {
-        tty->print_cr("  ** not supported: op=%s vlen=%d etype=%s using_byte_array=%d",
+        tty->print_cr("  ** not supported: op=%s vlen=%d etype=%s using_byte_array=%d offset_in_range=0",
                       is_store ? "storeMasked" : "loadMasked",
                       num_elem, type2name(elem_bt), using_byte_array ? 1 : 0);
       }
@@ -1260,17 +1254,20 @@ bool LibraryCallKit::inline_vector_mem_masked_operation(bool is_store) {
     }
   }
 
-  // This only happens for masked vector load. If predicate is not supported, then check whether
-  // the normal vector load and blend operations are supported by backend.
-  if (!supports_predicate && (!arch_supports_vector(Op_LoadVector, mem_num_elem, mem_elem_bt, VecMaskNotUsed) ||
-      !arch_supports_vector(Op_VectorBlend, mem_num_elem, mem_elem_bt, VecMaskUseLoad))) {
-    if (C->print_intrinsics()) {
-      tty->print_cr("  ** not supported: op=loadMasked vlen=%d etype=%s using_byte_array=%d",
-                    num_elem, type2name(elem_bt), using_byte_array ? 1 : 0);
+  // Check whether the vector blend pattern is supported or not if predicate is not supported.
+  if (!supports_predicate) {
+    if ((is_store && !arch_supports_vector(Op_StoreVector, mem_num_elem, mem_elem_bt, VecMaskNotUsed)) ||
+        !arch_supports_vector(Op_LoadVector, mem_num_elem, mem_elem_bt, VecMaskNotUsed) ||
+        !arch_supports_vector(Op_VectorBlend, mem_num_elem, mem_elem_bt, VecMaskUseLoad)) {
+      if (C->print_intrinsics()) {
+        tty->print_cr("  ** not supported: op=%s vlen=%d etype=%s using_byte_array=%d",
+                      is_store ? "storeMasked" : "loadMasked", num_elem,
+                      type2name(elem_bt), using_byte_array ? 1 : 0);
+      }
+      set_map(old_map);
+      set_sp(old_sp);
+      return false;
     }
-    set_map(old_map);
-    set_sp(old_sp);
-    return false;
   }
 
   // Since we are using byte array, we need to double check that the vector reinterpret operation
@@ -1313,6 +1310,20 @@ bool LibraryCallKit::inline_vector_mem_masked_operation(bool is_store) {
   const TypeInstPtr* vbox_type = TypeInstPtr::make_exact(TypePtr::NotNull, vbox_klass);
   const TypeInstPtr* mbox_type = TypeInstPtr::make_exact(TypePtr::NotNull, mbox_klass);
 
+  Node* val = NULL;
+  if (is_store) {
+    val = unbox_vector(argument(7), vbox_type, elem_bt, num_elem);
+    if (val == NULL) {
+      if (C->print_intrinsics()) {
+        tty->print_cr("  ** unbox failed vector=%s",
+                      NodeClassNames[argument(7)->Opcode()]);
+      }
+      set_map(old_map);
+      set_sp(old_sp);
+      return false; // operand unboxing failed
+    }
+  }
+
   Node* mask = unbox_vector(is_store ? argument(8) : argument(7), mbox_type, elem_bt, num_elem);
   if (mask == NULL) {
     if (C->print_intrinsics()) {
@@ -1324,45 +1335,42 @@ bool LibraryCallKit::inline_vector_mem_masked_operation(bool is_store) {
     set_sp(old_sp);
     return false;
   }
+  if (using_byte_array) {
+    // Reinterpret the vector mask to byte type.
+    const TypeVect* from_mask_type = TypeVect::makemask(elem_bt, num_elem);
+    const TypeVect* to_mask_type = TypeVect::makemask(mem_elem_bt, mem_num_elem);
+    mask = gvn().transform(new VectorReinterpretNode(mask, from_mask_type, to_mask_type));
+  }
+
+  const TypeVect* vt = TypeVect::make(elem_bt, num_elem);
+  const TypeVect* mem_vt = TypeVect::make(mem_elem_bt, mem_num_elem);
 
   if (is_store) {
-    Node* val = unbox_vector(argument(7), vbox_type, elem_bt, num_elem);
-    if (val == NULL) {
-      if (C->print_intrinsics()) {
-        tty->print_cr("  ** unbox failed vector=%s",
-                      NodeClassNames[argument(7)->Opcode()]);
-      }
-      set_map(old_map);
-      set_sp(old_sp);
-      return false; // operand unboxing failed
-    }
     set_all_memory(reset_memory());
 
     if (using_byte_array) {
       // Reinterpret the incoming vector to byte vector.
-      const TypeVect* to_vect_type = TypeVect::make(mem_elem_bt, mem_num_elem);
-      val = gvn().transform(new VectorReinterpretNode(val, val->bottom_type()->is_vect(), to_vect_type));
-      // Reinterpret the vector mask to byte type.
-      const TypeVect* from_mask_type = TypeVect::makemask(elem_bt, num_elem);
-      const TypeVect* to_mask_type = TypeVect::makemask(mem_elem_bt, mem_num_elem);
-      mask = gvn().transform(new VectorReinterpretNode(mask, from_mask_type, to_mask_type));
+      val = gvn().transform(new VectorReinterpretNode(val, val->bottom_type()->is_vect(), mem_vt));
+    }
+
+    Node* vstore = NULL;
+    if (supports_predicate) {
+      // Generate masked store vector node if predicate feature is supported.
+      vstore = gvn().transform(new StoreVectorMaskedNode(control(), memory(addr), addr, val, addr_type, mask));
+    } else {
+      // Use the vector blend to implement the masked store. The biased elements are the original
+      // values in the memory.
+      Node* mem_val = gvn().transform(LoadVectorNode::make(0, control(), memory(addr), addr, addr_type, mem_num_elem, mem_elem_bt));
+      val = gvn().transform(new VectorBlendNode(mem_val, val, mask));
+      vstore = gvn().transform(new StoreVectorNode(control(), memory(addr), addr, addr_type, val));
     }
-    Node* vstore = gvn().transform(new StoreVectorMaskedNode(control(), memory(addr), addr, val, addr_type, mask));
     set_memory(vstore, addr_type);
   } else {
     Node* vload = NULL;
 
-    if (using_byte_array) {
-      // Reinterpret the vector mask to byte type.
-      const TypeVect* from_mask_type = TypeVect::makemask(elem_bt, num_elem);
-      const TypeVect* to_mask_type = TypeVect::makemask(mem_elem_bt, mem_num_elem);
-      mask = gvn().transform(new VectorReinterpretNode(mask, from_mask_type, to_mask_type));
-    }
-
     if (supports_predicate) {
       // Generate masked load vector node if predicate feature is supported.
-      const TypeVect* vt = TypeVect::make(mem_elem_bt, mem_num_elem);
-      vload = gvn().transform(new LoadVectorMaskedNode(control(), memory(addr), addr, addr_type, vt, mask));
+      vload = gvn().transform(new LoadVectorMaskedNode(control(), memory(addr), addr, addr_type, mem_vt, mask));
     } else {
       // Use the vector blend to implement the masked load vector. The biased elements are zeros.
       Node* zero = gvn().transform(gvn().zerocon(mem_elem_bt));
@@ -1372,8 +1380,7 @@ bool LibraryCallKit::inline_vector_mem_masked_operation(bool is_store) {
     }
 
     if (using_byte_array) {
-      const TypeVect* to_vect_type = TypeVect::make(elem_bt, num_elem);
-      vload = gvn().transform(new VectorReinterpretNode(vload, vload->bottom_type()->is_vect(), to_vect_type));
+      vload = gvn().transform(new VectorReinterpretNode(vload, vload->bottom_type()->is_vect(), vt));
     }
 
     Node* box = box_vector(vload, vbox_type, elem_bt, num_elem);