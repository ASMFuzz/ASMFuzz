@@ -5281,27 +5281,6 @@ bool os::pd_unmap_memory(char* addr, size_t bytes) {
   return true;
 }
 
-void os::pause() {
-  char filename[MAX_PATH];
-  if (PauseAtStartupFile && PauseAtStartupFile[0]) {
-    jio_snprintf(filename, MAX_PATH, "%s", PauseAtStartupFile);
-  } else {
-    jio_snprintf(filename, MAX_PATH, "./vm.paused.%d", current_process_id());
-  }
-
-  int fd = ::open(filename, O_WRONLY | O_CREAT | O_TRUNC, 0666);
-  if (fd != -1) {
-    struct stat buf;
-    ::close(fd);
-    while (::stat(filename, &buf) == 0) {
-      Sleep(100);
-    }
-  } else {
-    jio_fprintf(stderr,
-                "Could not open pause file '%s', continuing immediately.\n", filename);
-  }
-}
-
 Thread* os::ThreadCrashProtection::_protected_thread = NULL;
 os::ThreadCrashProtection* os::ThreadCrashProtection::_crash_protection = NULL;
 