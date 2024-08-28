@@ -32,7 +32,6 @@
  * @requires vm.opt.final.ClassUnloading
  * @library /vmTestbase /test/lib
  * @run main/othervm
- *      -DrequiresCompressedClassSpace=true
  *      -XX:MaxMetaspaceSize=100m
  *      -XX:CompressedClassSpaceSize=10m
  *      -Xlog:gc*:gc.log