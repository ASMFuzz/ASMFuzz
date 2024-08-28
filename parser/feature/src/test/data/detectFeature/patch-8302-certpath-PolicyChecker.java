@@ -93,7 +93,7 @@ class PolicyChecker extends PKIXCertPathChecker {
         if (initialPolicies.isEmpty()) {
             // if no initialPolicies are specified by user, set
             // initPolicies to be anyPolicy by default
-            this.initPolicies = new HashSet<String>(1);
+            this.initPolicies = HashSet.newHashSet(1);
             this.initPolicies.add(ANY_POLICY);
         } else {
             this.initPolicies = new HashSet<String>(initialPolicies);
@@ -154,7 +154,7 @@ public boolean isForwardCheckingSupported() {
     @Override
     public Set<String> getSupportedExtensions() {
         if (supportedExts == null) {
-            supportedExts = new HashSet<String>(4);
+            supportedExts = HashSet.newHashSet(4);
             supportedExts.add(CertificatePolicies_Id.toString());
             supportedExts.add(PolicyMappings_Id.toString());
             supportedExts.add(PolicyConstraints_Id.toString());