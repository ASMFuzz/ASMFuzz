@@ -32,6 +32,7 @@
  * @library /
  * @requires vm.bits == "64"
  * @requires os.family != "aix" & os.family != "windows"
+ * @requires vm.gc != "Z"
  * @run driver gc.arguments.TestUseCompressedOopsFlagsWithUlimit
  */
 