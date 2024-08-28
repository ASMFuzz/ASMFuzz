@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2011, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2011, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -622,7 +622,7 @@ MethodType methodType() {
         for (int i = 0; i < arity; ++i) {
             ptypes[i] = parameterType(i).btClass;
         }
-        return MethodType.makeImpl(returnType().btClass, ptypes, true);
+        return MethodType.methodType(returnType().btClass, ptypes, true);
     }
 
     /** Return ABC_Z, where the ABC are parameter type characters, and Z is the return type character. */