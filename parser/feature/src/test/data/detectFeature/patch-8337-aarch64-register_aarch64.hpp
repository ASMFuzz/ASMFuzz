@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2014, 2021, Red Hat Inc. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
@@ -275,6 +275,9 @@ class PRegisterImpl: public AbstractRegisterImpl {
 REGISTER_IMPL_DECLARATION(PRegister, PRegisterImpl, PRegisterImpl::number_of_registers);
 
 // The predicate registers of SVE.
+//
+CONSTANT_REGISTER_DECLARATION(PRegister, pnoreg, (-1));
+
 CONSTANT_REGISTER_DECLARATION(PRegister, p0,  ( 0));
 CONSTANT_REGISTER_DECLARATION(PRegister, p1,  ( 1));
 CONSTANT_REGISTER_DECLARATION(PRegister, p2,  ( 2));