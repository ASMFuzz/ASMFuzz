@@ -22,16 +22,16 @@
  */
 
 #include "precompiled.hpp"
-#include "prims/universalNativeInvoker.hpp"
+#include "prims/downcallLinker.hpp"
 #include "utilities/debug.hpp"
 
-RuntimeStub* ProgrammableInvoker::make_native_invoker(BasicType* signature,
-                                                      int num_args,
-                                                      BasicType ret_bt,
-                                                      const ABIDescriptor& abi,
-                                                      const GrowableArray<VMReg>& input_registers,
-                                                      const GrowableArray<VMReg>& output_registers,
-                                                      bool needs_return_buffer) {
+RuntimeStub* DowncallLinker::make_downcall_stub(BasicType* signature,
+                                                int num_args,
+                                                BasicType ret_bt,
+                                                const ABIDescriptor& abi,
+                                                const GrowableArray<VMReg>& input_registers,
+                                                const GrowableArray<VMReg>& output_registers,
+                                                bool needs_return_buffer) {
   Unimplemented();
   return nullptr;
 }