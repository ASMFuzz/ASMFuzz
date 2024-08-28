@@ -91,10 +91,14 @@ public Object newInstance(Object ctrParamObj)
                         return new PRNG();
                     }
                 } else if (type.equals("KeyStore")) {
-                    if (algo.equals("Windows-MY")) {
+                    if (algo.equals("Windows-MY") || algo.equals("Windows-MY-CURRENTUSER")) {
                         return new CKeyStore.MY();
-                    } else if (algo.equals("Windows-ROOT")) {
+                    } else if (algo.equals("Windows-ROOT") || algo.equals("Windows-ROOT-CURRENTUSER")) {
                         return new CKeyStore.ROOT();
+                    } else if (algo.equals("Windows-MY-LOCALMACHINE")) {
+                        return new CKeyStore.MYLocalMachine();
+                    } else if (algo.equals("Windows-ROOT-LOCALMACHINE")) {
+                        return new CKeyStore.ROOTLocalMachine();
                     }
                 } else if (type.equals("Signature")) {
                     if (algo.equals("NONEwithRSA")) {
@@ -165,8 +169,16 @@ public Void run() {
                  */
                 putService(new ProviderService(p, "KeyStore",
                            "Windows-MY", "sun.security.mscapi.CKeyStore$MY"));
+                putService(new ProviderService(p, "KeyStore",
+                            "Windows-MY-CURRENTUSER", "sun.security.mscapi.CKeyStore$MY"));
                 putService(new ProviderService(p, "KeyStore",
                            "Windows-ROOT", "sun.security.mscapi.CKeyStore$ROOT"));
+                putService(new ProviderService(p, "KeyStore",
+                            "Windows-ROOT-CURRENTUSER", "sun.security.mscapi.CKeyStore$ROOT"));
+                putService(new ProviderService(p, "KeyStore",
+                            "Windows-MY-LOCALMACHINE", "sun.security.mscapi.CKeyStore$MYLocalMachine"));
+                putService(new ProviderService(p, "KeyStore",
+                            "Windows-ROOT-LOCALMACHINE", "sun.security.mscapi.CKeyStore$ROOTLocalMachine"));
 
                 /*
                  * Signature engines