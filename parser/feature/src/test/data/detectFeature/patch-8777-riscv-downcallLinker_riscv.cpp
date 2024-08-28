@@ -27,13 +27,13 @@
 #include "prims/universalNativeInvoker.hpp"
 #include "utilities/debug.hpp"
 
-RuntimeStub* ProgrammableInvoker::make_native_invoker(BasicType* signature,
-                                                      int num_args,
-                                                      BasicType ret_bt,
-                                                      const ABIDescriptor& abi,
-                                                      const GrowableArray<VMReg>& input_registers,
-                                                      const GrowableArray<VMReg>& output_registers,
-                                                      bool needs_return_buffer) {
+RuntimeStub* DowncallLinker::make_native_invoker(BasicType* signature,
+                                                 int num_args,
+                                                 BasicType ret_bt,
+                                                 const ABIDescriptor& abi,
+                                                 const GrowableArray<VMReg>& input_registers,
+                                                 const GrowableArray<VMReg>& output_registers,
+                                                 bool needs_return_buffer) {
   Unimplemented();
   return nullptr;
 }