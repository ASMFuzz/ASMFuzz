@@ -72,6 +72,8 @@ public class Resources extends java.util.ListResourceBundle {
                 "Generated {0} secret key"}, //-genseckey
         {"Generated.keysize.bit.keyAlgName.secret.key",
                 "Generated {0}-bit {1} secret key"}, //-genseckey
+        {"key.algorithm.weak", "%1$s uses the %2$s algorithm which is considered a security risk."},
+        {"key.size.weak", "%1$s uses a %2$s which is considered a security risk."},
         {"Imports.entries.from.a.JDK.1.1.x.style.identity.database",
                 "Imports entries from a JDK 1.1.x-style identity database"}, //-identitydb
         {"Imports.a.certificate.or.a.certificate.chain",
@@ -456,6 +458,7 @@ public class Resources extends java.util.ListResourceBundle {
         // generating cert/cert req using weak algorithms
         {"the.certificate.request", "The certificate request"},
         {"the.issuer", "The issuer"},
+        {"the.generated.secretkey", "The generated secret key"},
         {"the.generated.certificate", "The generated certificate"},
         {"the.generated.crl", "The generated CRL"},
         {"the.generated.certificate.request", "The generated certificate request"},
@@ -485,7 +488,7 @@ public class Resources extends java.util.ListResourceBundle {
         {"whose.sigalg.disabled", "%1$s uses the %2$s signature algorithm which is considered a security risk and is disabled."},
         {"whose.sigalg.usagesignedjar", "%1$s uses the %2$s signature algorithm which is considered a security risk and cannot be used to sign JARs after %3$s."},
         {"Unable.to.parse.denyAfter.string.in.exception.message", "Unable to parse denyAfter date string in exception message"},
-        {"whose.sigalg.weak", "%1$s uses the %2$s signature algorithm which is considered a security risk. This algorithm will be disabled in a future update."},
+        {"whose.sigalg.weak", "%1$s uses the %2$s signature algorithm which is considered a security risk."},
         {"whose.key.disabled", "%1$s uses a %2$s which is considered a security risk and is disabled."},
         {"whose.key.weak", "%1$s uses a %2$s which is considered a security risk. This key size will be disabled in a future update."},
         {"jks.storetype.warning", "The %1$s keystore uses a proprietary format. It is recommended to migrate to PKCS12 which is an industry standard format using \"keytool -importkeystore -srckeystore %2$s -destkeystore %2$s -deststoretype pkcs12\"."},