@@ -1347,6 +1347,11 @@ class MacroAssembler: public Assembler {
 
   using Assembler::vbroadcastsd;
   void vbroadcastsd(XMMRegister dst, AddressLiteral src, int vector_len, Register rscratch = rscratch1);
+  void vpbroadcastq(XMMRegister dst, AddressLiteral src, int vector_len, Register rscratch = rscratch1);
+  void vpbroadcastq(XMMRegister dst, XMMRegister src, int vector_len) { Assembler::vpbroadcastq(dst, src, vector_len); }
+  void vpbroadcastq(XMMRegister dst, Address src, int vector_len) { Assembler::vpbroadcastq(dst, src, vector_len); }
+
+
 
   void vpcmpeqb(XMMRegister dst, XMMRegister nds, XMMRegister src, int vector_len);
 