@@ -33,6 +33,7 @@
  * @requires vm.bits == "64"
  * @requires os.family == "linux"
  * @requires vm.gc != "Z"
+ * @requires vm.opt.UseCompressedOops == null
  * @run driver gc.arguments.TestUseCompressedOopsFlagsWithUlimit
  */
 