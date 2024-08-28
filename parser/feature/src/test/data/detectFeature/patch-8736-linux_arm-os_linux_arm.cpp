@@ -434,6 +434,7 @@ size_t os::Posix::default_stack_size(os::ThreadType thr_type) {
 
 void os::print_context(outputStream *st, const void *context) {
   if (context == NULL) return;
+
   const ucontext_t *uc = (const ucontext_t*)context;
 
   st->print_cr("Registers:");
@@ -445,6 +446,12 @@ void os::print_context(outputStream *st, const void *context) {
   // now print flag register
   st->print_cr("  %-4s = 0x%08lx", "cpsr",uc->uc_mcontext.arm_cpsr);
   st->cr();
+}
+
+void os::print_tos_pc(outputStream *st, const void *context) {
+  if (context == NULL) return;
+
+  const ucontext_t* uc = (const ucontext_t*)context;
 
   intptr_t *sp = (intptr_t *)os::Linux::ucontext_get_sp(uc);
   st->print_cr("Top of Stack: (sp=" INTPTR_FORMAT ")", p2i(sp));
@@ -463,8 +470,8 @@ void os::print_register_info(outputStream *st, const void *context) {
   if (context == NULL) return;
 
   const ucontext_t *uc = (const ucontext_t*)context;
-  intx* reg_area = (intx*)&uc->uc_mcontext.arm_r0;
 
+  intx* reg_area = (intx*)&uc->uc_mcontext.arm_r0;
   st->print_cr("Register to memory mapping:");
   st->cr();
   for (int r = 0; r < ARM_REGS_IN_CONTEXT; r++) {
@@ -474,8 +481,6 @@ void os::print_register_info(outputStream *st, const void *context) {
   st->cr();
 }
 
-
-
 typedef int64_t cmpxchg_long_func_t(int64_t, int64_t, volatile int64_t*);
 
 cmpxchg_long_func_t* os::atomic_cmpxchg_long_func = os::atomic_cmpxchg_long_bootstrap;