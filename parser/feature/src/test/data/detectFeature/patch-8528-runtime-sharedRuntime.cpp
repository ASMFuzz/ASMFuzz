@@ -1817,35 +1817,39 @@ methodHandle SharedRuntime::reresolve_call_site(TRAPS) {
     // CLEANUP - with lazy deopt shouldn't need this lock
     nmethodLocker nmlock(caller_nm);
 
+    // Check relocations for the matching call to 1) avoid false positives,
+    // and 2) determine the type.
     if (call_addr != NULL) {
+      // On x86 the logic for finding a call instruction is blindly checking for a call opcode 5
+      // bytes back in the instruction stream so we must also check for reloc info.
       RelocIterator iter(caller_nm, call_addr, call_addr+1);
-      int ret = iter.next(); // Get item
+      bool ret = iter.next(); // Get item
       if (ret) {
-        assert(iter.addr() == call_addr, "must find call");
-        if (iter.type() == relocInfo::static_call_type) {
-          is_static_call = true;
-        } else {
-          assert(iter.type() == relocInfo::virtual_call_type ||
-                 iter.type() == relocInfo::opt_virtual_call_type
-                , "unexpected relocInfo. type");
-        }
-      } else {
-        assert(!UseInlineCaches, "relocation info. must exist for this address");
-      }
-
-      // Cleaning the inline cache will force a new resolve. This is more robust
-      // than directly setting it to the new destination, since resolving of calls
-      // is always done through the same code path. (experience shows that it
-      // leads to very hard to track down bugs, if an inline cache gets updated
-      // to a wrong method). It should not be performance critical, since the
-      // resolve is only done once.
-
-      for (;;) {
-        ICRefillVerifier ic_refill_verifier;
-        if (!clear_ic_at_addr(caller_nm, call_addr, is_static_call)) {
-          InlineCacheBuffer::refill_ic_stubs();
-        } else {
-          break;
+        bool is_static_call = false;
+        switch (iter.type()) {
+          case relocInfo::static_call_type:
+            is_static_call = true;
+
+          case relocInfo::virtual_call_type:
+          case relocInfo::opt_virtual_call_type:
+            // Cleaning the inline cache will force a new resolve. This is more robust
+            // than directly setting it to the new destination, since resolving of calls
+            // is always done through the same code path. (experience shows that it
+            // leads to very hard to track down bugs, if an inline cache gets updated
+            // to a wrong method). It should not be performance critical, since the
+            // resolve is only done once.
+            guarantee(iter.addr() == call_addr, "must find call");
+            for (;;) {
+              ICRefillVerifier ic_refill_verifier;
+              if (!clear_ic_at_addr(caller_nm, call_addr, is_static_call)) {
+                InlineCacheBuffer::refill_ic_stubs();
+              } else {
+                break;
+              }
+            }
+            break;
+          default:
+            break;
         }
       }
     }