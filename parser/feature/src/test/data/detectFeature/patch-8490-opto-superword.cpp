@@ -3997,7 +3997,7 @@ bool SWPointer::scaled_iv_plus_offset(Node* n) {
       NOT_PRODUCT(_tracer.scaled_iv_plus_offset_5(n);)
       return true;
     }
-  } else if (opc == Op_SubI) {
+  } else if (opc == Op_SubI || opc == Op_SubL) {
     if (offset_plus_k(n->in(2), true) && scaled_iv_plus_offset(n->in(1))) {
       NOT_PRODUCT(_tracer.scaled_iv_plus_offset_6(n);)
       return true;
@@ -4316,15 +4316,15 @@ void SWPointer::Tracer::scaled_iv_plus_offset_5(Node* n) {
 
 void SWPointer::Tracer::scaled_iv_plus_offset_6(Node* n) {
   if(_slp->is_trace_alignment()) {
-    print_depth(); tty->print_cr(" %d SWPointer::scaled_iv_plus_offset: Op_SubI PASSED", n->_idx);
+    print_depth(); tty->print_cr(" %d SWPointer::scaled_iv_plus_offset: Op_%s PASSED", n->_idx, n->Name());
     print_depth(); tty->print("  \\  %d SWPointer::scaled_iv_plus_offset: in(1) is scaled_iv: ", n->in(1)->_idx); n->in(1)->dump();
     print_depth(); tty->print("  \\ %d SWPointer::scaled_iv_plus_offset: in(2) is offset_plus_k: ", n->in(2)->_idx); n->in(2)->dump();
   }
 }
 
 void SWPointer::Tracer::scaled_iv_plus_offset_7(Node* n) {
   if(_slp->is_trace_alignment()) {
-    print_depth(); tty->print_cr(" %d SWPointer::scaled_iv_plus_offset: Op_SubI PASSED", n->_idx);
+    print_depth(); tty->print_cr(" %d SWPointer::scaled_iv_plus_offset: Op_%s PASSED", n->_idx, n->Name());
     print_depth(); tty->print("  \\ %d SWPointer::scaled_iv_plus_offset: in(2) is scaled_iv: ", n->in(2)->_idx); n->in(2)->dump();
     print_depth(); tty->print("  \\ %d SWPointer::scaled_iv_plus_offset: in(1) is offset_plus_k: ", n->in(1)->_idx); n->in(1)->dump();
   }