@@ -1097,13 +1097,7 @@ static size_t sharedmem_filesize(int fd, TRAPS) {
 
 // attach to a named shared memory region.
 //
-static void mmap_attach_shared(const char* user, int vmid, char** addr, size_t* sizep, TRAPS) {
-
-  char* mapAddress;
-  int result;
-  int fd;
-  size_t size = 0;
-  const char* luser = NULL;
+static void mmap_attach_shared(int vmid, char** addr, size_t* sizep, TRAPS) {
 
   int mmap_prot = PROT_READ;
   int file_flags = O_RDONLY | O_NOFOLLOW;
@@ -1112,13 +1106,7 @@ static void mmap_attach_shared(const char* user, int vmid, char** addr, size_t*
 
   // for linux, determine if vmid is for a containerized process
   int nspid = LINUX_ONLY(os::Linux::get_namespace_pid(vmid)) NOT_LINUX(-1);
-
-  if (user == NULL || strlen(user) == 0) {
-    luser = get_user_name(vmid, &nspid, CHECK);
-  }
-  else {
-    luser = user;
-  }
+  const char* luser = get_user_name(vmid, &nspid, CHECK);
 
   if (luser == NULL) {
     THROW_MSG(vmSymbols::java_lang_IllegalArgumentException(),
@@ -1132,9 +1120,7 @@ static void mmap_attach_shared(const char* user, int vmid, char** addr, size_t*
   //
   if (!is_directory_secure(dirname)) {
     FREE_C_HEAP_ARRAY(char, dirname);
-    if (luser != user) {
-      FREE_C_HEAP_ARRAY(char, luser);
-    }
+    FREE_C_HEAP_ARRAY(char, luser);
     THROW_MSG(vmSymbols::java_lang_IllegalArgumentException(),
               "Process not found");
   }
@@ -1149,12 +1135,12 @@ static void mmap_attach_shared(const char* user, int vmid, char** addr, size_t*
   strcpy(rfilename, filename);
 
   // free the c heap resources that are no longer needed
-  if (luser != user) FREE_C_HEAP_ARRAY(char, luser);
+  FREE_C_HEAP_ARRAY(char, luser);
   FREE_C_HEAP_ARRAY(char, dirname);
   FREE_C_HEAP_ARRAY(char, filename);
 
   // open the shared memory file for the give vmid
-  fd = open_sharedmem_file(rfilename, file_flags, THREAD);
+  int fd = open_sharedmem_file(rfilename, file_flags, THREAD);
 
   if (fd == OS_ERR) {
     return;
@@ -1165,6 +1151,7 @@ static void mmap_attach_shared(const char* user, int vmid, char** addr, size_t*
     return;
   }
 
+  size_t size;
   if (*sizep == 0) {
     size = sharedmem_filesize(fd, CHECK);
   } else {
@@ -1173,9 +1160,9 @@ static void mmap_attach_shared(const char* user, int vmid, char** addr, size_t*
 
   assert(size > 0, "unexpected size <= 0");
 
-  mapAddress = (char*)::mmap((char*)0, size, mmap_prot, MAP_SHARED, fd, 0);
+  char* mapAddress = (char*)::mmap((char*)0, size, mmap_prot, MAP_SHARED, fd, 0);
 
-  result = ::close(fd);
+  int result = ::close(fd);
   assert(result != OS_ERR, "could not close file");
 
   if (mapAddress == MAP_FAILED) {
@@ -1268,15 +1255,15 @@ void PerfMemory::delete_memory_region() {
 // the indicated process's PerfData memory region into this JVMs
 // address space.
 //
-void PerfMemory::attach(const char* user, int vmid, char** addrp, size_t* sizep, TRAPS) {
+void PerfMemory::attach(int vmid, char** addrp, size_t* sizep, TRAPS) {
 
   if (vmid == 0 || vmid == os::current_process_id()) {
      *addrp = start();
      *sizep = capacity();
      return;
   }
 
-  mmap_attach_shared(user, vmid, addrp, sizep, CHECK);
+  mmap_attach_shared(vmid, addrp, sizep, CHECK);
 }
 
 // detach from the PerfData memory region of another JVM