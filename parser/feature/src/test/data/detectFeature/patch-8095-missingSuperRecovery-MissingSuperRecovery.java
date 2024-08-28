@@ -5,7 +5,7 @@
  * class is no longer available during a subsequent compilation.
  * @author maddox
  * @build impl
- * @compile/fail/ref=MissingSuperRecovery.out --diags=layout=%b:%l:%_%m MissingSuperRecovery.java
+ * @compile/fail/ref=MissingSuperRecovery.out -XDrawDiagnostics MissingSuperRecovery.java
  */
 
 // Requires "golden" class file 'impl.class', which contains