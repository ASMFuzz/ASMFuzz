@@ -143,7 +143,7 @@ class PerfMemory : AllStatic {
 
     // methods for attaching to and detaching from the PerfData
     // memory segment of another JVM process on the same system.
-    static void attach(const char* user, int vmid, char** addrp, size_t* size, TRAPS);
+    static void attach(int vmid, char** addrp, size_t* size, TRAPS);
     static void detach(char* addr, size_t bytes);
 
     static void initialize();