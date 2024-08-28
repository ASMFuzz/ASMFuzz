@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -30,6 +30,10 @@ void BarrierSetNMethod::deoptimize(nmethod* nm, address* return_address_ptr) {
   ShouldNotReachHere();
 }
 
+void BarrierSetNMethod::arm(nmethod* nm, int value) {
+  ShouldNotReachHere();
+}
+
 void BarrierSetNMethod::disarm(nmethod* nm) {
   ShouldNotReachHere();
 }