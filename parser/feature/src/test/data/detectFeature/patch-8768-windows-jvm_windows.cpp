@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1998, 2010, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1998, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -56,7 +56,7 @@ JVM_ENTRY_NO_ENV(void*, JVM_RegisterSignal(jint sig, void* handler))
 
     /* The following signals are used for Shutdown Hooks support. However, if
        ReduceSignalUsage (-Xrs) is set, Shutdown Hooks must be invoked via
-       System.exit(), Java is not allowed to use these signals, and the the
+       System.exit(), Java is not allowed to use these signals, and the
        user is allowed to set his own _native_ handler for these signals and
        invoke System.exit() as needed. Terminator.setup() is avoiding
        registration of these signals when -Xrs is present. */
@@ -87,5 +87,3 @@ JVM_ENTRY_NO_ENV(jboolean, JVM_RaiseSignal(jint sig))
   os::signal_raise(sig);
   return JNI_TRUE;
 JVM_END
-
-