@@ -2834,26 +2834,6 @@ int os::loadavg(double values[], int nelem) {
   }
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
-    trcVerbose("Could not open pause file '%s', continuing immediately.", filename);
-  }
-}
-
 bool os::is_primordial_thread(void) {
   if (pthread_self() == (pthread_t)1) {
     return true;