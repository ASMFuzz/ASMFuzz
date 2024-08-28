@@ -1077,7 +1077,7 @@ void MacroAssembler::object_move(OopMap* map,
     cmovptr(Assembler::equal, rHandle, Address(rbp, reg2offset_in(src.first())));
   } else {
 
-    // Oop is in an a register we must store it to the space we reserve
+    // Oop is in a register we must store it to the space we reserve
     // on the stack for oop_handles and pass a handle if oop is non-NULL
 
     const Register rOop = src.first()->as_Register();