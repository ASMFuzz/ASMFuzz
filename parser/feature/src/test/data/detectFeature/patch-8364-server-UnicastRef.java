@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1996, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -400,7 +400,7 @@ public void invoke(RemoteCall call) throws Exception {
         } catch (RuntimeException e) {
             /*
              * REMIND: Since runtime exceptions are no longer wrapped,
-             * we can't assue that the connection was left in
+             * we can't assume that the connection was left in
              * a reusable state. Is this okay?
              */
             clientRefLog.log(Log.BRIEF, "exception: ", e);