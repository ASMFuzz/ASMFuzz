@@ -1,6 +1,6 @@
 /*
  * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
- * Copyright (c) 2020, 2021, Huawei Technologies Co., Ltd. All rights reserved.
+ * Copyright (c) 2020, 2022, Huawei Technologies Co., Ltd. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -24,16 +24,16 @@
  */
 
 #include "precompiled.hpp"
-#include "prims/universalNativeInvoker.hpp"
+#include "prims/downcallLinker.hpp"
 #include "utilities/debug.hpp"
 
-RuntimeStub* DowncallLinker::make_native_invoker(BasicType* signature,
-                                                 int num_args,
-                                                 BasicType ret_bt,
-                                                 const ABIDescriptor& abi,
-                                                 const GrowableArray<VMReg>& input_registers,
-                                                 const GrowableArray<VMReg>& output_registers,
-                                                 bool needs_return_buffer) {
+RuntimeStub* DowncallLinker::make_downcall_stub(BasicType* signature,
+                                                int num_args,
+                                                BasicType ret_bt,
+                                                const ABIDescriptor& abi,
+                                                const GrowableArray<VMReg>& input_registers,
+                                                const GrowableArray<VMReg>& output_registers,
+                                                bool needs_return_buffer) {
   Unimplemented();
   return nullptr;
 }