@@ -1030,6 +1030,66 @@ void C2_MacroAssembler::sve_vmask_tolong(Register dst, PRegister src, BasicType
   }
 }
 
+// Unpack the mask, a long value in src, into predicate register dst based on the
+// corresponding data type. Note that dst can support at most 64 lanes.
+// Below example gives the expected dst predicate register in different types, with
+// a valid src(0x658D) on a 1024-bit vector size machine.
+// BYTE:  dst = 0x00 00 00 00 00 00 00 00 00 00 00 00 00 00 65 8D
+// SHORT: dst = 0x00 00 00 00 00 00 00 00 00 00 00 00 14 11 40 51
+// INT:   dst = 0x00 00 00 00 00 00 00 00 01 10 01 01 10 00 11 01
+// LONG:  dst = 0x00 01 01 00 00 01 00 01 01 00 00 00 01 01 00 01
+//
+// The number of significant bits of src must be equal to lane_cnt. E.g., 0xFF658D which
+// has 24 significant bits would be an invalid input if dst predicate register refers to
+// a LONG type 1024-bit vector, which has at most 16 lanes.
+void C2_MacroAssembler::sve_vmask_fromlong(PRegister dst, Register src, BasicType bt, int lane_cnt,
+                                           FloatRegister vtmp1, FloatRegister vtmp2) {
+  assert(UseSVE == 2 && VM_Version::supports_svebitperm() &&
+         lane_cnt <= 64 && is_power_of_2(lane_cnt), "unsupported");
+  Assembler::SIMD_RegVariant size = elemType_to_regVariant(bt);
+  // Example:   src = 0x658D, bt = T_BYTE, size = B, lane_cnt = 16
+  // Expected:  dst = 0b01101001 10001101
+
+  // Put long value from general purpose register into the first lane of vector.
+  // vtmp1 = 0x0000000000000000 | 0x000000000000658D
+  sve_dup(vtmp1, B, 0);
+  mov(vtmp1, D, 0, src);
+
+  // As sve_cmp generates mask value with the minimum unit in byte, we should
+  // transform the value in the first lane which is mask in bit now to the
+  // mask in byte, which can be done by SVE2's BDEP instruction.
+
+  // The first source input of BDEP instruction. Deposite each byte in every 8 bytes.
+  // vtmp1 = 0x0000000000000065 | 0x000000000000008D
+  if (lane_cnt <= 8) {
+    // Nothing. As only one byte exsits.
+  } else if (lane_cnt <= 16) {
+    ins(vtmp1, B, vtmp1, 8, 1);
+    mov(vtmp1, B, 1, zr);
+  } else {
+    sve_vector_extend(vtmp1, D, vtmp1, B);
+  }
+
+  // The second source input of BDEP instruction, initialized with 0x01 for each byte.
+  // vtmp2 = 0x01010101 0x01010101 0x01010101 0x01010101
+  sve_dup(vtmp2, B, 1);
+
+  // BDEP vtmp1.D, vtmp1.D, vtmp2.D
+  // vtmp1 = 0x0000000000000065 | 0x000000000000008D
+  // vtmp2 = 0x0101010101010101 | 0x0101010101010101
+  //         ---------------------------------------
+  // vtmp1 = 0x0001010000010001 | 0x0100000001010001
+  sve_bdep(vtmp1, D, vtmp1, vtmp2);
+
+  if (bt != T_BYTE) {
+    sve_vector_extend(vtmp1, size, vtmp1, B);
+  }
+  // Generate mask according to the given vector, in which the elements have been
+  // extended to expected type.
+  // dst = 0b01101001 10001101
+  sve_cmp(Assembler::NE, dst, size, ptrue, vtmp1, 0);
+}
+
 void C2_MacroAssembler::sve_compare(PRegister pd, BasicType bt, PRegister pg,
                                     FloatRegister zn, FloatRegister zm, int cond) {
   assert(pg->is_governing(), "This register has to be a governing predicate register");