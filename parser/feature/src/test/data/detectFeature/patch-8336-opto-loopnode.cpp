@@ -2233,6 +2233,7 @@ void CountedLoopNode::dump_spec(outputStream *st) const {
   if (is_pre_loop ()) st->print("pre of N%d" , _main_idx);
   if (is_main_loop()) st->print("main of N%d", _idx);
   if (is_post_loop()) st->print("post of N%d", _main_idx);
+  if (is_reduction_loop()) st->print(" reduction");
   if (is_strip_mined()) st->print(" strip mined");
 }
 #endif
@@ -3934,6 +3935,7 @@ void IdealLoopTree::dump_head() const {
     if (cl->is_pre_loop ()) tty->print(" pre" );
     if (cl->is_main_loop()) tty->print(" main");
     if (cl->is_post_loop()) tty->print(" post");
+    if (cl->is_reduction_loop()) tty->print(" reduction");
     if (cl->is_vectorized_loop()) tty->print(" vector");
     if (cl->range_checks_present()) tty->print(" rc ");
     if (cl->is_multiversioned()) tty->print(" multi ");