@@ -1473,7 +1473,7 @@ void MacroAssembler::store_sized_value(Address dst, Register src, size_t size_in
 // reverse bytes in halfword in lower 16 bits and sign-extend
 // Rd[15:0] = Rs[7:0] Rs[15:8] (sign-extend to 64 bits)
 void MacroAssembler::revb_h_h(Register Rd, Register Rs, Register tmp) {
-  if (UseRVB) {
+  if (UseZbb) {
     rev8(Rd, Rs);
     srai(Rd, Rd, 48);
     return;
@@ -1490,7 +1490,7 @@ void MacroAssembler::revb_h_h(Register Rd, Register Rs, Register tmp) {
 // reverse bytes in lower word and sign-extend
 // Rd[31:0] = Rs[7:0] Rs[15:8] Rs[23:16] Rs[31:24] (sign-extend to 64 bits)
 void MacroAssembler::revb_w_w(Register Rd, Register Rs, Register tmp1, Register tmp2) {
-  if (UseRVB) {
+  if (UseZbb) {
     rev8(Rd, Rs);
     srai(Rd, Rd, 32);
     return;
@@ -1507,7 +1507,7 @@ void MacroAssembler::revb_w_w(Register Rd, Register Rs, Register tmp1, Register
 // reverse bytes in halfword in lower 16 bits and zero-extend
 // Rd[15:0] = Rs[7:0] Rs[15:8] (zero-extend to 64 bits)
 void MacroAssembler::revb_h_h_u(Register Rd, Register Rs, Register tmp) {
-  if (UseRVB) {
+  if (UseZbb) {
     rev8(Rd, Rs);
     srli(Rd, Rd, 48);
     return;
@@ -1524,11 +1524,11 @@ void MacroAssembler::revb_h_h_u(Register Rd, Register Rs, Register tmp) {
 // reverse bytes in halfwords in lower 32 bits and zero-extend
 // Rd[31:0] = Rs[23:16] Rs[31:24] Rs[7:0] Rs[15:8] (zero-extend to 64 bits)
 void MacroAssembler::revb_h_w_u(Register Rd, Register Rs, Register tmp1, Register tmp2) {
-  if (UseRVB) {
+  if (UseZbb) {
     rev8(Rd, Rs);
     rori(Rd, Rd, 32);
     roriw(Rd, Rd, 16);
-    zext_w(Rd, Rd);
+    zero_extend(Rd, Rd, 32);
     return;
   }
   assert_different_registers(Rs, tmp1, tmp2);
@@ -1557,16 +1557,16 @@ void MacroAssembler::revb_h_helper(Register Rd, Register Rs, Register tmp1, Regi
 // reverse bytes in each halfword
 // Rd[63:0] = Rs[55:48] Rs[63:56] Rs[39:32] Rs[47:40] Rs[23:16] Rs[31:24] Rs[7:0] Rs[15:8]
 void MacroAssembler::revb_h(Register Rd, Register Rs, Register tmp1, Register tmp2) {
-  if (UseRVB) {
+  if (UseZbb) {
     assert_different_registers(Rs, tmp1);
     assert_different_registers(Rd, tmp1);
     rev8(Rd, Rs);
-    zext_w(tmp1, Rd);
+    zero_extend(tmp1, Rd, 32);
     roriw(tmp1, tmp1, 16);
     slli(tmp1, tmp1, 32);
     srli(Rd, Rd, 32);
     roriw(Rd, Rd, 16);
-    zext_w(Rd, Rd);
+    zero_extend(Rd, Rd, 32);
     orr(Rd, Rd, tmp1);
     return;
   }
@@ -1581,7 +1581,7 @@ void MacroAssembler::revb_h(Register Rd, Register Rs, Register tmp1, Register tm
 // reverse bytes in each word
 // Rd[63:0] = Rs[39:32] Rs[47:40] Rs[55:48] Rs[63:56] Rs[7:0] Rs[15:8] Rs[23:16] Rs[31:24]
 void MacroAssembler::revb_w(Register Rd, Register Rs, Register tmp1, Register tmp2) {
-  if (UseRVB) {
+  if (UseZbb) {
     rev8(Rd, Rs);
     rori(Rd, Rd, 32);
     return;
@@ -1595,7 +1595,7 @@ void MacroAssembler::revb_w(Register Rd, Register Rs, Register tmp1, Register tm
 // reverse bytes in doubleword
 // Rd[63:0] = Rs[7:0] Rs[15:8] Rs[23:16] Rs[31:24] Rs[39:32] Rs[47,40] Rs[55,48] Rs[63:56]
 void MacroAssembler::revb(Register Rd, Register Rs, Register tmp1, Register tmp2) {
-  if (UseRVB) {
+  if (UseZbb) {
     rev8(Rd, Rs);
     return;
   }
@@ -1617,7 +1617,7 @@ void MacroAssembler::revb(Register Rd, Register Rs, Register tmp1, Register tmp2
 // rotate right with shift bits
 void MacroAssembler::ror_imm(Register dst, Register src, uint32_t shift, Register tmp)
 {
-  if (UseRVB) {
+  if (UseZbb) {
     rori(dst, src, shift);
     return;
   }
@@ -3563,7 +3563,7 @@ void MacroAssembler::multiply_to_len(Register x, Register xlen, Register y, Regi
 // shift 16 bits once.
 void MacroAssembler::ctzc_bit(Register Rd, Register Rs, bool isLL, Register tmp1, Register tmp2)
 {
-  if (UseRVB) {
+  if (UseZbb) {
     assert_different_registers(Rd, Rs, tmp1);
     int step = isLL ? 8 : 16;
     ctz(Rd, Rs);
@@ -3905,7 +3905,7 @@ void MacroAssembler::zero_memory(Register addr, Register len, Register tmp) {
 // shift left by shamt and add
 // Rd = (Rs1 << shamt) + Rs2
 void MacroAssembler::shadd(Register Rd, Register Rs1, Register Rs2, Register tmp, int shamt) {
-  if (UseRVB) {
+  if (UseZba) {
     if (shamt == 1) {
       sh1add(Rd, Rs1, Rs2);
       return;
@@ -3927,14 +3927,14 @@ void MacroAssembler::shadd(Register Rd, Register Rs1, Register Rs2, Register tmp
 }
 
 void MacroAssembler::zero_extend(Register dst, Register src, int bits) {
-  if (UseRVB) {
-    if (bits == 16) {
-      zext_h(dst, src);
-      return;
-    } else if (bits == 32) {
-      zext_w(dst, src);
-      return;
-    }
+  if (UseZba && bits == 32) {
+    zext_w(dst, src);
+    return;
+  }
+
+  if (UseZbb && bits == 16) {
+    zext_h(dst, src);
+    return;
   }
 
   if (bits == 8) {
@@ -3946,7 +3946,7 @@ void MacroAssembler::zero_extend(Register dst, Register src, int bits) {
 }
 
 void MacroAssembler::sign_extend(Register dst, Register src, int bits) {
-  if (UseRVB) {
+  if (UseZbb) {
     if (bits == 8) {
       sext_b(dst, src);
       return;