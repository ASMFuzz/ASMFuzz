@@ -445,6 +445,7 @@ class Assembler : public AbstractAssembler {
     MULHD_OPCODE  = (31u << OPCODE_SHIFT |  73u << 1),              // XO-FORM
     MULHDU_OPCODE = (31u << OPCODE_SHIFT |   9u << 1),              // XO-FORM
     DIVD_OPCODE   = (31u << OPCODE_SHIFT | 489u << 1),              // XO-FORM
+    DIVDU_OPCODE  = (31u << OPCODE_SHIFT | 457u << 1),              // XO-FORM
 
     CNTLZD_OPCODE = (31u << OPCODE_SHIFT |  58u << XO_21_30_SHIFT), // X-FORM
     CNTTZD_OPCODE = (31u << OPCODE_SHIFT | 570u << XO_21_30_SHIFT), // X-FORM
@@ -1422,6 +1423,8 @@ class Assembler : public AbstractAssembler {
   inline void divd_(  Register d, Register a, Register b);
   inline void divw(   Register d, Register a, Register b);
   inline void divw_(  Register d, Register a, Register b);
+  inline void divdu(  Register d, Register a, Register b);
+  inline void divdu_( Register d, Register a, Register b);
   inline void divwu(  Register d, Register a, Register b);
   inline void divwu_( Register d, Register a, Register b);
 