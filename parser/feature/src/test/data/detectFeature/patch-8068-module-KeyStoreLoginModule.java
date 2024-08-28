@@ -607,12 +607,7 @@ private void getKeyStoreInfo() throws LoginException {
                                 ("Incorrect keyStoreURL option");
             le.initCause(e);
             throw le;
-        } catch (GeneralSecurityException e) {
-            LoginException le = new LoginException
-                                ("Error initializing keystore");
-            le.initCause(e);
-            throw le;
-        } catch (IOException e) {
+        } catch (GeneralSecurityException | IOException e) {
             LoginException le = new LoginException
                                 ("Error initializing keystore");
             le.initCause(e);
@@ -677,11 +672,7 @@ private void getKeyStoreInfo() throws LoginException {
 
             privateCredential = new X500PrivateCredential(
                 certificate, (PrivateKey) privateKey, keyStoreAlias);
-        } catch (KeyStoreException e) {
-            LoginException le = new LoginException("Error using keystore");
-            le.initCause(e);
-            throw le;
-        } catch (NoSuchAlgorithmException e) {
+        } catch (KeyStoreException | NoSuchAlgorithmException e) {
             LoginException le = new LoginException("Error using keystore");
             le.initCause(e);
             throw le;