@@ -224,8 +224,10 @@ void BlockListBuilder::handle_exceptions(BlockBegin* current, int cur_bci) {
 }
 
 void BlockListBuilder::handle_jsr(BlockBegin* current, int sr_bci, int next_bci) {
-  // start a new block after jsr-bytecode and link this block into cfg
-  make_block_at(next_bci, current);
+  if (next_bci < method()->code_size()) {
+    // start a new block after jsr-bytecode and link this block into cfg
+    make_block_at(next_bci, current);
+  }
 
   // start a new block at the subroutine entry at mark it with special flag
   BlockBegin* sr_block = make_block_at(sr_bci, current);
@@ -245,6 +247,8 @@ void BlockListBuilder::set_leaders() {
   // branch target and a modification of the successor lists.
   const BitMap& bci_block_start = method()->bci_block_start();
 
+  int end_bci = method()->code_size();
+
   ciBytecodeStream s(method());
   while (s.next() != ciBytecodeStream::EOBC()) {
     int cur_bci = s.cur_bci();
@@ -315,7 +319,9 @@ void BlockListBuilder::set_leaders() {
       case Bytecodes::_if_acmpne: // fall through
       case Bytecodes::_ifnull:    // fall through
       case Bytecodes::_ifnonnull:
-        make_block_at(s.next_bci(), current);
+        if (s.next_bci() < end_bci) {
+          make_block_at(s.next_bci(), current);
+        }
         make_block_at(s.get_dest(), current);
         current = NULL;
         break;