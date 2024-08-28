@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -1429,7 +1429,7 @@ public static MBeanServer newMBeanServer(String defaultDomain,
 
         // This constructor happens to disregard the value of the interceptors
         // flag - that is, it always uses the default value - false.
-        // This is admitedly a bug, but we chose not to fix it for now
+        // This is admittedly a bug, but we chose not to fix it for now
         // since we would rather not have anybody depending on the Sun private
         // interceptor APIs - which is most probably going to be removed and
         // replaced by a public (javax) feature in the future.