@@ -1985,8 +1985,12 @@ class MacroAssembler: public Assembler {
                          XMMRegister xmm, KRegister mask, Register length,
                          Register temp);
 
+  void fill32(Address dst, XMMRegister xmm);
+
   void fill32(Register dst, int disp, XMMRegister xmm);
 
+  void fill64(Address dst, XMMRegister xmm, bool use64byteVector = false);
+
   void fill64(Register dst, int dis, XMMRegister xmm, bool use64byteVector = false);
 
 #ifdef _LP64