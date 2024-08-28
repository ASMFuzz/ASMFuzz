@@ -117,7 +117,7 @@ void InterpreterMacroAssembler::load_earlyret_value(TosState state) {
   switch (state) {
     case atos: ldr(r0, oop_addr);
                str(zr, oop_addr);
-               verify_oop(r0, state);               break;
+               interp_verify_oop(r0, state);        break;
     case ltos: ldr(r0, val_addr);                   break;
     case btos:                                   // fall through
     case ztos:                                   // fall through
@@ -382,11 +382,11 @@ void InterpreterMacroAssembler::pop(TosState state) {
   case vtos: /* nothing to do */        break;
   default:   ShouldNotReachHere();
   }
-  verify_oop(r0, state);
+  interp_verify_oop(r0, state);
 }
 
 void InterpreterMacroAssembler::push(TosState state) {
-  verify_oop(r0, state);
+  interp_verify_oop(r0, state);
   switch (state) {
   case atos: push_ptr();                break;
   case btos:
@@ -464,7 +464,7 @@ void InterpreterMacroAssembler::dispatch_base(TosState state,
     Unimplemented();
   }
   if (verifyoop) {
-    verify_oop(r0, state);
+    interp_verify_oop(r0, state);
   }
 
   Label safepoint;
@@ -1469,9 +1469,9 @@ void InterpreterMacroAssembler::profile_switch_case(Register index,
   }
 }
 
-void InterpreterMacroAssembler::verify_oop(Register reg, TosState state) {
+void InterpreterMacroAssembler::_interp_verify_oop(Register reg, TosState state, const char* file, int line) {
   if (state == atos) {
-    MacroAssembler::verify_oop(reg);
+    MacroAssembler::_verify_oop_checked(reg, "broken oop", file, line);
   }
 }
 