@@ -2150,52 +2150,39 @@ void PhasePeephole::do_transform() {
     Block* block = _cfg.get_block(block_number);
     bool block_not_printed = true;
 
-    // and each instruction within a block
-    uint end_index = block->number_of_nodes();
-    // block->end_idx() not valid after PhaseRegAlloc
-    for( uint instruction_index = 1; instruction_index < end_index; ++instruction_index ) {
-      Node     *n = block->get_node(instruction_index);
-      if( n->is_Mach() ) {
-        MachNode *m = n->as_Mach();
-        int deleted_count = 0;
-        // check for peephole opportunities
-        MachNode *m2 = m->peephole(block, instruction_index, _regalloc, deleted_count);
-        if( m2 != NULL ) {
+    for (bool progress = true; progress;) {
+      progress = false;
+      // block->end_idx() not valid after PhaseRegAlloc
+      uint end_index = block->number_of_nodes();
+      for( uint instruction_index = end_index - 1; instruction_index > 0; --instruction_index ) {
+        Node     *n = block->get_node(instruction_index);
+        if( n->is_Mach() ) {
+          MachNode *m = n->as_Mach();
+          // check for peephole opportunities
+          int result = m->peephole(block, instruction_index, &_cfg, _regalloc);
+          if( result != -1 ) {
 #ifndef PRODUCT
-          if( PrintOptoPeephole ) {
-            // Print method, first time only
-            if( C->method() && method_name_not_printed ) {
-              C->method()->print_short_name(); tty->cr();
-              method_name_not_printed = false;
-            }
-            // Print this block
-            if( Verbose && block_not_printed) {
-              tty->print_cr("in block");
-              block->dump();
-              block_not_printed = false;
-            }
-            // Print instructions being deleted
-            for( int i = (deleted_count - 1); i >= 0; --i ) {
-              block->get_node(instruction_index-i)->as_Mach()->format(_regalloc); tty->cr();
+            if( PrintOptoPeephole ) {
+              // Print method, first time only
+              if( C->method() && method_name_not_printed ) {
+                C->method()->print_short_name(); tty->cr();
+                method_name_not_printed = false;
+              }
+              // Print this block
+              if( Verbose && block_not_printed) {
+                tty->print_cr("in block");
+                block->dump();
+                block_not_printed = false;
+              }
+              // Print the peephole number
+              tty->print_cr("peephole number: %d", result);
             }
-            tty->print_cr("replaced with");
-            // Print new instruction
-            m2->format(_regalloc);
-            tty->print("\n\n");
-          }
+            inc_peepholes();
 #endif
-          // Remove old nodes from basic block and update instruction_index
-          // (old nodes still exist and may have edges pointing to them
-          //  as register allocation info is stored in the allocator using
-          //  the node index to live range mappings.)
-          uint safe_instruction_index = (instruction_index - deleted_count);
-          for( ; (instruction_index > safe_instruction_index); --instruction_index ) {
-            block->remove_node( instruction_index );
+            // Set progress, start again
+            progress = true;
+            break;
           }
-          // install new node after safe_instruction_index
-          block->insert_node(m2, safe_instruction_index + 1);
-          end_index = block->number_of_nodes() - 1; // Recompute new block size
-          NOT_PRODUCT( inc_peepholes(); )
         }
       }
     }