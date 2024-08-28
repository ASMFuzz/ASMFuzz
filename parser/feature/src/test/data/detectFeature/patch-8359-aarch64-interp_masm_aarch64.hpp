@@ -277,7 +277,8 @@ class InterpreterMacroAssembler: public MacroAssembler {
 
   // Debugging
   // only if +VerifyOops && state == atos
-  void verify_oop(Register reg, TosState state = atos);
+#define interp_verify_oop(reg, state) _interp_verify_oop(reg, state, __FILE__, __LINE__);
+  void _interp_verify_oop(Register reg, TosState state, const char* file, int line);
   // only if +VerifyFPU  && (state == ftos || state == dtos)
   void verify_FPU(int stack_depth, TosState state = ftos);
 