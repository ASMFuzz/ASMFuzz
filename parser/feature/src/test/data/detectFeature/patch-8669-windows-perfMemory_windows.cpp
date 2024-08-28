@@ -1573,26 +1573,12 @@ static size_t sharedmem_filesize(const char* filename, TRAPS) {
 // this method opens a file mapping object and maps the object
 // into the address space of the process
 //
-static void open_file_mapping(const char* user, int vmid, char** addrp, size_t* sizep, TRAPS) {
+static void open_file_mapping(int vmid, char** addrp, size_t* sizep, TRAPS) {
 
   ResourceMark rm;
-
-  void *mapAddress = 0;
-  size_t size = 0;
-  HANDLE fmh;
   DWORD ofm_access = FILE_MAP_READ;
   DWORD mv_access = FILE_MAP_READ;
-  const char* luser = NULL;
-
-
-  // if a user name wasn't specified, then find the user name for
-  // the owner of the target vm.
-  if (user == NULL || strlen(user) == 0) {
-    luser = get_user_name(vmid);
-  }
-  else {
-    luser = user;
-  }
+  const char* luser = get_user_name(vmid);
 
   if (luser == NULL) {
     THROW_MSG(vmSymbols::java_lang_IllegalArgumentException(),
@@ -1607,7 +1593,7 @@ static void open_file_mapping(const char* user, int vmid, char** addrp, size_t*
   //
   if (!is_directory_secure(dirname)) {
     FREE_C_HEAP_ARRAY(char, dirname);
-    if (luser != user) FREE_C_HEAP_ARRAY(char, luser);
+    FREE_C_HEAP_ARRAY(char, luser);
     THROW_MSG(vmSymbols::java_lang_IllegalArgumentException(),
               "Process not found");
   }
@@ -1626,11 +1612,12 @@ static void open_file_mapping(const char* user, int vmid, char** addrp, size_t*
   strcpy(robjectname, objectname);
 
   // free the c heap resources that are no longer needed
-  if (luser != user) FREE_C_HEAP_ARRAY(char, luser);
+  FREE_C_HEAP_ARRAY(char, luser);
   FREE_C_HEAP_ARRAY(char, dirname);
   FREE_C_HEAP_ARRAY(char, filename);
   FREE_C_HEAP_ARRAY(char, objectname);
 
+  size_t size;
   if (*sizep == 0) {
     size = sharedmem_filesize(rfilename, CHECK);
   } else {
@@ -1640,12 +1627,11 @@ static void open_file_mapping(const char* user, int vmid, char** addrp, size_t*
   assert(size > 0, "unexpected size <= 0");
 
   // Open the file mapping object with the given name
-  fmh = open_sharedmem_object(robjectname, ofm_access, CHECK);
-
+  HANDLE fmh = open_sharedmem_object(robjectname, ofm_access, CHECK);
   assert(fmh != INVALID_HANDLE_VALUE, "unexpected handle value");
 
   // map the entire file into the address space
-  mapAddress = MapViewOfFile(
+  void* mapAddress = MapViewOfFile(
                  fmh,             /* HANDLE Handle of file mapping object */
                  mv_access,       /* DWORD access flags */
                  0,               /* DWORD High word of offset */
@@ -1777,16 +1763,15 @@ void PerfMemory::delete_memory_region() {
 // the indicated process's PerfData memory region into this JVMs
 // address space.
 //
-void PerfMemory::attach(const char* user, int vmid,
-                        char** addrp, size_t* sizep, TRAPS) {
+void PerfMemory::attach(int vmid, char** addrp, size_t* sizep, TRAPS) {
 
   if (vmid == 0 || vmid == os::current_process_id()) {
      *addrp = start();
      *sizep = capacity();
      return;
   }
 
-  open_file_mapping(user, vmid, addrp, sizep, CHECK);
+  open_file_mapping(vmid, addrp, sizep, CHECK);
 }
 
 // detach from the PerfData memory region of another JVM