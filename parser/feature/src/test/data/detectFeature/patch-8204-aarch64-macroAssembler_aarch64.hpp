@@ -877,6 +877,10 @@ class MacroAssembler: public Assembler {
   // Round up to a power of two
   void round_to(Register reg, int modulus);
 
+  // java.lang.Math::round intrinsics
+  void java_round_double(Register dst, FloatRegister src, FloatRegister ftmp);
+  void java_round_float(Register dst, FloatRegister src, FloatRegister ftmp);
+
   // allocation
   void eden_allocate(
     Register obj,                      // result: pointer to object after successful allocation