@@ -7490,8 +7490,9 @@ address generate_avx_ghash_processBlocks() {
     return stub;
   }
 
-  address generate_cont_thaw(bool return_barrier, bool exception) {
-    assert(return_barrier || !exception, "must be");
+  address generate_cont_thaw(Continuation::thaw_kind kind) {
+    bool return_barrier = Continuation::is_thaw_return_barrier(kind);
+    bool return_barrier_exception = Continuation::is_thaw_return_barrier_exception(kind);
 
     address start = __ pc();
 
@@ -7508,7 +7509,7 @@ address generate_avx_ghash_processBlocks() {
       __ push(rax); __ push_d(xmm0); // preserve possible return value from a method returning to the return barrier
     }
 
-    __ movl(c_rarg1, (return_barrier ? 1 : 0) + (exception ? 1 : 0));
+    __ movl(c_rarg1, (return_barrier ? 1 : 0));
     __ call_VM_leaf(CAST_FROM_FN_PTR(address, Continuation::prepare_thaw), r15_thread, c_rarg1);
     __ movptr(rbx, rax); // rax contains the size of the frames to thaw, 0 if overflow or no more frames
 
@@ -7531,9 +7532,7 @@ address generate_avx_ghash_processBlocks() {
     }
 
     // If we want, we can templatize thaw by kind, and have three different entries
-    if (exception)           __ movl(c_rarg1, (int32_t)Continuation::thaw_exception);
-    else if (return_barrier) __ movl(c_rarg1, (int32_t)Continuation::thaw_return_barrier);
-    else                     __ movl(c_rarg1, (int32_t)Continuation::thaw_top);
+    __ movl(c_rarg1, (int32_t) kind);
 
     __ call_VM_leaf(Continuation::thaw_entry(), r15_thread, c_rarg1);
     __ movptr(rbx, rax); // rax is the sp of the yielding frame
@@ -7547,7 +7546,7 @@ address generate_avx_ghash_processBlocks() {
     __ movptr(rsp, rbx); // we're now on the yield frame (which is in an address above us b/c rsp has been pushed down)
     __ subptr(rsp, 2*wordSize); // now pointing to rbp spill
 
-    if (exception) {
+    if (return_barrier_exception) {
       __ movptr(c_rarg1, Address(rsp, wordSize)); // return address
       __ push(rax); // save return value contaning the exception oop
       __ call_VM_leaf(CAST_FROM_FN_PTR(address, SharedRuntime::exception_handler_for_return_address), r15_thread, c_rarg1);
@@ -7570,7 +7569,7 @@ address generate_avx_ghash_processBlocks() {
 
     StubCodeMark mark(this, "StubRoutines", "Cont thaw");
     address start = __ pc();
-    generate_cont_thaw(false, false);
+    generate_cont_thaw(Continuation::thaw_top);
     return start;
   }
 
@@ -7581,7 +7580,7 @@ address generate_avx_ghash_processBlocks() {
     StubCodeMark mark(this, "StubRoutines", "cont return barrier");
     address start = __ pc();
 
-    generate_cont_thaw(true, false);
+    generate_cont_thaw(Continuation::thaw_return_barrier);
 
     return start;
   }
@@ -7592,7 +7591,7 @@ address generate_avx_ghash_processBlocks() {
     StubCodeMark mark(this, "StubRoutines", "cont return barrier exception handler");
     address start = __ pc();
 
-    generate_cont_thaw(true, true);
+    generate_cont_thaw(Continuation::thaw_return_barrier_exception);
 
     return start;
   }