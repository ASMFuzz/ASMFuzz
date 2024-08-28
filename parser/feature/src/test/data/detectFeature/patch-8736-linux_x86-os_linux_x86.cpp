@@ -525,6 +525,7 @@ void os::print_context(outputStream *st, const void *context) {
   if (context == NULL) return;
 
   const ucontext_t *uc = (const ucontext_t*)context;
+
   st->print_cr("Registers:");
 #ifdef AMD64
   st->print(  "RAX=" INTPTR_FORMAT, (intptr_t)uc->uc_mcontext.gregs[REG_RAX]);
@@ -570,6 +571,12 @@ void os::print_context(outputStream *st, const void *context) {
 #endif // AMD64
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