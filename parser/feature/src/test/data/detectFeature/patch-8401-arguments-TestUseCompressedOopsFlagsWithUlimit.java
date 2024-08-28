@@ -31,7 +31,8 @@
  * @library /test/lib
  * @library /
  * @requires vm.bits == "64"
- * @requires os.family != "aix" & os.family != "windows"
+ * @requires os.family == "linux"
+ * @requires vm.gc != "Z"
  * @run driver gc.arguments.TestUseCompressedOopsFlagsWithUlimit
  */
 