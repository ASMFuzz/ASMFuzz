@@ -316,7 +316,7 @@ public Key engineGetKey(String alias, char[] password)
 
         byte[] encryptedKey;
         AlgorithmParameters algParams;
-        ObjectIdentifier algOid;
+        AlgorithmId aid;
 
         try {
             // get the encrypted private key
@@ -327,8 +327,8 @@ public Key engineGetKey(String alias, char[] password)
             // parse Algorithm parameters
             DerValue val = new DerValue(encrInfo.getAlgorithm().encode());
             DerInputStream in = val.toDerInputStream();
-            algOid = in.getOID();
-            algParams = parseAlgParameters(algOid, in);
+            aid = AlgorithmId.parse(val);
+            algParams = aid.getParameters();
 
         } catch (IOException ioe) {
             UnrecoverableKeyException uke =
@@ -360,8 +360,7 @@ public Key engineGetKey(String alias, char[] password)
 
             key = RetryWithZero.run(pass -> {
                 // Use JCE
-                Cipher cipher = Cipher.getInstance(
-                        mapPBEParamsToAlgorithm(algOid, algParams));
+                Cipher cipher = Cipher.getInstance(aid.getName());
                 SecretKey skey = getPBEKey(pass);
                 try {
                     cipher.init(Cipher.DECRYPT_MODE, skey, algParams);
@@ -394,7 +393,7 @@ public Key engineGetKey(String alias, char[] password)
                             if (debug != null) {
                                 debug.println("Retrieved a protected private key at alias" +
                                         " '" + alias + "' (" +
-                                        mapPBEParamsToAlgorithm(algOid, algParams) +
+                                        aid.getName() +
                                         " iterations: " + ic + ")");
                             }
                             return tmp;
@@ -433,7 +432,7 @@ public Key engineGetKey(String alias, char[] password)
                             if (debug != null) {
                                 debug.println("Retrieved a protected secret key at alias " +
                                         "'" + alias + "' (" +
-                                        mapPBEParamsToAlgorithm(algOid, algParams) +
+                                        aid.getName() +
                                         " iterations: " + ic + ")");
                             }
                             return tmp;
@@ -977,18 +976,6 @@ private static ObjectIdentifier mapPBEAlgorithmToOID(String algorithm)
         return AlgorithmId.get(algorithm).getOID();
     }
 
-    /*
-     * Map a PBE algorithm parameters onto its algorithm name
-     */
-    private static String mapPBEParamsToAlgorithm(ObjectIdentifier algorithm,
-        AlgorithmParameters algParams) throws NoSuchAlgorithmException {
-        // Check for PBES2 algorithms
-        if (algorithm.equals(pbes2_OID) && algParams != null) {
-            return algParams.toString();
-        }
-        return new AlgorithmId(algorithm).getName();
-    }
-
     /**
      * Assigns the given certificate to the given alias.
      *
@@ -2110,9 +2097,8 @@ public synchronized void engineLoad(InputStream stream, char[] password)
                 byte[] rawData = seq[2].getOctetString();
 
                 // parse Algorithm parameters
-                DerInputStream in = seq[1].toDerInputStream();
-                ObjectIdentifier algOid = in.getOID();
-                AlgorithmParameters algParams = parseAlgParameters(algOid, in);
+                AlgorithmId aid = AlgorithmId.parse(seq[1]);
+                AlgorithmParameters algParams = aid.getParameters();
 
                 PBEParameterSpec pbeSpec;
                 int ic = 0;
@@ -2131,23 +2117,21 @@ public synchronized void engineLoad(InputStream stream, char[] password)
                         throw new IOException("cert PBE iteration count too large");
                     }
 
-                    certProtectionAlgorithm
-                            = mapPBEParamsToAlgorithm(algOid, algParams);
+                    certProtectionAlgorithm = aid.getName();
                     certPbeIterationCount = ic;
                     seeEncBag = true;
                 }
 
                 if (debug != null) {
                     debug.println("Loading PKCS#7 encryptedData " +
-                        "(" + mapPBEParamsToAlgorithm(algOid, algParams) +
+                        "(" + certProtectionAlgorithm +
                         " iterations: " + ic + ")");
                 }
 
                 try {
                     RetryWithZero.run(pass -> {
                         // Use JCE
-                        Cipher cipher = Cipher.getInstance(
-                                mapPBEParamsToAlgorithm(algOid, algParams));
+                        Cipher cipher = Cipher.getInstance(certProtectionAlgorithm);
                         SecretKey skey = getPBEKey(pass);
                         try {
                             cipher.init(Cipher.DECRYPT_MODE, skey, algParams);