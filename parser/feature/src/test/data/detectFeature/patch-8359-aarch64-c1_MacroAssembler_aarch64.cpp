@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2014, 2021, Red Hat Inc. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
@@ -326,7 +326,7 @@ void C1_MacroAssembler::load_parameter(int offset_in_words, Register reg) {
 
 void C1_MacroAssembler::verify_stack_oop(int stack_offset) {
   if (!VerifyOops) return;
-  verify_oop_addr(Address(sp, stack_offset), "oop");
+  verify_oop_addr(Address(sp, stack_offset));
 }
 
 void C1_MacroAssembler::verify_not_null_oop(Register r) {