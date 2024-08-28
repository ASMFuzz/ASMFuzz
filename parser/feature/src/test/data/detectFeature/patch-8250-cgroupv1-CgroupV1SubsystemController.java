@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -80,9 +80,9 @@ public static long getLongEntry(CgroupSubsystemController controller, String par
                                                       CgroupSubsystem.LONG_RETVAL_UNLIMITED /* retval on error */);
     }
 
-    public static double getDoubleValue(CgroupSubsystemController controller, String parm) {
+    public static double getDoubleValue(CgroupSubsystemController controller, String param) {
         return CgroupSubsystemController.getDoubleValue(controller,
-                                                        parm,
+                                                        param,
                                                         DOUBLE_RETVAL_UNLIMITED /* retval on error */);
     }
 