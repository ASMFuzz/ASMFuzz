@@ -6552,8 +6552,9 @@ class StubGenerator: public StubCodeGenerator {
     return stub;
   }
 
-  address generate_cont_thaw(bool return_barrier, bool exception) {
-    assert(return_barrier || !exception, "must be");
+  address generate_cont_thaw(Continuation::thaw_kind kind) {
+    bool return_barrier = Continuation::is_thaw_return_barrier(kind);
+    bool return_barrier_exception = Continuation::is_thaw_return_barrier_exception(kind);
 
     address start = __ pc();
 
@@ -6569,7 +6570,7 @@ class StubGenerator: public StubCodeGenerator {
       __ stp(rscratch1, r0, Address(__ pre(sp, -2 * wordSize)));
     }
 
-    __ movw(c_rarg1, (return_barrier ? 1 : 0) + (exception ? 1 : 0));
+    __ movw(c_rarg1, (return_barrier ? 1 : 0));
     __ call_VM_leaf(CAST_FROM_FN_PTR(address, Continuation::prepare_thaw), rthread, c_rarg1);
     __ mov(rscratch2, r0); // r0 contains the size of the frames to thaw, 0 if overflow or no more frames
 
@@ -6600,9 +6601,7 @@ class StubGenerator: public StubCodeGenerator {
     }
 
     // If we want, we can templatize thaw by kind, and have three different entries
-    if (exception)           __ movw(c_rarg1, (uint32_t)Continuation::thaw_exception);
-    else if (return_barrier) __ movw(c_rarg1, (uint32_t)Continuation::thaw_return_barrier);
-    else                     __ movw(c_rarg1, (uint32_t)Continuation::thaw_top);
+    __ movw(c_rarg1, (uint32_t)kind);
 
     __ call_VM_leaf(Continuation::thaw_entry(), rthread, c_rarg1);
     __ mov(rscratch2, r0); // r0 is the sp of the yielding frame
@@ -6619,7 +6618,7 @@ class StubGenerator: public StubCodeGenerator {
     __ sub(sp, rscratch2, 2*wordSize); // now pointing to rfp spill
     __ mov(rfp, sp);
 
-    if (exception) {
+    if (return_barrier_exception) {
       __ ldr(c_rarg1, Address(rfp, wordSize)); // return address
       __ verify_oop(r0);
       __ mov(r19, r0); // save return value contaning the exception oop in callee-saved R19
@@ -6652,7 +6651,7 @@ class StubGenerator: public StubCodeGenerator {
 
     StubCodeMark mark(this, "StubRoutines", "Cont thaw");
     address start = __ pc();
-    generate_cont_thaw(false, false);
+    generate_cont_thaw(Continuation::thaw_top);
     return start;
   }
 
@@ -6663,7 +6662,7 @@ class StubGenerator: public StubCodeGenerator {
     StubCodeMark mark(this, "StubRoutines", "cont return barrier");
     address start = __ pc();
 
-    generate_cont_thaw(true, false);
+    generate_cont_thaw(Continuation::thaw_return_barrier);
 
     return start;
   }
@@ -6674,7 +6673,7 @@ class StubGenerator: public StubCodeGenerator {
     StubCodeMark mark(this, "StubRoutines", "cont return barrier exception handler");
     address start = __ pc();
 
-    generate_cont_thaw(true, true);
+    generate_cont_thaw(Continuation::thaw_return_barrier_exception);
 
     return start;
   }