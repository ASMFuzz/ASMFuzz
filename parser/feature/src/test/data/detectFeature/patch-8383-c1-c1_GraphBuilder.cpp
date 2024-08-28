@@ -46,6 +46,10 @@
 #include "runtime/vm_version.hpp"
 #include "utilities/bitMap.inline.hpp"
 #include "utilities/powerOfTwo.hpp"
+#include "utilities/macros.hpp"
+#if INCLUDE_JFR
+#include "jfr/jfr.hpp"
+#endif
 
 class BlockListBuilder {
  private:
@@ -1911,7 +1915,6 @@ Values* GraphBuilder::collect_args_for_profiling(Values* args, ciMethod* target,
   return obj_args;
 }
 
-
 void GraphBuilder::invoke(Bytecodes::Code code) {
   bool will_link;
   ciSignature* declared_signature = NULL;
@@ -1920,6 +1923,7 @@ void GraphBuilder::invoke(Bytecodes::Code code) {
   const Bytecodes::Code bc_raw = stream()->cur_bc_raw();
   assert(declared_signature != NULL, "cannot be null");
   assert(will_link == target->is_loaded(), "");
+  JFR_ONLY(Jfr::on_resolution(this, holder, target); CHECK_BAILOUT();)
 
   ciInstanceKlass* klass = target->holder();
   assert(!target->is_loaded() || klass->is_loaded(), "loaded target must imply loaded klass");