@@ -350,3 +350,9 @@ int os::extra_bang_size_in_bytes() {
   // Zero does not require an additional stack bang.
   return 0;
 }
+
+#if defined(AARCH64) && defined(__APPLE__)
+void os::current_thread_enable_wx(WXMode mode) {
+  pthread_jit_write_protect_np(mode == WXExec);
+}
+#endif