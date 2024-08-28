@@ -102,6 +102,7 @@
 #include <psapi.h>
 #include <mmsystem.h>
 #include <winsock2.h>
+#include <versionhelpers.h>
 
 // for timer info max values which include all bits
 #define ALL_64_BITS CONST64(-1)
@@ -1759,21 +1760,11 @@ void os::print_os_info(outputStream* st) {
 }
 
 void os::win32::print_windows_version(outputStream* st) {
-  OSVERSIONINFOEX osvi;
   VS_FIXEDFILEINFO *file_info;
   TCHAR kernel32_path[MAX_PATH];
   UINT len, ret;
 
-  // Use the GetVersionEx information to see if we're on a server or
-  // workstation edition of Windows. Starting with Windows 8.1 we can't
-  // trust the OS version information returned by this API.
-  ZeroMemory(&osvi, sizeof(OSVERSIONINFOEX));
-  osvi.dwOSVersionInfoSize = sizeof(OSVERSIONINFOEX);
-  if (!GetVersionEx((OSVERSIONINFO *)&osvi)) {
-    st->print_cr("Call to GetVersionEx failed");
-    return;
-  }
-  bool is_workstation = (osvi.wProductType == VER_NT_WORKSTATION);
+  bool is_workstation = !IsWindowsServer();
 
   // Get the full path to \Windows\System32\kernel32.dll and use that for
   // determining what version of Windows we're running on.
@@ -3916,21 +3907,7 @@ void os::win32::initialize_system_info() {
     FLAG_SET_DEFAULT(MaxRAM, MIN2(MaxRAM, (uint64_t) ms.ullTotalVirtual));
   }
 
-  OSVERSIONINFOEX oi;
-  oi.dwOSVersionInfoSize = sizeof(OSVERSIONINFOEX);
-  GetVersionEx((OSVERSIONINFO*)&oi);
-  switch (oi.dwPlatformId) {
-  case VER_PLATFORM_WIN32_NT:
-    {
-      int os_vers = oi.dwMajorVersion * 1000 + oi.dwMinorVersion;
-      if (oi.wProductType == VER_NT_DOMAIN_CONTROLLER ||
-          oi.wProductType == VER_NT_SERVER) {
-        _is_windows_server = true;
-      }
-    }
-    break;
-  default: fatal("Unknown platform");
-  }
+  _is_windows_server = IsWindowsServer();
 
   initialize_performance_counter();
 }