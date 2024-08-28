@@ -49,6 +49,7 @@
 #include "utilities/debug.hpp"
 #include "utilities/events.hpp"
 #include "utilities/vmError.hpp"
+#include "utilities/vmErrorStepper.hpp"
 
 // put OS-includes here
 # include <sys/types.h>
@@ -434,48 +435,65 @@ size_t os::Posix::default_stack_size(os::ThreadType thr_type) {
 
 void os::print_context(outputStream *st, const void *context) {
   if (context == NULL) return;
+
   const ucontext_t *uc = (const ucontext_t*)context;
 
-  st->print_cr("Registers:");
+# define STEP(instruction1, instruction2) \
+  if (VMErrorStepper::step()) {           \
+    instruction1 ; instruction2 ;         \
+  }
+
+  STEP(st->print_cr("Register to memory mapping:"), st->cr());
+
   intx* reg_area = (intx*)&uc->uc_mcontext.arm_r0;
   for (int r = 0; r < ARM_REGS_IN_CONTEXT; r++) {
-    st->print_cr("  %-3s = " INTPTR_FORMAT, as_Register(r)->name(), reg_area[r]);
+    STEP(st->print("  %-3s = ", as_Register(r)->name()),
+         print_location(st, reg_area[r]));
   }
-#define U64_FORMAT "0x%016llx"
-  // now print flag register
-  st->print_cr("  %-4s = 0x%08lx", "cpsr",uc->uc_mcontext.arm_cpsr);
   st->cr();
 
-  intptr_t *sp = (intptr_t *)os::Linux::ucontext_get_sp(uc);
-  st->print_cr("Top of Stack: (sp=" INTPTR_FORMAT ")", p2i(sp));
-  print_hex_dump(st, (address)sp, (address)(sp + 8*sizeof(intptr_t)), sizeof(intptr_t));
-  st->cr();
+# undef STEP
+
+  // now print flag register
+  if (VMErrorStepper::step()) {
+    st->cr();
+    st->print_cr("  %-4s = 0x%08lx", "cpsr", uc->uc_mcontext.arm_cpsr);
+  }
+
+  if (VMErrorStepper::step()) {
+    st->cr();
+    intptr_t *sp = (intptr_t *)os::Linux::ucontext_get_sp(uc);
+    st->print_cr("Top of Stack: (sp=" INTPTR_FORMAT ")", p2i(sp));
+    print_hex_dump(st, (address)sp, (address)(sp + 8*sizeof(intptr_t)), sizeof(intptr_t));
+  }
 
   // Note: it may be unsafe to inspect memory near pc. For example, pc may
   // point to garbage if entry point in an nmethod is corrupted. Leave
   // this at the end, and hope for the best.
-  address pc = os::Posix::ucontext_get_pc(uc);
-  print_instructions(st, pc, Assembler::InstructionSize);
+  if (VMErrorStepper::step()) {
+    st->cr();
+    address pc = os::Posix::ucontext_get_pc(uc);
+    print_instructions(st, pc, Assembler::InstructionSize);
+  }
+
   st->cr();
 }
 
 void os::print_register_info(outputStream *st, const void *context) {
   if (context == NULL) return;
 
   const ucontext_t *uc = (const ucontext_t*)context;
-  intx* reg_area = (intx*)&uc->uc_mcontext.arm_r0;
 
-  st->print_cr("Register to memory mapping:");
+  st->print_cr("Registers:");
   st->cr();
+
+  intx* reg_area = (intx*)&uc->uc_mcontext.arm_r0;
   for (int r = 0; r < ARM_REGS_IN_CONTEXT; r++) {
-    st->print("  %-3s = ", as_Register(r)->name());
-    print_location(st, reg_area[r]);
+    st->print_cr("  %-3s = " INTPTR_FORMAT, as_Register(r)->name(), reg_area[r]);
   }
   st->cr();
 }
 
-
-
 typedef int64_t cmpxchg_long_func_t(int64_t, int64_t, volatile int64_t*);
 
 cmpxchg_long_func_t* os::atomic_cmpxchg_long_func = os::atomic_cmpxchg_long_bootstrap;