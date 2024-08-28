@@ -2207,25 +2207,6 @@ int os::compare_file_modified_times(const char* file1, const char* file2) {
   return diff;
 }
 
-// Is a (classpath) directory empty?
-bool os::dir_is_empty(const char* path) {
-  DIR *dir = NULL;
-  struct dirent *ptr;
-
-  dir = opendir(path);
-  if (dir == NULL) return true;
-
-  // Scan the directory
-  bool result = true;
-  while (result && (ptr = readdir(dir)) != NULL) {
-    if (strcmp(ptr->d_name, ".") != 0 && strcmp(ptr->d_name, "..") != 0) {
-      result = false;
-    }
-  }
-  closedir(dir);
-  return result;
-}
-
 // This code originates from JDK's sysOpen and open64_w
 // from src/solaris/hpi/src/system_md.c
 