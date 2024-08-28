@@ -1584,7 +1584,7 @@ address TemplateInterpreterGenerator::generate_native_entry(bool synchronized) {
                   return_pc /* return pc */);
   __ merge_frames(/*top_frame_sp*/ R21_sender_SP, noreg, R11_scratch1, R12_scratch2);
 
-  // Load the PC of the the exception handler into LR.
+  // Load the PC of the exception handler into LR.
   __ mtlr(R3_RET);
 
   // Load exception into R3_ARG1 and clear pending exception in thread.