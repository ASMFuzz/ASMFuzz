@@ -1546,6 +1546,8 @@ void C2_MacroAssembler::count_positives_v(Register ary, Register len, Register r
   Label LOOP, SET_RESULT, DONE;
 
   BLOCK_COMMENT("count_positives_v {");
+  assert_different_registers(ary, len, result, tmp);
+
   mv(result, zr);
 
   bind(LOOP);