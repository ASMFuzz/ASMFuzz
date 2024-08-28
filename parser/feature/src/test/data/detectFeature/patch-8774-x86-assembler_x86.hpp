@@ -1198,9 +1198,6 @@ class Assembler : public AbstractAssembler  {
   void vpabsd(XMMRegister dst, XMMRegister src, int vector_len);
   void evpabsq(XMMRegister dst, XMMRegister src, int vector_len);
 
-  void divl(Register src);
-  void divq(Register src);
-
   // Divide Scalar Double-Precision Floating-Point Values
   void divsd(XMMRegister dst, Address src);
   void divsd(XMMRegister dst, XMMRegister src);
@@ -1369,9 +1366,12 @@ class Assembler : public AbstractAssembler  {
   void hlt();
 
   void idivl(Register src);
-  void idivl(Address src);
+  void divl(Register src); // Unsigned division
+
+#ifdef _LP64
   void idivq(Register src);
-  void idivq(Address src);
+  void divq(Register src); // Unsigned division
+#endif
 
   void imull(Register src);
   void imull(Register dst, Register src);