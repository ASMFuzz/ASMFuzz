@@ -212,7 +212,7 @@ class MacroAssembler: public Assembler {
 
   inline void movw(Register Rd, Register Rn) {
     if (Rd == sp || Rn == sp) {
-      addw(Rd, Rn, 0U);
+      Assembler::addw(Rd, Rn, 0U);
     } else {
       orrw(Rd, zr, Rn);
     }
@@ -221,7 +221,7 @@ class MacroAssembler: public Assembler {
     assert(Rd != r31_sp && Rn != r31_sp, "should be");
     if (Rd == Rn) {
     } else if (Rd == sp || Rn == sp) {
-      add(Rd, Rn, 0U);
+      Assembler::add(Rd, Rn, 0U);
     } else {
       orr(Rd, zr, Rn);
     }
@@ -1144,17 +1144,17 @@ class MacroAssembler: public Assembler {
 
   // If a constant does not fit in an immediate field, generate some
   // number of MOV instructions and then perform the operation
-  void wrap_add_sub_imm_insn(Register Rd, Register Rn, unsigned imm,
+  void wrap_add_sub_imm_insn(Register Rd, Register Rn, uint64_t imm,
                              add_sub_imm_insn insn1,
-                             add_sub_reg_insn insn2);
+                             add_sub_reg_insn insn2, bool is32);
   // Separate vsn which sets the flags
-  void wrap_adds_subs_imm_insn(Register Rd, Register Rn, unsigned imm,
-                             add_sub_imm_insn insn1,
-                             add_sub_reg_insn insn2);
+  void wrap_adds_subs_imm_insn(Register Rd, Register Rn, uint64_t imm,
+                               add_sub_imm_insn insn1,
+                               add_sub_reg_insn insn2, bool is32);
 
-#define WRAP(INSN)                                                      \
-  void INSN(Register Rd, Register Rn, unsigned imm) {                   \
-    wrap_add_sub_imm_insn(Rd, Rn, imm, &Assembler::INSN, &Assembler::INSN); \
+#define WRAP(INSN, is32)                                                \
+  void INSN(Register Rd, Register Rn, uint64_t imm) {                   \
+    wrap_add_sub_imm_insn(Rd, Rn, imm, &Assembler::INSN, &Assembler::INSN, is32); \
   }                                                                     \
                                                                         \
   void INSN(Register Rd, Register Rn, Register Rm,                      \
@@ -1171,12 +1171,12 @@ class MacroAssembler: public Assembler {
     Assembler::INSN(Rd, Rn, Rm, option, amount);                        \
   }
 
-  WRAP(add) WRAP(addw) WRAP(sub) WRAP(subw)
+  WRAP(add, false) WRAP(addw, true) WRAP(sub, false) WRAP(subw, true)
 
 #undef WRAP
-#define WRAP(INSN)                                                      \
-  void INSN(Register Rd, Register Rn, unsigned imm) {                   \
-    wrap_adds_subs_imm_insn(Rd, Rn, imm, &Assembler::INSN, &Assembler::INSN); \
+#define WRAP(INSN, is32)                                                \
+  void INSN(Register Rd, Register Rn, uint64_t imm) {                   \
+    wrap_adds_subs_imm_insn(Rd, Rn, imm, &Assembler::INSN, &Assembler::INSN, is32); \
   }                                                                     \
                                                                         \
   void INSN(Register Rd, Register Rn, Register Rm,                      \
@@ -1193,7 +1193,7 @@ class MacroAssembler: public Assembler {
     Assembler::INSN(Rd, Rn, Rm, option, amount);                        \
   }
 
-  WRAP(adds) WRAP(addsw) WRAP(subs) WRAP(subsw)
+  WRAP(adds, false) WRAP(addsw, true) WRAP(subs, false) WRAP(subsw, true)
 
   void add(Register Rd, Register Rn, RegisterOrConstant increment);
   void addw(Register Rd, Register Rn, RegisterOrConstant increment);