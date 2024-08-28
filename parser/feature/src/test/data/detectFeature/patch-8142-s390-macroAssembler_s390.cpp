@@ -1,6 +1,6 @@
 /*
  * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
- * Copyright (c) 2016, 2019 SAP SE. All rights reserved.
+ * Copyright (c) 2016, 2022 SAP SE. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -4667,6 +4667,22 @@ void MacroAssembler::kmc(Register dstBuff, Register srcBuff) {
   Assembler::z_brc(Assembler::bcondOverflow /* CC==3 (iterate) */, retry);
 }
 
+void MacroAssembler::kmctr(Register dstBuff, Register ctrBuff, Register srcBuff) {
+  // DstBuff and srcBuff are allowed to be the same register (encryption in-place).
+  // DstBuff and srcBuff storage must not overlap destructively, and neither must overlap the parameter block.
+  assert(srcBuff->encoding()     != 0, "src buffer address can't be in Z_R0");
+  assert(dstBuff->encoding()     != 0, "dst buffer address can't be in Z_R0");
+  assert(ctrBuff->encoding()     != 0, "ctr buffer address can't be in Z_R0");
+  assert(ctrBuff->encoding() % 2 == 0, "ctr buffer addr must be an even register");
+  assert(dstBuff->encoding() % 2 == 0, "dst buffer addr must be an even register");
+  assert(srcBuff->encoding() % 2 == 0, "src buffer addr/len must be an even/odd register pair");
+
+  Label retry;
+  bind(retry);
+  Assembler::z_kmctr(dstBuff, ctrBuff, srcBuff);
+  Assembler::z_brc(Assembler::bcondOverflow /* CC==3 (iterate) */, retry);
+}
+
 void MacroAssembler::cksm(Register crcBuff, Register srcBuff) {
   assert(srcBuff->encoding() % 2 == 0, "src buffer addr/len must be an even/odd register pair");
 