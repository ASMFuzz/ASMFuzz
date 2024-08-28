@@ -1573,36 +1573,17 @@ static size_t sharedmem_filesize(const char* filename, TRAPS) {
 // this method opens a file mapping object and maps the object
 // into the address space of the process
 //
-static void open_file_mapping(const char* user, int vmid,
-                              PerfMemory::PerfMemoryMode mode,
-                              char** addrp, size_t* sizep, TRAPS) {
+static void open_file_mapping(const char* user, int vmid, char** addrp, size_t* sizep, TRAPS) {
 
   ResourceMark rm;
 
   void *mapAddress = 0;
   size_t size = 0;
   HANDLE fmh;
-  DWORD ofm_access;
-  DWORD mv_access;
+  DWORD ofm_access = FILE_MAP_READ;
+  DWORD mv_access = FILE_MAP_READ;
   const char* luser = NULL;
 
-  if (mode == PerfMemory::PERF_MODE_RO) {
-    ofm_access = FILE_MAP_READ;
-    mv_access = FILE_MAP_READ;
-  }
-  else if (mode == PerfMemory::PERF_MODE_RW) {
-#ifdef LATER
-    ofm_access = FILE_MAP_READ | FILE_MAP_WRITE;
-    mv_access = FILE_MAP_READ | FILE_MAP_WRITE;
-#else
-    THROW_MSG(vmSymbols::java_lang_IllegalArgumentException(),
-              "Unsupported access mode");
-#endif
-  }
-  else {
-    THROW_MSG(vmSymbols::java_lang_IllegalArgumentException(),
-              "Illegal access mode");
-  }
 
   // if a user name wasn't specified, then find the user name for
   // the owner of the target vm.
@@ -1796,7 +1777,7 @@ void PerfMemory::delete_memory_region() {
 // the indicated process's PerfData memory region into this JVMs
 // address space.
 //
-void PerfMemory::attach(const char* user, int vmid, PerfMemoryMode mode,
+void PerfMemory::attach(const char* user, int vmid,
                         char** addrp, size_t* sizep, TRAPS) {
 
   if (vmid == 0 || vmid == os::current_process_id()) {
@@ -1805,7 +1786,7 @@ void PerfMemory::attach(const char* user, int vmid, PerfMemoryMode mode,
      return;
   }
 
-  open_file_mapping(user, vmid, mode, addrp, sizep, CHECK);
+  open_file_mapping(user, vmid, addrp, sizep, CHECK);
 }
 
 // detach from the PerfData memory region of another JVM