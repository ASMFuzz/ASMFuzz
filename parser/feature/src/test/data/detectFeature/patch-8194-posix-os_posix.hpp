@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -104,6 +104,8 @@ class Posix {
   static bool handle_stack_overflow(JavaThread* thread, address addr, address pc,
                                     const void* ucVoid,
                                     address* stub);
+
+  static void print_active_locale(outputStream* st);
 };
 
 /*