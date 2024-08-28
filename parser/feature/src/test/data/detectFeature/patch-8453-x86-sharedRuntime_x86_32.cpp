@@ -2632,7 +2632,7 @@ SafepointBlob* SharedRuntime::generate_handler_blob(address call_ptr, int poll_t
 
   // allocate space for the code
   // setup code generation tools
-  CodeBuffer   buffer("handler_blob", 1024, 512);
+  CodeBuffer   buffer("handler_blob", 2048, 1024);
   MacroAssembler* masm = new MacroAssembler(&buffer);
 
   const Register java_thread = rdi; // callee-saved for VC++