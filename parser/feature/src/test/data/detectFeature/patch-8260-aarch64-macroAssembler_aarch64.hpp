@@ -476,7 +476,7 @@ class MacroAssembler: public Assembler {
   // Push and pop everything that might be clobbered by a native
   // runtime call except rscratch1 and rscratch2.  (They are always
   // scratch, so we don't have to protect them.)  Only save the lower
-  // 64 bits of each vector register. Additonal registers can be excluded
+  // 64 bits of each vector register. Additional registers can be excluded
   // in a passed RegSet.
   void push_call_clobbered_registers_except(RegSet exclude);
   void pop_call_clobbered_registers_except(RegSet exclude);
@@ -657,7 +657,7 @@ class MacroAssembler: public Assembler {
   // incrementl/decrementl
 
   // for aarch64 the proper convention would be to use
-  // increment/decrement for 64 bit operatons and
+  // increment/decrement for 64 bit operations and
   // incrementw/decrementw for 32 bit operations. so when porting
   // x86_64 code we can leave calls to increment/decrement as is,
   // replace incrementq/decrementq with increment/decrement and
@@ -1011,12 +1011,12 @@ class MacroAssembler: public Assembler {
   // Various forms of CAS
 
   void cmpxchg_obj_header(Register oldv, Register newv, Register obj, Register tmp,
-                          Label &suceed, Label *fail);
+                          Label &succeed, Label *fail);
   void cmpxchgptr(Register oldv, Register newv, Register addr, Register tmp,
-                  Label &suceed, Label *fail);
+                  Label &succeed, Label *fail);
 
   void cmpxchgw(Register oldv, Register newv, Register addr, Register tmp,
-                  Label &suceed, Label *fail);
+                  Label &succeed, Label *fail);
 
   void atomic_add(Register prev, RegisterOrConstant incr, Register addr);
   void atomic_addw(Register prev, RegisterOrConstant incr, Register addr);
@@ -1103,11 +1103,11 @@ class MacroAssembler: public Assembler {
 
   void movoop(Register dst, jobject obj, bool immediate = false);
 
-  // CRC32 code for java.util.zip.CRC32::updateBytes() instrinsic.
+  // CRC32 code for java.util.zip.CRC32::updateBytes() intrinsic.
   void kernel_crc32(Register crc, Register buf, Register len,
         Register table0, Register table1, Register table2, Register table3,
         Register tmp, Register tmp2, Register tmp3);
-  // CRC32 code for java.util.zip.CRC32C::updateBytes() instrinsic.
+  // CRC32 code for java.util.zip.CRC32C::updateBytes() intrinsic.
   void kernel_crc32c(Register crc, Register buf, Register len,
         Register table0, Register table1, Register table2, Register table3,
         Register tmp, Register tmp2, Register tmp3);
@@ -1129,7 +1129,7 @@ class MacroAssembler: public Assembler {
   void wrap_add_sub_imm_insn(Register Rd, Register Rn, unsigned imm,
                              add_sub_imm_insn insn1,
                              add_sub_reg_insn insn2);
-  // Seperate vsn which sets the flags
+  // Separate vsn which sets the flags
   void wrap_adds_subs_imm_insn(Register Rd, Register Rn, unsigned imm,
                              add_sub_imm_insn insn1,
                              add_sub_reg_insn insn2);
@@ -1233,7 +1233,7 @@ class MacroAssembler: public Assembler {
   address read_polling_page(Register r, relocInfo::relocType rtype);
   void get_polling_page(Register dest, relocInfo::relocType rtype);
 
-  // CRC32 code for java.util.zip.CRC32::updateBytes() instrinsic.
+  // CRC32 code for java.util.zip.CRC32::updateBytes() intrinsic.
   void update_byte_crc32(Register crc, Register val, Register table);
   void update_word_crc32(Register crc, Register v, Register tmp,
         Register table0, Register table1, Register table2, Register table3,