@@ -37,18 +37,18 @@
  * @run main/bootclasspath/othervm -XX:+UnlockDiagnosticVMOptions -XX:+WhiteBoxAPI -Xcomp
  *                                 -XX:CompileOnly=::get,::get1,::get2,::get3,::get4
  *                                 -XX:-TieredCompilation
- *                                 -XX:+FoldStableValues
+ *                                 -XX:-FoldStableValues
  *                                 compiler.stable.TestStableShort
  *
  * @run main/bootclasspath/othervm -XX:+UnlockDiagnosticVMOptions -XX:+WhiteBoxAPI -Xcomp
  *                                 -XX:CompileOnly=::get,::get1,::get2,::get3,::get4
- *                                 -XX:-TieredCompilation
+ *                                 -XX:+TieredCompilation -XX:TieredStopAtLevel=1
  *                                 -XX:+FoldStableValues
  *                                 compiler.stable.TestStableShort
  * @run main/bootclasspath/othervm -XX:+UnlockDiagnosticVMOptions -XX:+WhiteBoxAPI -Xcomp
  *                                 -XX:CompileOnly=::get,::get1,::get2,::get3,::get4
- *                                 -XX:-TieredCompilation
- *                                 -XX:+FoldStableValues
+ *                                 -XX:+TieredCompilation -XX:TieredStopAtLevel=1
+ *                                 -XX:-FoldStableValues
  *                                 compiler.stable.TestStableShort
  */
 