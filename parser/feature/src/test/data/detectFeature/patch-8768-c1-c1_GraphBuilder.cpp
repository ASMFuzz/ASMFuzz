@@ -3139,7 +3139,7 @@ BlockBegin* GraphBuilder::setup_start_block(int osr_bci, BlockBegin* std_entry,
   // necessary if std_entry is also a backward branch target because
   // then phi functions may be necessary in the header block.  It's
   // also necessary when profiling so that there's a single block that
-  // can increment the the counters.
+  // can increment the counters.
   // In addition, with range check elimination, we may need a valid block
   // that dominates all the rest to insert range predicates.
   BlockBegin* new_header_block;
@@ -3326,7 +3326,7 @@ GraphBuilder::GraphBuilder(Compilation* compilation, IRScope* scope)
       // Compiles where the root method is an intrinsic need a special
       // compilation environment because the bytecodes for the method
       // shouldn't be parsed during the compilation, only the special
-      // Intrinsic node should be emitted.  If this isn't done the the
+      // Intrinsic node should be emitted.  If this isn't done the
       // code for the inlined version will be different than the root
       // compiled version which could lead to monotonicity problems on
       // intel.
@@ -3844,7 +3844,7 @@ void GraphBuilder::fill_sync_handler(Value lock, BlockBegin* sync_handler, bool
     }
   }
 
-  // perform the throw as if at the the call site
+  // perform the throw as if at the call site
   apush(exception);
   throw_op(bci);
 