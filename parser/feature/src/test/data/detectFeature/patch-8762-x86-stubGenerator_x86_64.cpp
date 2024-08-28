@@ -8199,7 +8199,7 @@ OopMap* continuation_enter_setup(MacroAssembler* masm, int& stack_slots) {
 //          c_rarg3 -- isVirtualThread
 // kills rax
 void fill_continuation_entry(MacroAssembler* masm) {
-  DEBUG_ONLY(__ movl(Address(rsp, ContinuationEntry::cookie_offset()), 0x1234);)
+  DEBUG_ONLY(__ movl(Address(rsp, ContinuationEntry::cookie_offset()), ContinuationEntry::cookie_value());)
 
   __ movptr(Address(rsp, ContinuationEntry::cont_offset()), c_rarg1);
   __ movl  (Address(rsp, ContinuationEntry::flags_offset()), c_rarg3);