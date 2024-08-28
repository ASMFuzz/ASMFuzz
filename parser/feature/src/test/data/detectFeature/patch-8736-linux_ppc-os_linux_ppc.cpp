@@ -460,6 +460,12 @@ void os::print_context(outputStream *st, const void *context) {
   }
   st->cr();
   st->cr();
+}
+
+void os::print_tos_pc(outputStream *st, const void *context) {
+  if (context == NULL) return;
+
+  const ucontext_t* uc = (const ucontext_t*)context;
 
   intptr_t *sp = (intptr_t *)os::Linux::ucontext_get_sp(uc);
   st->print_cr("Top of Stack: (sp=" PTR_FORMAT ")", p2i(sp));