@@ -326,25 +326,27 @@ void PhaseCFG::implicit_null_check(Block* block, Node *proj, Node *val, int allo
     Block *mb = get_block_for_node(mach);
     // Hoisting stores requires more checks for the anti-dependence case.
     // Give up hoisting if we have to move the store past any load.
-    if( was_store ) {
-      Block *b = mb;            // Start searching here for a local load
-      // mach use (faulting) trying to hoist
-      // n might be blocker to hoisting
-      while( b != block ) {
-        uint k;
-        for( k = 1; k < b->number_of_nodes(); k++ ) {
-          Node *n = b->get_node(k);
-          if( n->needs_anti_dependence_check() &&
-              n->in(LoadNode::Memory) == mach->in(StoreNode::Memory) )
-            break;              // Found anti-dependent load
-        }
-        if( k < b->number_of_nodes() )
-          break;                // Found anti-dependent load
-        // Make sure control does not do a merge (would have to check allpaths)
-        if( b->num_preds() != 2 ) break;
-        b = get_block_for_node(b->pred(1)); // Move up to predecessor block
-      }
-      if( b != block ) continue;
+    if (was_store) {
+       // Make sure control does not do a merge (would have to check allpaths)
+       if (mb->num_preds() != 2) {
+         continue;
+       }
+       // mach is a store, hence block is the immediate dominator of mb.
+       // Due to the null-check shape of block (where its successors cannot re-join),
+       // block must be the direct predecessor of mb.
+       assert(get_block_for_node(mb->pred(1)) == block, "Unexpected predecessor block");
+       uint k;
+       uint num_nodes = mb->number_of_nodes();
+       for (k = 1; k < num_nodes; k++) {
+         Node *n = mb->get_node(k);
+         if (n->needs_anti_dependence_check() &&
+             n->in(LoadNode::Memory) == mach->in(StoreNode::Memory)) {
+           break;              // Found anti-dependent load
+         }
+       }
+       if (k < num_nodes) {
+         continue;             // Found anti-dependent load
+       }
     }
 
     // Make sure this memory op is not already being used for a NullCheck