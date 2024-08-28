@@ -162,10 +162,11 @@ void MethodLiveness::init_basic_blocks() {
       case Bytecodes::_ifnull:
       case Bytecodes::_ifnonnull:
         // Two way branch.  Set predecessors at each destination.
-        dest = _block_map->at(bytes.next_bci());
-        assert(dest != NULL, "must be a block immediately following this one.");
-        dest->add_normal_predecessor(current_block);
-
+        if (bytes.next_bci() < method_len) {
+          dest = _block_map->at(bytes.next_bci());
+          assert(dest != NULL, "must be a block immediately following this one.");
+          dest->add_normal_predecessor(current_block);
+        }
         dest = _block_map->at(bytes.get_dest());
         assert(dest != NULL, "branch destination must start a block.");
         dest->add_normal_predecessor(current_block);