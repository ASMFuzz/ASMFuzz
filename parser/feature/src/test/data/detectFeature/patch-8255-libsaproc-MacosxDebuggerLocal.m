@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2002, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2002, 2022, Oracle and/or its affiliates. All rights reserved.
  * Copyright (c) 2021, Azul Systems, Inc. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
@@ -849,6 +849,9 @@ static bool ptrace_attach(pid_t pid) {
   return true;
 }
 
+#define GOT_HOTSPOT_TRAP (KERN_SUCCESS + 1)
+#define GOT_UNKNOWN_EXC  (KERN_SUCCESS + 2)
+
 kern_return_t catch_mach_exception_raise(
   mach_port_t exception_port, mach_port_t thread_port, mach_port_t task_port,
   exception_type_t exception_type, mach_exception_data_t codes,
@@ -858,6 +861,13 @@ kern_return_t catch_mach_exception_raise(
               "task port %d exc type = %d num_codes %d\n",
               exception_port, thread_port, task_port, exception_type, num_codes);
 
+  // Uncommon traps in the JVM can result in a "crash". We just ignore them.
+  // Returning a result other than KERN_SUCCESS means it will be passed on to the
+  // next handler, which should be in the JVM so it can do the right thing with it.
+  if (exception_type == EXC_BAD_INSTRUCTION || exception_type == EXC_BAD_ACCESS) {
+    return GOT_HOTSPOT_TRAP;
+  }
+
   // This message should denote a Unix soft signal, with
   // 1. the exception type = EXC_SOFTWARE
   // 2. codes[0] (which is the code) = EXC_SOFT_SIGNAL
@@ -867,9 +877,9 @@ kern_return_t catch_mach_exception_raise(
         codes[num_codes -1] == SIGSTOP)) {
     print_error("catch_mach_exception_raise: Message doesn't denote a Unix "
                 "soft signal. exception_type = %d, codes[0] = %d, "
-                "codes[num_codes -1] = %d, num_codes = %d\n",
+                "codes[num_codes -1] = 0x%llx, num_codes = %d\n",
                 exception_type, codes[0], codes[num_codes - 1], num_codes);
-    return MACH_RCV_INVALID_TYPE;
+    return GOT_UNKNOWN_EXC;
   }
   return KERN_SUCCESS;
 }
@@ -892,8 +902,12 @@ kern_return_t catch_mach_exception_raise_state_identity(
   return MACH_RCV_INVALID_TYPE;
 }
 
+#define WAIT_SUCCESS 0
+#define WAIT_RETRY   1
+#define WAIT_FAILURE 2
+
 // wait to receive an exception message
-static bool wait_for_exception() {
+static int wait_for_exception() {
   kern_return_t result;
 
   result = mach_msg(&exc_msg.header,
@@ -907,17 +921,21 @@ static bool wait_for_exception() {
   if (result != MACH_MSG_SUCCESS) {
     print_error("attach: wait_for_exception: mach_msg() failed: '%s' (%d)\n",
                 mach_error_string(result), result);
-    return false;
+    return WAIT_FAILURE;
   }
 
-  if (mach_exc_server(&exc_msg.header, &rep_msg.header) == false ||
-      rep_msg.ret_code != KERN_SUCCESS) {
-    print_error("attach: wait_for_exception: mach_exc_server failure\n");
-    if (rep_msg.ret_code != KERN_SUCCESS) {
-      print_error("catch_mach_exception_raise() failed '%s' (%d)\n",
-                  mach_error_string(rep_msg.ret_code), rep_msg.ret_code);
-    }
-    return false;
+  if (!mach_exc_server(&exc_msg.header, &rep_msg.header)) {
+    print_error("attach: wait_for_exception: mach_exc_server failed\n");
+    return WAIT_FAILURE;
+  }
+  if (rep_msg.ret_code == GOT_UNKNOWN_EXC) {
+    print_error("attach: wait_for_exception: catch_mach_exception_raise() got unknown exception type\n");
+    return WAIT_FAILURE;
+  }
+  if (rep_msg.ret_code == GOT_HOTSPOT_TRAP) {
+    // hotspot uncommon trap. Just retry.
+    print_debug("attach: wait_for_exception: retrying\n");
+    return WAIT_RETRY;
   }
 
   print_debug("reply msg from mach_exc_server: (msg->{bits = %#x, size = %u, "
@@ -926,7 +944,7 @@ static bool wait_for_exception() {
               rep_msg.header.msgh_remote_port, rep_msg.header.msgh_local_port,
               rep_msg.header.msgh_reserved, rep_msg.header.msgh_id);
 
-  return true;
+  return WAIT_SUCCESS;
 }
 
 /*
@@ -1020,7 +1038,14 @@ static bool wait_for_exception() {
     THROW_NEW_DEBUGGER_EXCEPTION("Can't ptrace attach to the process");
   }
 
-  if (wait_for_exception() != true) {
+  int retry_count = 0;
+  int wait_result;
+  do {
+    wait_result = wait_for_exception();
+  } while (wait_result == WAIT_RETRY && retry_count++ < 5);
+
+  if (wait_result != WAIT_SUCCESS) {
+    print_error("attach: wait_for_exception() failed. Retried %d times\n", retry_count);
     mach_port_deallocate(mach_task_self(), gTask);
     mach_port_deallocate(mach_task_self(), tgt_exception_port);
     THROW_NEW_DEBUGGER_EXCEPTION(