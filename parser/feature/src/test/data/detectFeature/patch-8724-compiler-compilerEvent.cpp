@@ -27,7 +27,9 @@
 #include "jfr/jfr.hpp"
 #include "jfr/jfrEvents.hpp"
 #include "jfr/metadata/jfrSerializer.hpp"
+#include "runtime/interfaceSupport.inline.hpp"
 #include "runtime/semaphore.inline.hpp"
+#include "runtime/thread.inline.hpp"
 #include "utilities/growableArray.hpp"
 
 // Synchronizes access to phases_names.
@@ -114,6 +116,16 @@ int CompilerEvent::PhaseEvent::get_phase_id(const char* phase_name, bool may_exi
   return index;
 }
 
+// As part of event commit, a Method* is tagged as a function of an epoch.
+// Epochs evolve during safepoints. To ensure the event is tagged in the correct epoch,
+// that is, to avoid a race, the thread will participate in the safepoint protocol
+// by transitioning from _thread_in_native to _thread_in_vm.
+template <typename EventType>
+static inline void commit(EventType& event) {
+  ThreadInVMfromNative transition(JavaThread::current());
+  event.commit();
+ }
+
 void CompilerEvent::CompilationEvent::post(EventCompilation& event, int compile_id, CompilerType compiler_type, Method* method, int compile_level, bool success, bool is_osr, int code_size, int inlined_bytecodes) {
   event.set_compileId(compile_id);
   event.set_compiler(compiler_type);
@@ -123,7 +135,7 @@ void CompilerEvent::CompilationEvent::post(EventCompilation& event, int compile_
   event.set_isOsr(is_osr);
   event.set_codeSize(code_size);
   event.set_inlinedBytes(inlined_bytecodes);
-  event.commit();
+  commit(event);
 }
 
 void CompilerEvent::CompilationFailureEvent::post(EventCompilationFailure& event, int compile_id, const char* reason) {
@@ -147,7 +159,7 @@ void CompilerEvent::InlineEvent::post(EventCompilerInlining& event, int compile_
   event.set_succeeded(success);
   event.set_message(msg);
   event.set_bci(bci);
-  event.commit();
+  commit(event);
 }
 
 void CompilerEvent::InlineEvent::post(EventCompilerInlining& event, int compile_id, Method* caller, Method* callee, bool success, const char* msg, int bci) {