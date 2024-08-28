@@ -1196,6 +1196,9 @@ class Assembler : public AbstractAssembler  {
   void vpabsd(XMMRegister dst, XMMRegister src, int vector_len);
   void evpabsq(XMMRegister dst, XMMRegister src, int vector_len);
 
+  void divl(Register src);
+  void divq(Register src);
+
   // Divide Scalar Double-Precision Floating-Point Values
   void divsd(XMMRegister dst, Address src);
   void divsd(XMMRegister dst, XMMRegister src);
@@ -1364,12 +1367,9 @@ class Assembler : public AbstractAssembler  {
   void hlt();
 
   void idivl(Register src);
-  void divl(Register src); // Unsigned division
-
-#ifdef _LP64
+  void idivl(Address src);
   void idivq(Register src);
-  void divq(Register src); // Unsigned division
-#endif
+  void idivq(Address src);
 
   void imull(Register src);
   void imull(Register dst, Register src);