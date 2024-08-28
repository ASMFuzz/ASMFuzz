@@ -23,7 +23,7 @@
 
 /*
  * @test
- * @bug 8255552
+ * @bug 8255552 8286090
  * @summary Test keytool commands associated with secret key entries which use weak algorithms
  * @library /test/lib
  */
@@ -57,12 +57,26 @@ public static void main(String[] args) throws Exception {
                 .shouldNotMatch("The generated secret key uses the AES algorithm.*considered a security risk")
                 .shouldHaveExitValue(0);
 
+        SecurityTools.keytool("-keystore ks.p12 -storepass changeit " +
+                "-genseckey -keyalg RC2 -alias rc2key -keysize 128")
+                .shouldContain("Warning")
+                .shouldMatch("The generated secret key uses the RC2 algorithm.*considered a security risk")
+                .shouldHaveExitValue(0);
+
+        SecurityTools.keytool("-keystore ks.p12 -storepass changeit " +
+                "-genseckey -keyalg RC4 -alias rc4key -keysize 1024")
+                .shouldContain("Warning")
+                .shouldMatch("The generated secret key uses the ARCFOUR algorithm.*considered a security risk")
+                .shouldHaveExitValue(0);
+
         SecurityTools.keytool("-keystore ks.p12 -storepass changeit " +
                 "-list -v")
                 .shouldContain("Warning")
                 .shouldMatch("<des3key> uses the DESede algorithm.*considered a security risk")
                 .shouldMatch("<deskey> uses the DES algorithm.*considered a security risk")
                 .shouldNotMatch("<aeskey> uses the AES algorithm.*considered a security risk")
+                .shouldMatch("<rc2key> uses the RC2 algorithm.*considered a security risk")
+                .shouldMatch("<rc4key> uses the ARCFOUR algorithm.*considered a security risk")
                 .shouldHaveExitValue(0);
 
         SecurityTools.setResponse("changeit", "changeit");
@@ -71,13 +85,17 @@ public static void main(String[] args) throws Exception {
                 .shouldContain("Warning")
                 .shouldMatch("<des3key> uses the DESede algorithm.*considered a security risk")
                 .shouldMatch("<deskey> uses the DES algorithm.*considered a security risk")
+                .shouldMatch("<rc2key> uses the RC2 algorithm.*considered a security risk")
+                .shouldMatch("<rc4key> uses the ARCFOUR algorithm.*considered a security risk")
                 .shouldHaveExitValue(0);
 
         SecurityTools.keytool("-keystore ks.new -storepass changeit " +
                 "-list -v")
                 .shouldContain("Warning")
                 .shouldMatch("<des3key> uses the DESede algorithm.*considered a security risk")
                 .shouldMatch("<deskey> uses the DES algorithm.*considered a security risk")
+                .shouldMatch("<rc2key> uses the RC2 algorithm.*considered a security risk")
+                .shouldMatch("<rc4key> uses the ARCFOUR algorithm.*considered a security risk")
                 .shouldHaveExitValue(0);
 
         Files.writeString(Files.createFile(Paths.get(JAVA_SECURITY_FILE)),