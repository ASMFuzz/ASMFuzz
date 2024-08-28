@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2017, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2017, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -276,7 +276,7 @@ public synchronized void loadPasswords()
                     hasClearPasswords.set(true);
                     if (logger.debugOn()) {
                         logger.debug("loadPasswords",
-                                "Found atleast one clear password");
+                                "Found at least one clear password");
                     }
                     break;
                 }