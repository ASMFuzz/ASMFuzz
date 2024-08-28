@@ -1416,14 +1416,24 @@ bool ObjectMonitor::check_owner(TRAPS) {
              "current thread is not owner", false);
 }
 
+static inline bool is_excluded(const Klass* monitor_klass) {
+  assert(monitor_klass != nullptr, "invariant");
+  NOT_JFR_RETURN_(false);
+  JFR_ONLY(return vmSymbols::jfr_chunk_rotation_monitor() == monitor_klass->name());
+}
+
 static void post_monitor_wait_event(EventJavaMonitorWait* event,
                                     ObjectMonitor* monitor,
                                     uint64_t notifier_tid,
                                     jlong timeout,
                                     bool timedout) {
   assert(event != NULL, "invariant");
   assert(monitor != NULL, "invariant");
-  event->set_monitorClass(monitor->object()->klass());
+  const Klass* monitor_klass = monitor->object()->klass();
+  if (is_excluded(monitor_klass)) {
+    return;
+  }
+  event->set_monitorClass(monitor_klass);
   event->set_timeout(timeout);
   // Set an address that is 'unique enough', such that events close in
   // time and with the same address are likely (but not guaranteed) to