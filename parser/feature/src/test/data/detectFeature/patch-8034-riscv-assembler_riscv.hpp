@@ -2795,7 +2795,7 @@ enum Nf {
   }
 
   INSN(beq, c_beqz, _beq);
-  INSN(bne, c_beqz, _bne);
+  INSN(bne, c_bnez, _bne);
 
 #undef INSN
 