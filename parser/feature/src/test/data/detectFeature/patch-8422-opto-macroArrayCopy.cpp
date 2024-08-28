@@ -1017,7 +1017,7 @@ bool PhaseMacroExpand::generate_block_arraycopy(Node** ctrl, MergeMemNode** mem,
       Node* sval = transform_later(
           LoadNode::make(_igvn, *ctrl, (*mem)->memory_at(s_alias_idx), sptr, s_adr_type,
                          TypeInt::INT, T_INT, MemNode::unordered, LoadNode::DependsOnlyOnTest,
-                         false /*unaligned*/, is_mismatched));
+                         false /*require_atomic_access*/, false /*unaligned*/, is_mismatched));
       Node* st = transform_later(
           StoreNode::make(_igvn, *ctrl, (*mem)->memory_at(d_alias_idx), dptr, adr_type,
                           sval, T_INT, MemNode::unordered));