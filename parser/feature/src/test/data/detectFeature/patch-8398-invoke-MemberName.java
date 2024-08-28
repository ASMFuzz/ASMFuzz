@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2008, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2008, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -153,7 +153,7 @@ public MethodType getMethodType() {
             } else if (type instanceof Object[] typeInfo) {
                 Class<?>[] ptypes = (Class<?>[]) typeInfo[1];
                 Class<?> rtype = (Class<?>) typeInfo[0];
-                MethodType res = MethodType.makeImpl(rtype, ptypes, true);
+                MethodType res = MethodType.methodType(rtype, ptypes, true);
                 type = res;
             }
             // Make sure type is a MethodType for racing threads.