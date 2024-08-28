@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2016, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2016, 2018 SAP SE. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
@@ -373,7 +373,7 @@ void PatchingStub::emit_code(LIR_Assembler* ce) {
 
   // Now emit the patch record telling the runtime how to find the
   // pieces of the patch. We only need 3 bytes but to help the disassembler
-  // we make the data look like a the following add instruction:
+  // we make the data look like the following add instruction:
   //   A R1, D2(X2, B2)
   // which requires 4 bytes.
   int sizeof_patch_record = 4;