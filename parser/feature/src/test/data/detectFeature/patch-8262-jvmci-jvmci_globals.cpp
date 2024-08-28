@@ -112,17 +112,19 @@ bool JVMCIGlobals::check_jvmci_flags_are_consistent() {
   }
   JVMCI_FLAG_CHECKED(EagerJVMCI)
 
-  CHECK_NOT_SET(JVMCIEventLogLevel,           EnableJVMCI)
-  CHECK_NOT_SET(JVMCITraceLevel,              EnableJVMCI)
-  CHECK_NOT_SET(JVMCICounterSize,             EnableJVMCI)
-  CHECK_NOT_SET(JVMCICountersExcludeCompiler, EnableJVMCI)
-  CHECK_NOT_SET(JVMCIUseFastLocking,          EnableJVMCI)
-  CHECK_NOT_SET(JVMCINMethodSizeLimit,        EnableJVMCI)
-  CHECK_NOT_SET(JVMCIPrintProperties,         EnableJVMCI)
-  CHECK_NOT_SET(UseJVMCINativeLibrary,        EnableJVMCI)
-  CHECK_NOT_SET(JVMCILibPath,                 EnableJVMCI)
-  CHECK_NOT_SET(JVMCINativeLibraryErrorFile,  EnableJVMCI)
-  CHECK_NOT_SET(JVMCILibDumpJNIConfig,        EnableJVMCI)
+  CHECK_NOT_SET(JVMCIEventLogLevel,                  EnableJVMCI)
+  CHECK_NOT_SET(JVMCITraceLevel,                     EnableJVMCI)
+  CHECK_NOT_SET(JVMCICounterSize,                    EnableJVMCI)
+  CHECK_NOT_SET(JVMCICountersExcludeCompiler,        EnableJVMCI)
+  CHECK_NOT_SET(JVMCIUseFastLocking,                 EnableJVMCI)
+  CHECK_NOT_SET(JVMCINMethodSizeLimit,               EnableJVMCI)
+  CHECK_NOT_SET(JVMCIPrintProperties,                EnableJVMCI)
+  CHECK_NOT_SET(JVMCIThreadsPerNativeLibraryRuntime, EnableJVMCI)
+  CHECK_NOT_SET(JVMCICompilerIdleDelay,              EnableJVMCI)
+  CHECK_NOT_SET(UseJVMCINativeLibrary,               EnableJVMCI)
+  CHECK_NOT_SET(JVMCILibPath,                        EnableJVMCI)
+  CHECK_NOT_SET(JVMCINativeLibraryErrorFile,         EnableJVMCI)
+  CHECK_NOT_SET(JVMCILibDumpJNIConfig,               EnableJVMCI)
 
 #ifndef COMPILER2
   JVMCI_FLAG_CHECKED(MaxVectorSize)
@@ -166,6 +168,8 @@ bool JVMCIGlobals::enable_jvmci_product_mode(JVMFlagOrigin origin) {
     "EnableJVMCI",
     "EnableJVMCIProduct",
     "UseJVMCICompiler",
+    "JVMCIThreadsPerNativeLibraryRuntime",
+    "JVMCICompilerIdleDelay",
     "JVMCIPrintProperties",
     "EagerJVMCI",
     "JVMCIThreads",