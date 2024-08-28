@@ -27,12 +27,12 @@
 /*
  * Header file to contain porting-relevant code which does not have a
  * home anywhere else.
- * This is intially based on hotspot/src/os/aix/vm/{loadlib,porting}_aix.{hpp,cpp}
+ * This is initially based on hotspot/src/os/aix/vm/{loadlib,porting}_aix.{hpp,cpp}
  */
 
 /*
  * Aix' own version of dladdr().
- * This function tries to mimick dladdr(3) on Linux
+ * This function tries to mimic dladdr(3) on Linux
  * (see http://linux.die.net/man/3/dladdr)
  * dladdr(3) is not POSIX but a GNU extension, and is not available on AIX.
  *
@@ -50,7 +50,7 @@
 
 typedef struct {
   const char *dli_fname; /* file path of loaded library */
-  void *dli_fbase;       /* doesn't make sence on AIX */
+  void *dli_fbase;       /* doesn't make sense on AIX */
   const char *dli_sname; /* symbol name; "" if not known */
   void *dli_saddr;       /* address of *entry* of function; not function descriptor; */
 } Dl_info;