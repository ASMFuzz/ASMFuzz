@@ -63,6 +63,7 @@
 
 import sun.security.pkcs12.PKCS12KeyStore;
 import sun.security.provider.certpath.CertPathConstraintsParameters;
+import sun.security.util.ConstraintsParameters;
 import sun.security.util.ECKeySizeParameterSpec;
 import sun.security.util.KeyUtil;
 import sun.security.util.NamedCurve;
@@ -1870,6 +1871,11 @@ private void doGenSecretKey(String alias, String keyAlgName,
             Object[] source = {keysize,
                                 secKey.getAlgorithm()};
             System.err.println(form.format(source));
+
+            SecretKeyConstraintsParameters skcp =
+                    new SecretKeyConstraintsParameters(secKey);
+            checkWeakConstraint(rb.getString("the.generated.secretkey"),
+                    secKey, skcp);
         }
 
         if (keyPass == null) {
@@ -2185,6 +2191,23 @@ private void doPrintEntry(String label, String alias, PrintStream out)
             } else {
                 out.println("SecretKeyEntry, ");
             }
+
+            try {
+                SecretKey secKey = (SecretKey) keyStore.getKey(alias, storePass);
+                SecretKeyConstraintsParameters skcp =
+                        new SecretKeyConstraintsParameters(secKey);
+                checkWeakConstraint(label, secKey, skcp);
+            } catch (UnrecoverableKeyException e) {
+                /*
+                 * UnrecoverableKeyException will be thrown for any secret key
+                 * entries that are protected by a different password than
+                 * storePass, and we will not be able to check the constraints
+                 * because we do not have the keyPass for this operation.
+                 * This may occurs for keystores such as JCEKS. Note that this
+                 * is not really a new issue as details about secret key entries
+                 * other than the fact they exist as entries are not listed.
+                 */
+            }
         } else if (keyStore.entryInstanceOf(alias, KeyStore.PrivateKeyEntry.class)) {
             if (verbose || rfc || debug) {
                 Object[] source = {"PrivateKeyEntry"};
@@ -2487,13 +2510,23 @@ private int doImportKeyStoreSingle(KeyStore srckeystore, String alias)
         }
 
         try {
+            keyStore.setEntry(newAlias, entry, pp);
             Certificate c = srckeystore.getCertificate(alias);
             if (c != null) {
                 CertPathConstraintsParameters cpcp =
                         buildCertPathConstraint((X509Certificate)c, null);
                 checkWeakConstraint("<" + newAlias + ">", c, cpcp);
+            } else {
+                try {
+                    Key key = keyStore.getKey(newAlias, newPass);
+                    SecretKeyConstraintsParameters skcp =
+                            new SecretKeyConstraintsParameters(key);
+                    checkWeakConstraint("<" + newAlias + ">", (SecretKey)key, skcp);
+                } catch (UnrecoverableKeyException e) {
+                    // skip
+                }
             }
-            keyStore.setEntry(newAlias, entry, pp);
+
             // Place the check so that only successful imports are blocked.
             // For example, we don't block a failed SecretEntry import.
             if (P12KEYSTORE.equalsIgnoreCase(storetype) && !isPasswordlessKeyStore) {
@@ -5007,6 +5040,38 @@ private void checkWeakConstraint(String label, Certificate cert,
         }
     }
 
+    private void checkWeakConstraint(String label, SecretKey secKey,
+            SecretKeyConstraintsParameters skcp) {
+        // Do not check disabled algorithms for symmetric key based algorithms for now
+        String secKeyAlg = secKey.getAlgorithm();
+        /*
+         * Skipping a secret key entry if its algorithm starts with "PBE".
+         * This is because keytool can only see it as a PBE key and "PBE" is
+         * an alias of "PBEwithMD5andDES" inside the SunJCE security provider,
+         * and its getAlgorithm() always returns "PBEwithMD5andDES". Thus, keytool
+         * won't be able to determine whether this secret key entry is protected
+         * by a weak algorithm or not.
+         */
+        if (secKeyAlg.startsWith("PBE"))
+            return;
+
+        try {
+            LEGACY_CHECK.permits(secKeyAlg, skcp, true);
+        } catch (CertPathValidatorException e) {
+            String eMessage = e.getMessage();
+            if (eMessage.contains("constraints check failed on keysize limits") &&
+                    e.getReason() == BasicReason.ALGORITHM_CONSTRAINED) {
+                weakWarnings.add(String.format(
+                        rb.getString("key.size.weak"), label,
+                        String.format(rb.getString("key.bit"),
+                        KeyUtil.getKeySize(secKey), secKeyAlg)));
+            } else {
+                weakWarnings.add(String.format(
+                        rb.getString("key.algorithm.weak"), label, secKeyAlg));
+            }
+        }
+    }
+
     private void checkWeakConstraint(String label, PKCS10 p10,
             CertPathConstraintsParameters cpcp) throws Exception {
         checkWeakConstraint(label, p10.getSigAlg(),
@@ -5204,6 +5269,38 @@ private char[] getPass(String modifier, String arg) {
         tinyHelp();
         return null;    // Useless, tinyHelp() already exits.
     }
+
+    private static class SecretKeyConstraintsParameters implements ConstraintsParameters {
+        private final Key key;
+        private SecretKeyConstraintsParameters(Key key) {
+            this.key = key;
+        }
+
+        @Override
+        public boolean anchorIsJdkCA() {
+            return false;
+        }
+
+        @Override
+        public Set<Key> getKeys() {
+            return Set.of(key);
+        }
+
+        @Override
+        public Date getDate() {
+            return null;
+        }
+
+        @Override
+        public String getVariant() {
+            return null;
+        }
+
+        @Override
+        public String extendedExceptionMsg() {
+            return null;
+        }
+    }
 }
 
 // This class is exactly the same as com.sun.tools.javac.util.Pair,