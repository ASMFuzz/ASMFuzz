@@ -961,35 +961,15 @@ void InterpreterMacroAssembler::increment_mdp_data_at(Register mdp_in,
   }
 
   if (decrement) {
-    // Decrement the register.  Set condition codes.
-    // Intel does this
-    // addptr(data, (int32_t) -DataLayout::counter_increment);
-    // If the decrement causes the counter to overflow, stay negative
-    // Label L;
-    // jcc(Assembler::negative, L);
-    // addptr(data, (int32_t) DataLayout::counter_increment);
-    // so we do this
+    // Decrement the register.  No point checking for 64-bit underflow.
     ldr(rscratch1, addr);
-    subs(rscratch1, rscratch1, (unsigned)DataLayout::counter_increment);
-    Label L;
-    br(Assembler::LO, L);       // skip store if counter underflow
+    sub(rscratch1, rscratch1, (unsigned)DataLayout::counter_increment);
     str(rscratch1, addr);
-    bind(L);
   } else {
-    assert(DataLayout::counter_increment == 1,
-           "flow-free idiom only works with 1");
-    // Intel does this
-    // Increment the register.  Set carry flag.
-    // addptr(data, DataLayout::counter_increment);
-    // If the increment causes the counter to overflow, pull back by 1.
-    // sbbptr(data, (int32_t)0);
-    // so we do this
+    // Increment the register.  No point checking for 64-bit overflow.
     ldr(rscratch1, addr);
-    adds(rscratch1, rscratch1, DataLayout::counter_increment);
-    Label L;
-    br(Assembler::CS, L);       // skip store if counter overflow
+    add(rscratch1, rscratch1, DataLayout::counter_increment);
     str(rscratch1, addr);
-    bind(L);
   }
 }
 
@@ -1075,17 +1055,9 @@ void InterpreterMacroAssembler::profile_taken_branch(Register mdp,
     //increment_mdp_data_at(mdp, in_bytes(JumpData::taken_offset()));
     Address data(mdp, in_bytes(JumpData::taken_offset()));
     ldr(bumped_count, data);
-    assert(DataLayout::counter_increment == 1,
-            "flow-free idiom only works with 1");
-    // Intel does this to catch overflow
-    // addptr(bumped_count, DataLayout::counter_increment);
-    // sbbptr(bumped_count, 0);
-    // so we do this
-    adds(bumped_count, bumped_count, DataLayout::counter_increment);
-    Label L;
-    br(Assembler::CS, L);       // skip store if counter overflow
+    add(bumped_count, bumped_count, DataLayout::counter_increment);
     str(bumped_count, data);
-    bind(L);
+
     // The method data pointer needs to be updated to reflect the new target.
     update_mdp_by_offset(mdp, in_bytes(JumpData::displacement_offset()));
     bind(profile_continue);