@@ -4820,7 +4820,6 @@ address MacroAssembler::zero_words(Register ptr, Register cnt)
       address tpc = trampoline_call(zero_blocks);
       if (tpc == NULL) {
         DEBUG_ONLY(reset_labels(around));
-        assert(false, "failed to allocate space for trampoline");
         return NULL;
       }
     } else {
@@ -4854,10 +4853,11 @@ address MacroAssembler::zero_words(Register ptr, Register cnt)
 // cnt:          Immediate count in HeapWords.
 //
 // r10, r11, rscratch1, and rscratch2 are clobbered.
-void MacroAssembler::zero_words(Register base, uint64_t cnt)
+address MacroAssembler::zero_words(Register base, uint64_t cnt)
 {
   guarantee(zero_words_block_size < BlockZeroingLowLimit,
             "increase BlockZeroingLowLimit");
+  address result = nullptr;
   if (cnt <= (uint64_t)BlockZeroingLowLimit / BytesPerWord) {
 #ifndef PRODUCT
     {
@@ -4891,10 +4891,12 @@ void MacroAssembler::zero_words(Register base, uint64_t cnt)
       stp(zr, zr, Address(base, i * wordSize));
     }
     BLOCK_COMMENT("} zero_words");
+    result = pc();
   } else {
     mov(r10, base); mov(r11, cnt);
-    zero_words(r10, r11);
+    result = zero_words(r10, r11);
   }
+  return result;
 }
 
 // Zero blocks of memory by using DC ZVA.