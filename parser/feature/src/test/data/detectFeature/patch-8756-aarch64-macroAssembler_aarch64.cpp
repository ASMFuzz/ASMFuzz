@@ -4855,7 +4855,7 @@ address MacroAssembler::zero_words(Register ptr, Register cnt)
 // r10, r11, rscratch1, and rscratch2 are clobbered.
 address MacroAssembler::zero_words(Register base, uint64_t cnt)
 {
-  guarantee(zero_words_block_size < BlockZeroingLowLimit,
+  assert(wordSize <= BlockZeroingLowLimit,
             "increase BlockZeroingLowLimit");
   address result = nullptr;
   if (cnt <= (uint64_t)BlockZeroingLowLimit / BytesPerWord) {