@@ -1291,7 +1291,7 @@ class MacroAssembler: public Assembler {
                      int elem_size);
 
   void fill_words(Register base, Register cnt, Register value);
-  void zero_words(Register base, uint64_t cnt);
+  address zero_words(Register base, uint64_t cnt);
   address zero_words(Register ptr, Register cnt);
   void zero_dcache_blocks(Register base, Register cnt);
 