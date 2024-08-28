@@ -432,7 +432,7 @@ class MacroAssembler: public Assembler {
 
 #define WRAP(INSN)                                                            \
   void INSN(Register Rd, Register Rn, Register Rm, Register Ra) {             \
-    if ((VM_Version::features() & VM_Version::CPU_A53MAC) && Ra != zr)        \
+    if (VM_Version::supports_a53mac() && Ra != zr)                            \
       nop();                                                                  \
     Assembler::INSN(Rd, Rn, Rm, Ra);                                          \
   }