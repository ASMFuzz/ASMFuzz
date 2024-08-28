@@ -242,7 +242,7 @@ int LIR_Assembler::emit_unwind_handler() {
   __ bind(_unwind_handler_entry);
   __ verify_not_null_oop(Rexception_obj);
 
-  // Preform needed unlocking
+  // Perform needed unlocking
   MonitorExitStub* stub = NULL;
   if (method()->is_synchronized()) {
     monitor_address(0, FrameMap::R0_opr);
@@ -641,7 +641,7 @@ void LIR_Assembler::stack2reg(LIR_Opr src, LIR_Opr dest, BasicType type) {
       case T_ARRAY:
       case T_ADDRESS:
       case T_METADATA: __ ldr(dest->as_register(), addr); break;
-      case T_FLOAT:    // used in floatToRawIntBits intrinsic implemenation
+      case T_FLOAT:    // used in floatToRawIntBits intrinsic implementation
       case T_INT:      __ ldr_u32(dest->as_register(), addr); break;
       default:
         ShouldNotReachHere();