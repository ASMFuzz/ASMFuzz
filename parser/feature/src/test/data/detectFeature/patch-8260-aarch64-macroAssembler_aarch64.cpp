@@ -196,7 +196,7 @@ int MacroAssembler::patch_oop(address insn_addr, address o) {
 }
 
 int MacroAssembler::patch_narrow_klass(address insn_addr, narrowKlass n) {
-  // Metatdata pointers are either narrow (32 bits) or wide (48 bits).
+  // Metadata pointers are either narrow (32 bits) or wide (48 bits).
   // We encode narrow ones by setting the upper 16 bits in the first
   // instruction.
   NativeInstruction *insn = nativeInstruction_at(insn_addr);
@@ -993,7 +993,7 @@ void MacroAssembler::check_klass_subtype_fast_path(Register sub_klass,
 
 // These two are taken from x86, but they look generally useful
 
-// scans count pointer sized words at [addr] for occurence of value,
+// scans count pointer sized words at [addr] for occurrence of value,
 // generic
 void MacroAssembler::repne_scan(Register addr, Register value, Register count,
                                 Register scratch) {
@@ -1008,7 +1008,7 @@ void MacroAssembler::repne_scan(Register addr, Register value, Register count,
   bind(Lexit);
 }
 
-// scans count 4 byte words at [addr] for occurence of value,
+// scans count 4 byte words at [addr] for occurrence of value,
 // generic
 void MacroAssembler::repne_scanw(Register addr, Register value, Register count,
                                 Register scratch) {
@@ -1581,7 +1581,7 @@ void MacroAssembler::atomic_incw(Register counter_addr, Register tmp, Register t
   // flush and load exclusive from the memory location
   ldxrw(tmp, counter_addr);
   addw(tmp, tmp, 1);
-  // if we store+flush with no intervening write tmp wil be zero
+  // if we store+flush with no intervening write tmp will be zero
   stxrw(tmp2, tmp, counter_addr);
   cbnzw(tmp2, retry_load);
 }
@@ -1889,7 +1889,7 @@ int MacroAssembler::push(unsigned int bitset, Register stack) {
     bitset >>= 1;
   }
   regs[count++] = zr->encoding_nocheck();
-  count &= ~1;  // Only push an even nuber of regs
+  count &= ~1;  // Only push an even number of regs
 
   if (count) {
     stp(as_Register(regs[0]), as_Register(regs[1]),
@@ -2210,7 +2210,7 @@ void MacroAssembler::wrap_add_sub_imm_insn(Register Rd, Register Rn, unsigned im
   }
 }
 
-// Seperate vsn which sets the flags. Optimisations are more restricted
+// Separate vsn which sets the flags. Optimisations are more restricted
 // because we must set the flags correctly.
 void MacroAssembler::wrap_adds_subs_imm_insn(Register Rd, Register Rn, unsigned imm,
                                            add_sub_imm_insn insn1,
@@ -2305,7 +2305,7 @@ void MacroAssembler::cmpxchgptr(Register oldv, Register newv, Register addr, Reg
     ldaxr(tmp, addr);
     cmp(tmp, oldv);
     br(Assembler::NE, nope);
-    // if we store+flush with no intervening write tmp wil be zero
+    // if we store+flush with no intervening write tmp will be zero
     stlxr(tmp, newv, addr);
     cbzw(tmp, succeed);
     // retry so we only ever return after a load fails to compare
@@ -2348,7 +2348,7 @@ void MacroAssembler::cmpxchgw(Register oldv, Register newv, Register addr, Regis
     ldaxrw(tmp, addr);
     cmp(tmp, oldv);
     br(Assembler::NE, nope);
-    // if we store+flush with no intervening write tmp wil be zero
+    // if we store+flush with no intervening write tmp will be zero
     stlxrw(tmp, newv, addr);
     cbzw(tmp, succeed);
     // retry so we only ever return after a load fails to compare
@@ -3024,7 +3024,7 @@ void MacroAssembler::multiply_128_x_128_loop(Register y, Register z,
 }
 
 /**
- * Code for BigInteger::multiplyToLen() instrinsic.
+ * Code for BigInteger::multiplyToLen() intrinsic.
  *
  * r0: x
  * r1: xlen
@@ -3159,7 +3159,7 @@ void MacroAssembler::multiply_to_len(Register x, Register xlen, Register y, Regi
   bind(L_done);
 }
 
-// Code for BigInteger::mulAdd instrinsic
+// Code for BigInteger::mulAdd intrinsic
 // out     = r0
 // in      = r1
 // offset  = r2  (already out.length-offset)
@@ -4835,7 +4835,7 @@ void MacroAssembler::zero_words(Register base, uint64_t cnt)
 
 // Zero blocks of memory by using DC ZVA.
 //
-// Aligns the base address first sufficently for DC ZVA, then uses
+// Aligns the base address first sufficiently for DC ZVA, then uses
 // DC ZVA repeatedly for every full block.  cnt is the size to be
 // zeroed in HeapWords.  Returns the count of words left to be zeroed
 // in cnt.
@@ -5332,7 +5332,7 @@ void MacroAssembler::protect_return_address() {
   }
 }
 
-// Sign the return value in the given register. Use before updating the LR in the exisiting stack
+// Sign the return value in the given register. Use before updating the LR in the existing stack
 // frame for the current function.
 // Uses the FP from the start of the function as the modifier - which is stored at the address of
 // the current FP.
@@ -5355,7 +5355,7 @@ void MacroAssembler::authenticate_return_address(Register return_reg) {
   }
 }
 
-// Authenticate the return value in the given register. Use before updating the LR in the exisiting
+// Authenticate the return value in the given register. Use before updating the LR in the existing
 // stack frame for the current function.
 // Uses the FP from the start of the function as the modifier - which is stored at the address of
 // the current FP.