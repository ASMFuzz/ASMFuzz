@@ -154,7 +154,7 @@ public Void run() {
                 /*
                  * Secure random
                  */
-                HashMap<String, String> srattrs = new HashMap<>(1);
+                HashMap<String, String> srattrs = HashMap.newHashMap(1);
                 srattrs.put("ThreadSafe", "true");
                 putService(new ProviderService(p, "SecureRandom",
                            "Windows-PRNG", "sun.security.mscapi.PRNG",
@@ -171,7 +171,7 @@ public Void run() {
                 /*
                  * Signature engines
                  */
-                HashMap<String, String> attrs = new HashMap<>(1);
+                HashMap<String, String> attrs = HashMap.newHashMap(1);
                 attrs.put("SupportedKeyClasses", "sun.security.mscapi.CKey");
 
                 // NONEwithRSA must be supplied with a pre-computed message digest.