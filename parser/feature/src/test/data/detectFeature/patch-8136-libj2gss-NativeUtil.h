@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -73,6 +73,7 @@ extern "C" {
   extern jmethodID MID_GSSNameElement_ctor;
   extern jmethodID MID_GSSCredElement_ctor;
   extern jmethodID MID_NativeGSSContext_ctor;
+  extern jmethodID MID_NativeGSSContext_setContext;
   extern jfieldID FID_GSSLibStub_pMech;
   extern jfieldID FID_NativeGSSContext_pContext;
   extern jfieldID FID_NativeGSSContext_srcName;