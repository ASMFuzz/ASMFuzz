@@ -667,7 +667,7 @@ static void cleanup_sharedmem_resources(const char* dirname) {
     // indicates that it is still running, the file file resources
     // are not removed. If the process id is invalid, or if we don't
     // have permissions to check the process status, or if the process
-    // id is valid and the process has terminated, the the file resources
+    // id is valid and the process has terminated, the file resources
     // are assumed to be stale and are removed.
     //
     if (pid == os::current_process_id() || !is_alive(pid)) {
@@ -1663,7 +1663,7 @@ static void open_file_mapping(int vmid, char** addrp, size_t* sizep, TRAPS) {
                           INTPTR_FORMAT, size, vmid, mapAddress);
 }
 
-// this method unmaps the the mapped view of the the
+// this method unmaps the mapped view of the
 // file mapping object.
 //
 static void remove_file_mapping(char* addr) {