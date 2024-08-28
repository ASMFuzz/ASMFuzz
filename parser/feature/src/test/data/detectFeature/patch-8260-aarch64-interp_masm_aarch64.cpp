@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2014, 2020, Red Hat Inc. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
@@ -523,7 +523,7 @@ void InterpreterMacroAssembler::dispatch_via(TosState state, address* table) {
 //
 // Apply stack watermark barrier.
 // Unlock the receiver if this is a synchronized method.
-// Unlock any Java monitors from syncronized blocks.
+// Unlock any Java monitors from synchronized blocks.
 // Remove the activation from the stack.
 //
 // If there are locked Java monitors
@@ -1748,7 +1748,7 @@ void InterpreterMacroAssembler::profile_return_type(Register mdp, Register ret,
 
       // If we don't profile all invoke bytecodes we must make sure
       // it's a bytecode we indeed profile. We can't go back to the
-      // begining of the ProfileData we intend to update to check its
+      // beginning of the ProfileData we intend to update to check its
       // type because we're right after it and we don't known its
       // length
       Label do_profile;