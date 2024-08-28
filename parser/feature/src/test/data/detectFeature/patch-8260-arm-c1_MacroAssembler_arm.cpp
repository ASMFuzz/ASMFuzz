@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2008, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2008, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -189,7 +189,7 @@ int C1_MacroAssembler::lock_object(Register hdr, Register obj, Register disp_hdr
   const Register tmp2 = Rtemp; // Rtemp should be free at c1 LIR level
   assert_different_registers(hdr, obj, disp_hdr, tmp2);
 
-  assert(BasicObjectLock::lock_offset_in_bytes() == 0, "ajust this code");
+  assert(BasicObjectLock::lock_offset_in_bytes() == 0, "adjust this code");
   const int obj_offset = BasicObjectLock::obj_offset_in_bytes();
   const int mark_offset = BasicLock::displaced_header_offset_in_bytes();
 
@@ -247,7 +247,7 @@ void C1_MacroAssembler::unlock_object(Register hdr, Register obj, Register disp_
   assert_different_registers(hdr, obj, disp_hdr, Rtemp);
   Register tmp2 = Rtemp;
 
-  assert(BasicObjectLock::lock_offset_in_bytes() == 0, "ajust this code");
+  assert(BasicObjectLock::lock_offset_in_bytes() == 0, "adjust this code");
   const int obj_offset = BasicObjectLock::obj_offset_in_bytes();
   const int mark_offset = BasicLock::displaced_header_offset_in_bytes();
 