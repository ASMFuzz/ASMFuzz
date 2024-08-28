@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2014, Red Hat Inc. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
@@ -338,6 +338,17 @@ void LIRGenerator::do_MonitorExit(MonitorExit* x) {
   monitor_exit(obj_temp, lock, syncTempOpr(), LIR_OprFact::illegalOpr, x->monitor_no());
 }
 
+void LIRGenerator::do_continuation_doYield(Intrinsic* x) {
+  BasicTypeList signature(0);
+  CallingConvention* cc = frame_map()->java_calling_convention(&signature, true);
+
+  const LIR_Opr result_reg = result_register_for(x->type());
+  address entry = StubRoutines::cont_doYield();
+  LIR_Opr result = rlock_result(x);
+  CodeEmitInfo* info = state_for(x, x->state());
+  __ call_runtime(entry, LIR_OprFact::illegalOpr, result_reg, cc->args(), info);
+  __ move(result_reg, result);
+}
 
 void LIRGenerator::do_NegateOp(NegateOp* x) {
 