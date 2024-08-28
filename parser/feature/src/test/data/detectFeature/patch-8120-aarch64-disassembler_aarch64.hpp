@@ -34,14 +34,6 @@
     return "";
   }
 
-  // Returns address of n-th instruction preceding addr,
-  // NULL if no preceding instruction can be found.
-  // On ARM(aarch64), we assume a constant instruction length.
-  // It might be beneficial to check "is_readable" as we do on ppc and s390.
-  static address find_prev_instr(address addr, int n_instr) {
-    return addr - Assembler::instruction_size*n_instr;
-  }
-
   // special-case instruction decoding.
   // There may be cases where the binutils disassembler doesn't do
   // the perfect job. In those cases, decode_instruction0 may kick in