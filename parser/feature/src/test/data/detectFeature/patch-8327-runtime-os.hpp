@@ -550,7 +550,6 @@ class os: AllStatic {
   static char* native_path(char *path);
   static int ftruncate(int fd, jlong length);
   static int fsync(int fd);
-  static int available(int fd, jlong *bytes);
   static int get_fileno(FILE* fp);
   static void flockfile(FILE* fp);
   static void funlockfile(FILE* fp);