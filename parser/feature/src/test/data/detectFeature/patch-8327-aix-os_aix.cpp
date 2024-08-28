@@ -2603,35 +2603,6 @@ jlong os::seek_to_file_offset(int fd, jlong offset) {
   return (jlong)::lseek64(fd, (off64_t)offset, SEEK_SET);
 }
 
-// This code originates from JDK's sysAvailable
-// from src/solaris/hpi/src/native_threads/src/sys_api_td.c
-
-int os::available(int fd, jlong *bytes) {
-  jlong cur, end;
-  int mode;
-  struct stat64 buf64;
-
-  if (::fstat64(fd, &buf64) >= 0) {
-    mode = buf64.st_mode;
-    if (S_ISCHR(mode) || S_ISFIFO(mode) || S_ISSOCK(mode)) {
-      int n;
-      if (::ioctl(fd, FIONREAD, &n) >= 0) {
-        *bytes = n;
-        return 1;
-      }
-    }
-  }
-  if ((cur = ::lseek64(fd, 0L, SEEK_CUR)) == -1) {
-    return 0;
-  } else if ((end = ::lseek64(fd, 0L, SEEK_END)) == -1) {
-    return 0;
-  } else if (::lseek64(fd, cur, SEEK_SET) == -1) {
-    return 0;
-  }
-  *bytes = end - cur;
-  return 1;
-}
-
 // Map a block of memory.
 char* os::pd_map_memory(int fd, const char* file_name, size_t file_offset,
                         char *addr, size_t bytes, bool read_only,