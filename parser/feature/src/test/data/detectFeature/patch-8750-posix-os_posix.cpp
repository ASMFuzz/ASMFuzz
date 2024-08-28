@@ -247,6 +247,25 @@ int os::create_file_for_heap(const char* dir) {
   return fd;
 }
 
+// Is a (classpath) directory empty?
+bool os::dir_is_empty(const char* path) {
+  DIR *dir = NULL;
+  struct dirent *ptr;
+
+  dir = ::opendir(path);
+  if (dir == NULL) return true;
+
+  // Scan the directory
+  bool result = true;
+  while (result && (ptr = ::readdir(dir)) != NULL) {
+    if (strcmp(ptr->d_name, ".") != 0 && strcmp(ptr->d_name, "..") != 0) {
+      result = false;
+    }
+  }
+  ::closedir(dir);
+  return result;
+}
+
 static char* reserve_mmapped_memory(size_t bytes, char* requested_addr) {
   char * addr;
   int flags = MAP_PRIVATE NOT_AIX( | MAP_NORESERVE ) | MAP_ANONYMOUS;