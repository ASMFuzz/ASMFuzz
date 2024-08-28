@@ -29,7 +29,7 @@
 /*
  * Very limited AIX port of dladdr() for libjli.so.
  *
- * We try to mimick dladdr(3) on Linux (see http://linux.die.net/man/3/dladdr)
+ * We try to mimic dladdr(3) on Linux (see http://linux.die.net/man/3/dladdr)
  * dladdr(3) is not POSIX but a GNU extension, and is not available on AIX.
  *
  * We only support Dl_info.dli_fname here as this is the only thing that is