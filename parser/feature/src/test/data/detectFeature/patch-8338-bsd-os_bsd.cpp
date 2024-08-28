@@ -2475,27 +2475,6 @@ int os::loadavg(double loadavg[], int nelem) {
   return ::getloadavg(loadavg, nelem);
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
-      (void)::poll(NULL, 0, 100);
-    }
-  } else {
-    jio_fprintf(stderr,
-                "Could not open pause file '%s', continuing immediately.\n", filename);
-  }
-}
-
 // Get the kern.corefile setting, or otherwise the default path to the core file
 // Returns the length of the string
 int os::get_core_path(char* buffer, size_t bufferSize) {