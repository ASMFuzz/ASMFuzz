@@ -72,6 +72,10 @@
 #include "utilities/events.hpp"
 #include "utilities/powerOfTwo.hpp"
 
+#ifndef _WINDOWS
+# include <poll.h>
+#endif
+
 # include <signal.h>
 # include <errno.h>
 
@@ -1416,6 +1420,35 @@ size_t os::page_size_for_region_unaligned(size_t region_size, size_t min_pages)
   return page_size_for_region(region_size, min_pages, false);
 }
 
+#ifndef MAX_PATH
+#define MAX_PATH    (2 * K)
+#endif
+
+void os::pause() {
+  char filename[MAX_PATH];
+  if (PauseAtStartupFile && PauseAtStartupFile[0]) {
+    jio_snprintf(filename, MAX_PATH, "%s", PauseAtStartupFile);
+  } else {
+    jio_snprintf(filename, MAX_PATH, "./vm.paused.%d", current_process_id());
+  }
+
+  int fd = ::open(filename, O_WRONLY | O_CREAT | O_TRUNC, 0666);
+  if (fd != -1) {
+    struct stat buf;
+    ::close(fd);
+    while (::stat(filename, &buf) == 0) {
+#if defined(_WINDOWS)
+      Sleep(100);
+#else
+      (void)::poll(NULL, 0, 100);
+#endif
+    }
+  } else {
+    jio_fprintf(stderr,
+                "Could not open pause file '%s', continuing immediately.\n", filename);
+  }
+}
+
 static const char* errno_to_string (int e, bool short_text) {
   #define ALL_SHARED_ENUMS(X) \
     X(E2BIG, "Argument list too long") \