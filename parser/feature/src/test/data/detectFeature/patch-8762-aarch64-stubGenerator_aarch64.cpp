@@ -8080,7 +8080,7 @@ OopMap* continuation_enter_setup(MacroAssembler* masm, int& stack_slots) {
 //          c_rarg3 -- isVirtualThread
 void fill_continuation_entry(MacroAssembler* masm) {
 #ifdef ASSERT
-  __ movw(rscratch1, 0x1234);
+  __ movw(rscratch1, ContinuationEntry::cookie_value());
   __ strw(rscratch1, Address(sp, ContinuationEntry::cookie_offset()));
 #endif
 