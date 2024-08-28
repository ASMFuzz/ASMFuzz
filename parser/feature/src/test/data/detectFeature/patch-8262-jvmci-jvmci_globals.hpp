@@ -31,6 +31,7 @@
 class fileStream;
 
 #define LIBJVMCI_ERR_FILE "hs_err_pid%p_libjvmci.log"
+#define DEFAULT_COMPILER_IDLE_DELAY 1000
 
 //
 // Declare all global flags used by the JVMCI compiler. Only flags that need
@@ -57,6 +58,21 @@ class fileStream;
           "Use JVMCI as the default compiler. Defaults to true if "         \
           "EnableJVMCIProduct is true.")                                    \
                                                                             \
+  product(uint, JVMCIThreadsPerNativeLibraryRuntime, 0, EXPERIMENTAL,       \
+          "Max number of threads per JVMCI native runtime. "                \
+          "Specify 0 to force use of a single JVMCI native runtime. ")      \
+          range(0, max_jint)                                                \
+                                                                            \
+  product(uint, JVMCICompilerIdleDelay, DEFAULT_COMPILER_IDLE_DELAY, EXPERIMENTAL, \
+          "Number of milliseconds a JVMCI compiler queue should wait for "  \
+          "a compilation task before being considered idle. When a JVMCI "  \
+          "compiler queue becomes idle, it is detached from its JVMCIRuntime. "\
+          "Once the last thread is detached from a JVMCIRuntime, all "      \
+          "resources associated with the runtime are reclaimed. To use a "  \
+          "new runtime for every JVMCI compilation, set this value to 0 "   \
+          "and set JVMCIThreadsPerNativeLibraryRuntime to 1.")              \
+          range(0, max_jint)                                                \
+                                                                            \
   product(bool, JVMCIPrintProperties, false, EXPERIMENTAL,                  \
           "Prints properties used by the JVMCI compiler and exits")         \
                                                                             \