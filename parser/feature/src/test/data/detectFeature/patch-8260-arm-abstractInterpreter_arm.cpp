@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2008, 2017, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2008, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -86,7 +86,7 @@ int AbstractInterpreter::size_activation(int max_stack,
   // fixed size of an interpreter frame:
   int overhead = frame::sender_sp_offset - frame::interpreter_frame_initial_sp_offset;
 
-  // Our locals were accounted for by the caller (or last_frame_adjust on the transistion)
+  // Our locals were accounted for by the caller (or last_frame_adjust on the transition)
   // Since the callee parameters already account for the callee's params we only need to account for
   // the extra locals.
 