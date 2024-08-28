@@ -26,15 +26,15 @@
 #include "code/codeBlob.hpp"
 #include "logging/logStream.hpp"
 #include "memory/resourceArea.hpp"
-#include "prims/foreign_globals.inline.hpp"
-#include "prims/universalNativeInvoker.hpp"
+#include "prims/foreignGlobals.inline.hpp"
+#include "prims/downcallLinker.hpp"
 #include "runtime/sharedRuntime.hpp"
 #include "runtime/stubCodeGenerator.hpp"
 #include "utilities/formatBuffer.hpp"
 
 #define __ _masm->
 
-class NativeInvokerGenerator : public StubCodeGenerator {
+class DowncallStubGenerator : public StubCodeGenerator {
   BasicType* _signature;
   int _num_args;
   BasicType _ret_bt;
@@ -49,7 +49,7 @@ class NativeInvokerGenerator : public StubCodeGenerator {
   int _framesize;
   OopMapSet* _oop_maps;
 public:
-  NativeInvokerGenerator(CodeBuffer* buffer,
+  DowncallStubGenerator(CodeBuffer* buffer,
                          BasicType* signature,
                          int num_args,
                          BasicType ret_bt,
@@ -87,16 +87,16 @@ class NativeInvokerGenerator : public StubCodeGenerator {
 
 static const int native_invoker_code_size = 1024;
 
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
   int locs_size  = 64;
   CodeBuffer code("nep_invoker_blob", native_invoker_code_size, locs_size);
-  NativeInvokerGenerator g(&code, signature, num_args, ret_bt, abi, input_registers, output_registers, needs_return_buffer);
+  DowncallStubGenerator g(&code, signature, num_args, ret_bt, abi, input_registers, output_registers, needs_return_buffer);
   g.generate();
   code.log_section_sizes("nep_invoker_blob");
 
@@ -119,7 +119,7 @@ RuntimeStub* ProgrammableInvoker::make_native_invoker(BasicType* signature,
   return stub;
 }
 
-void NativeInvokerGenerator::generate() {
+void DowncallStubGenerator::generate() {
   enum layout {
     rbp_off,
     rbp_off2,