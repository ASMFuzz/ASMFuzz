@@ -53,6 +53,7 @@
 #include <dirent.h>
 #include <dlfcn.h>
 #include <grp.h>
+#include <locale.h>
 #include <netdb.h>
 #include <pwd.h>
 #include <pthread.h>
@@ -548,6 +549,33 @@ void os::Posix::print_user_info(outputStream* st) {
   st->cr();
 }
 
+// Print all active locale categories, one line each
+void os::Posix::print_active_locale(outputStream* st) {
+  st->print_cr("Active Locale:");
+  // Posix is quiet about how exactly LC_ALL is implemented.
+  // Just print it out too, in case LC_ALL is held separately
+  // from the individual categories.
+  #define LOCALE_CAT_DO(f) \
+    f(LC_ALL) \
+    f(LC_COLLATE) \
+    f(LC_CTYPE) \
+    f(LC_MESSAGES) \
+    f(LC_MONETARY) \
+    f(LC_NUMERIC) \
+    f(LC_TIME)
+  #define XX(cat) { cat, #cat },
+  const struct { int c; const char* name; } categories[] = {
+      LOCALE_CAT_DO(XX)
+      { -1, NULL }
+  };
+  #undef XX
+  #undef LOCALE_CAT_DO
+  for (int i = 0; categories[i].c != -1; i ++) {
+    const char* locale = setlocale(categories[i].c, NULL);
+    st->print_cr("%s=%s", categories[i].name,
+                 ((locale != NULL) ? locale : "<unknown>"));
+  }
+}
 
 bool os::get_host_name(char* buf, size_t buflen) {
   struct utsname name;