@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2006, 2017, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2006, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -33,12 +33,13 @@
 
 
 ciBlock *ciMethodBlocks::block_containing(int bci) {
+  assert(bci >= 0 && bci < _code_size, "valid bytecode range");
   ciBlock *blk = _bci_to_block[bci];
   return blk;
 }
 
 bool ciMethodBlocks::is_block_start(int bci) {
-  assert(bci >=0 && bci < _code_size, "valid bytecode range");
+  assert(bci >= 0 && bci < _code_size, "valid bytecode range");
   ciBlock *b = _bci_to_block[bci];
   assert(b != NULL, "must have block for bytecode");
   return b->start_bci() == bci;
@@ -146,7 +147,9 @@ void ciMethodBlocks::do_analysis() {
       case Bytecodes::_ifnonnull   :
       {
         cur_block->set_control_bci(bci);
-        ciBlock *fall_through = make_block_at(s.next_bci());
+        if (s.next_bci() < limit_bci) {
+          ciBlock *fall_through = make_block_at(s.next_bci());
+        }
         int dest_bci = s.get_dest();
         ciBlock *dest = make_block_at(dest_bci);
         break;
@@ -166,7 +169,9 @@ void ciMethodBlocks::do_analysis() {
       case Bytecodes::_jsr         :
       {
         cur_block->set_control_bci(bci);
-        ciBlock *ret = make_block_at(s.next_bci());
+        if (s.next_bci() < limit_bci) {
+          ciBlock *ret = make_block_at(s.next_bci());
+        }
         int dest_bci = s.get_dest();
         ciBlock *dest = make_block_at(dest_bci);
         break;
@@ -224,7 +229,9 @@ void ciMethodBlocks::do_analysis() {
       case Bytecodes::_jsr_w       :
       {
         cur_block->set_control_bci(bci);
-        ciBlock *ret = make_block_at(s.next_bci());
+        if (s.next_bci() < limit_bci) {
+          ciBlock *ret = make_block_at(s.next_bci());
+        }
         int dest_bci = s.get_far_dest();
         ciBlock *dest = make_block_at(dest_bci);
         break;