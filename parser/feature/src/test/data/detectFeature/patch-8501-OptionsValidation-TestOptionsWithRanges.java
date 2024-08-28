@@ -257,6 +257,14 @@ public static void main(String[] args) throws Exception {
         excludeTestMaxRange("NonNMethodCodeHeapSize");
         excludeTestMaxRange("CodeCacheExpansionSize");
 
+        /*
+         * Exclude CompileThresholdScaling from max range testing, because
+         * it is expected to print "outside the allowed range" warnings for the
+         * scaled flag and the "outside the allowed range" warning does not
+         * refer to CompileThresholdScaling itself.
+         */
+        excludeTestMaxRange("CompileThresholdScaling");
+
         List<JVMOption> testSubset = getTestSubset(args);
 
         Asserts.assertGT(testSubset.size(), 0, "Options with ranges not found!");