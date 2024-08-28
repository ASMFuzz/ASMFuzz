@@ -23,15 +23,15 @@
  */
 
 #include "precompiled.hpp"
-#include "prims/universalUpcallHandler.hpp"
+#include "prims/upcallLinker.hpp"
 #include "utilities/debug.hpp"
 
-address ProgrammableUpcallHandler::generate_optimized_upcall_stub(jobject receiver, Method* entry,
-                                                                  BasicType* in_sig_bt, int total_in_args,
-                                                                  BasicType* out_sig_bt, int total_out_args,
-                                                                  BasicType ret_type,
-                                                                  jobject jabi, jobject jconv,
-                                                                  bool needs_return_buffer, int ret_buf_size) {
+address UpcallLinker::make_upcall_stub(jobject receiver, Method* entry,
+                                       BasicType* in_sig_bt, int total_in_args,
+                                       BasicType* out_sig_bt, int total_out_args,
+                                       BasicType ret_type,
+                                       jobject jabi, jobject jconv,
+                                       bool needs_return_buffer, int ret_buf_size) {
   ShouldNotCallThis();
   return nullptr;
 }