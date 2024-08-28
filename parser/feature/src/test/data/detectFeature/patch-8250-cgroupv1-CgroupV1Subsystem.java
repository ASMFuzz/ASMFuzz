@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -185,9 +185,9 @@ private void setPidsController(CgroupV1SubsystemController pids) {
     }
 
     private static long getLongValue(CgroupSubsystemController controller,
-                              String parm) {
+                              String param) {
         return CgroupSubsystemController.getLongValue(controller,
-                                                      parm,
+                                                      param,
                                                       CgroupV1SubsystemController::convertStringToLong,
                                                       CgroupSubsystem.LONG_RETVAL_UNLIMITED);
     }