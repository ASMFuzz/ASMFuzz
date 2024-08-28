@@ -1131,7 +1131,7 @@ bool LibraryCallKit::inline_vector_mem_operation(bool is_store) {
 //  S extends VectorSpecies<E>,
 //  M extends VectorMask<E>>
 // V loadMasked(Class<? extends V> vectorClass, Class<M> maskClass, Class<E> elementType,
-//              int length, Object base, long offset, M m,
+//              int length, Object base, long offset, M m, int offsetInRange,
 //              C container, long index, S s,  // Arguments for default implementation
 //              LoadVectorMaskedOperation<C, V, S, M> defaultImpl) {
 //
@@ -1216,24 +1216,47 @@ bool LibraryCallKit::inline_vector_mem_masked_operation(bool is_store) {
 
   int mem_num_elem = using_byte_array ? num_elem * type2aelembytes(elem_bt) : num_elem;
   BasicType mem_elem_bt = using_byte_array ? T_BYTE : elem_bt;
-  bool use_predicate = arch_supports_vector(is_store ? Op_StoreVectorMasked : Op_LoadVectorMasked,
-                                            mem_num_elem, mem_elem_bt,
-                                            (VectorMaskUseType) (VecMaskUseLoad | VecMaskUsePred));
-  // Masked vector store operation needs the architecture predicate feature. We need to check
-  // whether the predicated vector operation is supported by backend.
-  if (is_store && !use_predicate) {
-    if (C->print_intrinsics()) {
-      tty->print_cr("  ** not supported: op=storeMasked vlen=%d etype=%s using_byte_array=%d",
-                    num_elem, type2name(elem_bt), using_byte_array ? 1 : 0);
+  bool supports_predicate = arch_supports_vector(is_store ? Op_StoreVectorMasked : Op_LoadVectorMasked,
+                                                mem_num_elem, mem_elem_bt,
+                                                (VectorMaskUseType) (VecMaskUseLoad | VecMaskUsePred));
+
+  // If current arch does not support the predicated operations, we have to bail
+  // out when current case uses the predicate feature.
+  if (!supports_predicate) {
+    bool needs_predicate = false;
+    if (is_store) {
+      // Masked vector store always uses the predicated store.
+      needs_predicate = true;
+    } else {
+      // Masked vector load with IOOBE always uses the predicated load.
+      const TypeInt* offset_in_range = gvn().type(argument(8))->isa_int();
+      if (!offset_in_range->is_con()) {
+        if (C->print_intrinsics()) {
+          tty->print_cr("  ** missing constant: offsetInRange=%s",
+                        NodeClassNames[argument(8)->Opcode()]);
+        }
+        set_map(old_map);
+        set_sp(old_sp);
+        return false;
+      }
+      needs_predicate = (offset_in_range->get_con() == 0);
+    }
+
+    if (needs_predicate) {
+      if (C->print_intrinsics()) {
+        tty->print_cr("  ** not supported: op=%s vlen=%d etype=%s using_byte_array=%d",
+                      is_store ? "storeMasked" : "loadMasked",
+                      num_elem, type2name(elem_bt), using_byte_array ? 1 : 0);
+      }
+      set_map(old_map);
+      set_sp(old_sp);
+      return false;
     }
-    set_map(old_map);
-    set_sp(old_sp);
-    return false;
   }
 
   // This only happens for masked vector load. If predicate is not supported, then check whether
   // the normal vector load and blend operations are supported by backend.
-  if (!use_predicate && (!arch_supports_vector(Op_LoadVector, mem_num_elem, mem_elem_bt, VecMaskNotUsed) ||
+  if (!supports_predicate && (!arch_supports_vector(Op_LoadVector, mem_num_elem, mem_elem_bt, VecMaskNotUsed) ||
       !arch_supports_vector(Op_VectorBlend, mem_num_elem, mem_elem_bt, VecMaskUseLoad))) {
     if (C->print_intrinsics()) {
       tty->print_cr("  ** not supported: op=loadMasked vlen=%d etype=%s using_byte_array=%d",
@@ -1330,7 +1353,7 @@ bool LibraryCallKit::inline_vector_mem_masked_operation(bool is_store) {
       mask = gvn().transform(new VectorReinterpretNode(mask, from_mask_type, to_mask_type));
     }
 
-    if (use_predicate) {
+    if (supports_predicate) {
       // Generate masked load vector node if predicate feature is supported.
       const TypeVect* vt = TypeVect::make(mem_elem_bt, mem_num_elem);
       vload = gvn().transform(new LoadVectorMaskedNode(control(), memory(addr), addr, addr_type, vt, mask));