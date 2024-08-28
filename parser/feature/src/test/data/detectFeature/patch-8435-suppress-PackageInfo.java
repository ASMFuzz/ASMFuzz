@@ -25,6 +25,6 @@
  * @test
  * @bug 8021112
  * @summary Verify that deprecated warnings are printed correctly for package-info.java
- * @clean pack.package-info pack.DeprecatedClass
+ * @clean pack.*
  * @compile/ref=PackageInfo.out -source 8 -XDrawDiagnostics -Xlint:deprecation,-options pack/package-info.java pack/DeprecatedClass.java
  */