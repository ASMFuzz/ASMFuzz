@@ -1625,17 +1625,16 @@ class CleanupDumpTimeLambdaProxyClassTable: StackObj {
   bool do_entry(LambdaProxyClassKey& key, DumpTimeLambdaProxyClassInfo& info) {
     assert_lock_strong(DumpTimeTable_lock);
     InstanceKlass* caller_ik = key.caller_ik();
-    if (SystemDictionaryShared::check_for_exclusion(caller_ik, NULL)) {
-      // If the caller class is excluded, unregister all the associated lambda proxy classes
-      // so that they will not be included in the CDS archive.
-      for (int i = info._proxy_klasses->length() - 1; i >= 0; i--) {
-        SystemDictionaryShared::reset_registered_lambda_proxy_class(info._proxy_klasses->at(i));
-        info._proxy_klasses->remove_at(i);
-      }
-    }
+    InstanceKlass* nest_host = caller_ik->nest_host_not_null();
+
+    // If the caller class and/or nest_host are excluded, the associated lambda proxy
+    // must also be excluded.
+    bool always_exclude = SystemDictionaryShared::check_for_exclusion(caller_ik, NULL) ||
+                          SystemDictionaryShared::check_for_exclusion(nest_host, NULL);
+
     for (int i = info._proxy_klasses->length() - 1; i >= 0; i--) {
       InstanceKlass* ik = info._proxy_klasses->at(i);
-      if (SystemDictionaryShared::check_for_exclusion(ik, NULL)) {
+      if (always_exclude || SystemDictionaryShared::check_for_exclusion(ik, NULL)) {
         SystemDictionaryShared::reset_registered_lambda_proxy_class(ik);
         info._proxy_klasses->remove_at(i);
       }