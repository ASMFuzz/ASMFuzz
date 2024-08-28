@@ -378,7 +378,10 @@ void MacroAssembler::verify_oop(Register reg, const char* s) {
   push_reg(RegSet::of(ra, t0, t1, c_rarg0), sp);
 
   mv(c_rarg0, reg); // c_rarg0 : x10
-  li(t0, (uintptr_t)(address)b);
+  // The length of the instruction sequence emitted should be independent
+  // of the values of the local char buffer address so that the size of mach
+  // nodes for scratch emit and normal emit matches.
+  mv(t0, (address)b);
 
   // call indirectly to solve generation ordering problem
   int32_t offset = 0;
@@ -414,7 +417,10 @@ void MacroAssembler::verify_oop_addr(Address addr, const char* s) {
     ld(x10, addr);
   }
 
-  li(t0, (uintptr_t)(address)b);
+  // The length of the instruction sequence emitted should be independent
+  // of the values of the local char buffer address so that the size of mach
+  // nodes for scratch emit and normal emit matches.
+  mv(t0, (address)b);
 
   // call indirectly to solve generation ordering problem
   int32_t offset = 0;