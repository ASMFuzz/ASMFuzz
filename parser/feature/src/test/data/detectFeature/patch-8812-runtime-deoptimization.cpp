@@ -38,23 +38,27 @@
 #include "interpreter/bytecode.hpp"
 #include "interpreter/interpreter.hpp"
 #include "interpreter/oopMapCache.hpp"
+#include "logging/log.hpp"
+#include "logging/logLevel.hpp"
+#include "logging/logMessage.hpp"
+#include "logging/logStream.hpp"
 #include "memory/allocation.inline.hpp"
 #include "memory/oopFactory.hpp"
 #include "memory/resourceArea.hpp"
 #include "memory/universe.hpp"
 #include "oops/constantPool.hpp"
+#include "oops/fieldStreams.inline.hpp"
 #include "oops/method.hpp"
 #include "oops/objArrayKlass.hpp"
 #include "oops/objArrayOop.inline.hpp"
 #include "oops/oop.inline.hpp"
-#include "oops/fieldStreams.inline.hpp"
 #include "oops/typeArrayOop.inline.hpp"
 #include "oops/verifyOopClosure.hpp"
 #include "prims/jvmtiDeferredUpdates.hpp"
 #include "prims/jvmtiExport.hpp"
 #include "prims/jvmtiThreadState.hpp"
-#include "prims/vectorSupport.hpp"
 #include "prims/methodHandles.hpp"
+#include "prims/vectorSupport.hpp"
 #include "runtime/atomic.hpp"
 #include "runtime/continuation.hpp"
 #include "runtime/continuationEntry.inline.hpp"
@@ -1834,6 +1838,26 @@ static void post_deoptimization_event(CompiledMethod* nm,
 
 #endif // INCLUDE_JFR
 
+static void log_deopt(CompiledMethod* nm, Method* tm, intptr_t pc, frame& fr, int trap_bci,
+                              const char* reason_name, const char* reason_action) {
+  LogTarget(Debug, deoptimization) lt;
+  if (lt.is_enabled()) {
+    LogStream ls(lt);
+    bool is_osr = nm->is_osr_method();
+    ls.print("cid=%4d %s level=%d",
+             nm->compile_id(), (is_osr ? "osr" : "   "), nm->comp_level());
+    ls.print(" %s", tm->name_and_sig_as_C_string());
+    ls.print(" trap_bci=%d ", trap_bci);
+    if (is_osr) {
+      ls.print("osr_bci=%d ", nm->osr_entry_bci());
+    }
+    ls.print("%s ", reason_name);
+    ls.print("%s ", reason_action);
+    ls.print_cr("pc=" INTPTR_FORMAT " relative_pc=" INTPTR_FORMAT,
+             pc, fr.pc() - nm->code_begin());
+  }
+}
+
 JRT_ENTRY(void, Deoptimization::uncommon_trap_inner(JavaThread* current, jint trap_request)) {
   HandleMark hm(current);
 
@@ -1927,12 +1951,18 @@ JRT_ENTRY(void, Deoptimization::uncommon_trap_inner(JavaThread* current, jint tr
     MethodData* trap_mdo =
       get_method_data(current, profiled_method, create_if_missing);
 
-    JFR_ONLY(post_deoptimization_event(nm, trap_method(), trap_bci, trap_bc, reason, action);)
-
-    // Log a message
-    Events::log_deopt_message(current, "Uncommon trap: reason=%s action=%s pc=" INTPTR_FORMAT " method=%s @ %d %s",
-                              trap_reason_name(reason), trap_action_name(action), p2i(fr.pc()),
-                              trap_method->name_and_sig_as_C_string(), trap_bci, nm->compiler_name());
+    { // Log Deoptimization event for JFR, UL and event system
+      Method* tm = trap_method();
+      const char* reason_name = trap_reason_name(reason);
+      const char* reason_action = trap_action_name(action);
+      intptr_t pc = p2i(fr.pc());
+
+      JFR_ONLY(post_deoptimization_event(nm, tm, trap_bci, trap_bc, reason, action);)
+      log_deopt(nm, tm, pc, fr, trap_bci, reason_name, reason_action);
+      Events::log_deopt_message(current, "Uncommon trap: reason=%s action=%s pc=" INTPTR_FORMAT " method=%s @ %d %s",
+                                reason_name, reason_action, pc,
+                                tm->name_and_sig_as_C_string(), trap_bci, nm->compiler_name());
+    }
 
     // Print a bunch of diagnostics, if requested.
     if (TraceDeoptimization || LogCompilation || is_receiver_constraint_failure) {