@@ -1097,39 +1097,19 @@ static size_t sharedmem_filesize(int fd, TRAPS) {
 
 // attach to a named shared memory region.
 //
-static void mmap_attach_shared(const char* user, int vmid, PerfMemory::PerfMemoryMode mode, char** addr, size_t* sizep, TRAPS) {
+static void mmap_attach_shared(const char* user, int vmid, char** addr, size_t* sizep, TRAPS) {
 
   char* mapAddress;
   int result;
   int fd;
   size_t size = 0;
   const char* luser = NULL;
 
-  int mmap_prot;
-  int file_flags;
+  int mmap_prot = PROT_READ;
+  int file_flags = O_RDONLY | O_NOFOLLOW;
 
   ResourceMark rm;
 
-  // map the high level access mode to the appropriate permission
-  // constructs for the file and the shared memory mapping.
-  if (mode == PerfMemory::PERF_MODE_RO) {
-    mmap_prot = PROT_READ;
-    file_flags = O_RDONLY | O_NOFOLLOW;
-  }
-  else if (mode == PerfMemory::PERF_MODE_RW) {
-#ifdef LATER
-    mmap_prot = PROT_READ | PROT_WRITE;
-    file_flags = O_RDWR | O_NOFOLLOW;
-#else
-    THROW_MSG(vmSymbols::java_lang_IllegalArgumentException(),
-              "Unsupported access mode");
-#endif
-  }
-  else {
-    THROW_MSG(vmSymbols::java_lang_IllegalArgumentException(),
-              "Illegal access mode");
-  }
-
   // for linux, determine if vmid is for a containerized process
   int nspid = LINUX_ONLY(os::Linux::get_namespace_pid(vmid)) NOT_LINUX(-1);
 
@@ -1288,15 +1268,15 @@ void PerfMemory::delete_memory_region() {
 // the indicated process's PerfData memory region into this JVMs
 // address space.
 //
-void PerfMemory::attach(const char* user, int vmid, PerfMemoryMode mode, char** addrp, size_t* sizep, TRAPS) {
+void PerfMemory::attach(const char* user, int vmid, char** addrp, size_t* sizep, TRAPS) {
 
   if (vmid == 0 || vmid == os::current_process_id()) {
      *addrp = start();
      *sizep = capacity();
      return;
   }
 
-  mmap_attach_shared(user, vmid, mode, addrp, sizep, CHECK);
+  mmap_attach_shared(user, vmid, addrp, sizep, CHECK);
 }
 
 // detach from the PerfData memory region of another JVM