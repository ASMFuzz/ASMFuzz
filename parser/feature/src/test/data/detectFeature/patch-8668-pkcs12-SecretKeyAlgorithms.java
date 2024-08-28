@@ -23,27 +23,40 @@
 
 /*
  * @test
- * @bug 8286024
+ * @bug 8286024 8286422
  * @library /test/lib
- * @summary PKCS12 keystore shows "DES/CBC" as the algorithm of a DES SecretKeyEntry
+ * @summary PKCS12 keystore should show correct SecretKey algorithm names
  */
 
 import jdk.test.lib.Asserts;
 
 import javax.crypto.KeyGenerator;
 import java.security.Key;
 import java.security.KeyStore;
+import java.util.Collections;
+import java.util.Map;
 
-public class DESName {
+public class SecretKeyAlgorithms {
     public static void main(String[] args) throws Exception {
         char[] pass = "changeit".toCharArray();
         KeyStore ks = KeyStore.getInstance("PKCS12");
         ks.load(null, null);
-        KeyGenerator g = KeyGenerator.getInstance("DES");
-        Key k = g.generateKey();
-        Asserts.assertEQ(k.getAlgorithm(), "DES");
-        ks.setKeyEntry("d", k, pass, null);
-        k = ks.getKey("d", pass);
-        Asserts.assertEQ(k.getAlgorithm(), "DES");
+        var names = Map.of(
+                "des", "DES",
+                "desede", "DESede",
+                "aes", "AES",
+                "blowfish", "Blowfish",
+                "rc2", "RC2",
+                "arcfour", "ARCFOUR");
+        for (var alg : names.entrySet()) {
+            KeyGenerator g = KeyGenerator.getInstance(alg.getKey());
+            Key k = g.generateKey();
+            Asserts.assertEQ(k.getAlgorithm(), alg.getValue());
+            ks.setKeyEntry(alg.getKey(), k, pass, null);
+        }
+        for (var alias : Collections.list(ks.aliases())) {
+            var k = ks.getKey(alias, pass);
+            Asserts.assertEQ(k.getAlgorithm(), names.get(alias));
+        }
     }
 }