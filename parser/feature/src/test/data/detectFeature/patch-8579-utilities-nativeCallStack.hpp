@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2014, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2014, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -64,7 +64,7 @@ class NativeCallStack : public StackObj {
     memset(_stack, 0, sizeof(_stack));
   }
 
-  NativeCallStack(int toSkip);
+  explicit NativeCallStack(int toSkip);
   NativeCallStack(address* pc, int frameCount);
 
   static inline const NativeCallStack& empty_stack() { return _empty_stack; }