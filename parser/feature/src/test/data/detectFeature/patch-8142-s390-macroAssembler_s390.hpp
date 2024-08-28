@@ -1,6 +1,6 @@
 /*
- * Copyright (c) 2016, 2021, Oracle and/or its affiliates. All rights reserved.
- * Copyright (c) 2016, 2019 SAP SE. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022 SAP SE. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -248,8 +248,9 @@ class MacroAssembler: public Assembler {
   // Crypto instructions.
   // Being interruptible, these instructions need a retry-loop.
   void cksm(Register crcBuff, Register srcBuff);
-  void km( Register dstBuff, Register srcBuff);
-  void kmc(Register dstBuff, Register srcBuff);
+  void km(   Register dstBuff, Register srcBuff);
+  void kmc(  Register dstBuff, Register srcBuff);
+  void kmctr(Register dstBuff, Register ctrBuff, Register srcBuff);
   void kimd(Register srcBuff);
   void klmd(Register srcBuff);
   void kmac(Register srcBuff);