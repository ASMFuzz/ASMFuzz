@@ -2185,6 +2185,19 @@ void os::Linux::print_uptime_info(outputStream* st) {
   }
 }
 
+static void print_container_helper(outputStream* st, jlong j, const char* metrics) {
+  st->print("%s: ", metrics);
+  if (j > 0) {
+    if (j >= 1024) {
+      st->print_cr(UINT64_FORMAT " k", uint64_t(j) / 1024);
+    } else {
+      st->print_cr(UINT64_FORMAT, uint64_t(j));
+    }
+  } else {
+    st->print_cr("%s", j == OSCONTAINER_ERROR ? "not supported" : "unlimited");
+  }
+}
+
 bool os::Linux::print_container_info(outputStream* st) {
   if (!OSContainer::is_containerized()) {
     st->print_cr("container information not found.");
@@ -2240,55 +2253,21 @@ bool os::Linux::print_container_info(outputStream* st) {
     st->print_cr("%s", i == OSCONTAINER_ERROR ? "not supported" : "no shares");
   }
 
-  jlong j = OSContainer::memory_limit_in_bytes();
-  st->print("memory_limit_in_bytes: ");
-  if (j > 0) {
-    st->print_cr(JLONG_FORMAT, j);
-  } else {
-    st->print_cr("%s", j == OSCONTAINER_ERROR ? "not supported" : "unlimited");
-  }
-
-  j = OSContainer::memory_and_swap_limit_in_bytes();
-  st->print("memory_and_swap_limit_in_bytes: ");
-  if (j > 0) {
-    st->print_cr(JLONG_FORMAT, j);
-  } else {
-    st->print_cr("%s", j == OSCONTAINER_ERROR ? "not supported" : "unlimited");
-  }
-
-  j = OSContainer::memory_soft_limit_in_bytes();
-  st->print("memory_soft_limit_in_bytes: ");
-  if (j > 0) {
-    st->print_cr(JLONG_FORMAT, j);
-  } else {
-    st->print_cr("%s", j == OSCONTAINER_ERROR ? "not supported" : "unlimited");
-  }
-
-  j = OSContainer::OSContainer::memory_usage_in_bytes();
-  st->print("memory_usage_in_bytes: ");
-  if (j > 0) {
-    st->print_cr(JLONG_FORMAT, j);
-  } else {
-    st->print_cr("%s", j == OSCONTAINER_ERROR ? "not supported" : "unlimited");
-  }
-
-  j = OSContainer::OSContainer::memory_max_usage_in_bytes();
-  st->print("memory_max_usage_in_bytes: ");
-  if (j > 0) {
-    st->print_cr(JLONG_FORMAT, j);
-  } else {
-    st->print_cr("%s", j == OSCONTAINER_ERROR ? "not supported" : "unlimited");
-  }
+  print_container_helper(st, OSContainer::memory_limit_in_bytes(), "memory_limit_in_bytes");
+  print_container_helper(st, OSContainer::memory_and_swap_limit_in_bytes(), "memory_and_swap_limit_in_bytes");
+  print_container_helper(st, OSContainer::memory_soft_limit_in_bytes(), "memory_soft_limit_in_bytes");
+  print_container_helper(st, OSContainer::memory_usage_in_bytes(), "memory_usage_in_bytes");
+  print_container_helper(st, OSContainer::memory_max_usage_in_bytes(), "memory_max_usage_in_bytes");
 
-  j = OSContainer::OSContainer::pids_max();
+  jlong j = OSContainer::pids_max();
   st->print("maximum number of tasks: ");
   if (j > 0) {
     st->print_cr(JLONG_FORMAT, j);
   } else {
     st->print_cr("%s", j == OSCONTAINER_ERROR ? "not supported" : "unlimited");
   }
 
-  j = OSContainer::OSContainer::pids_current();
+  j = OSContainer::pids_current();
   st->print("current number of tasks: ");
   if (j > 0) {
     st->print_cr(JLONG_FORMAT, j);