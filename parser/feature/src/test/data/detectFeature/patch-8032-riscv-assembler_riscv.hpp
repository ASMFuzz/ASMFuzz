@@ -1944,6 +1944,7 @@ enum Nf {
 
 // ====================================
 // RISC-V Bit-Manipulation Extension
+// Currently only support Zba and Zbb.
 // ====================================
 #define INSN(NAME, op, funct3, funct7)                  \
   void NAME(Register Rd, Register Rs1, Register Rs2) {  \