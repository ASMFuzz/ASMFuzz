@@ -59,6 +59,9 @@
 #define SIGNATURE_EXCEPTION "java/security/SignatureException"
 #define OUT_OF_MEMORY_ERROR "java/lang/OutOfMemoryError"
 
+#define KEYSTORE_LOCATION_CURRENTUSER  0
+#define KEYSTORE_LOCATION_LOCALMACHINE 1
+
 #define SS_CHECK(Status) \
         if (Status != ERROR_SUCCESS) { \
             ThrowException(env, SIGNATURE_EXCEPTION, Status); \
@@ -386,10 +389,10 @@ JNIEXPORT jbyteArray JNICALL Java_sun_security_mscapi_PRNG_generateSeed
 /*
  * Class:     sun_security_mscapi_CKeyStore
  * Method:    loadKeysOrCertificateChains
- * Signature: (Ljava/lang/String;)V
+ * Signature: (Ljava/lang/String;I)V
  */
 JNIEXPORT void JNICALL Java_sun_security_mscapi_CKeyStore_loadKeysOrCertificateChains
-  (JNIEnv *env, jobject obj, jstring jCertStoreName)
+  (JNIEnv *env, jobject obj, jstring jCertStoreName, jint jCertStoreLocation)
 {
     /**
      * Certificate in cert store has enhanced key usage extension
@@ -407,16 +410,27 @@ JNIEXPORT void JNICALL Java_sun_security_mscapi_CKeyStore_loadKeysOrCertificateC
     char* pszNameString = NULL; // certificate's friendly name
     DWORD cchNameString = 0;
 
-
     __try
     {
         // Open a system certificate store.
         if ((pszCertStoreName = env->GetStringUTFChars(jCertStoreName, NULL))
             == NULL) {
             __leave;
         }
-        if ((hCertStore = ::CertOpenSystemStore(NULL, pszCertStoreName))
-            == NULL) {
+
+        if (jCertStoreLocation == KEYSTORE_LOCATION_CURRENTUSER) {
+            hCertStore = ::CertOpenSystemStore(NULL, pszCertStoreName);
+        }
+        else if (jCertStoreLocation == KEYSTORE_LOCATION_LOCALMACHINE) {
+            hCertStore = ::CertOpenStore(CERT_STORE_PROV_SYSTEM_A, 0, NULL,
+                CERT_SYSTEM_STORE_LOCAL_MACHINE, pszCertStoreName);
+        }
+        else {
+            PP("jCertStoreLocation is not a valid value");
+            __leave;
+        }
+
+        if (hCertStore == NULL) {
 
             ThrowException(env, KEYSTORE_EXCEPTION, GetLastError());
             __leave;
@@ -469,7 +483,7 @@ JNIEXPORT void JNICALL Java_sun_security_mscapi_CKeyStore_loadKeysOrCertificateC
             PP("--------------------------");
             // Check if private key available - client authentication certificate
             // must have private key available.
-            HCRYPTPROV hCryptProv = NULL;
+            HCRYPTPROV_OR_NCRYPT_KEY_HANDLE hCryptProv = NULL;
             DWORD dwKeySpec = 0;
             HCRYPTKEY hUserKey = NULL;
             BOOL bCallerFreeProv = FALSE;