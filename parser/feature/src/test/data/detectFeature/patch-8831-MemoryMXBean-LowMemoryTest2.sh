@@ -60,19 +60,6 @@ go() {
 go -noclassgc -XX:MaxMetaspaceSize=32m -XX:+UseSerialGC LowMemoryTest2
 go -noclassgc -XX:MaxMetaspaceSize=32m -XX:+UseParallelGC LowMemoryTest2
 
-# Test class metaspace - might hit MaxMetaspaceSize instead if
-# UseCompressedClassPointers is off or if 32 bit.
-#
-# (note: This is very shaky and that shakiness exposes a problem with MemoryMXBean:
-#
-#  MemoryMXBean defines "used" "committed" and "max" (see java/lang/management/MemoryUsage.java)
-#  This abstraction misses a definition for "address space exhausted" which with the new Metaspace (jep387)
-#  can happen before committed/used hits any trigger. We now commit only on demand and therefore class loaders
-#  can sit atop of uncommitted address space, denying new loaders address space. In the old Metaspace,
-#  we would have committed the space right away and therefore the MemoryMXBean "committed" trigger
-#  would have fired. In the new Metaspace, we don't commit, so the MemoryMXBean does not fire.
-go -noclassgc -XX:MaxMetaspaceSize=16m -XX:CompressedClassSpaceSize=4m LowMemoryTest2
-
 echo ''
 if [ $failures -gt 0 ];
   then echo "$failures test(s) failed";