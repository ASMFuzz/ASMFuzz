@@ -37,12 +37,10 @@
 import java.security.cert.CRL;
 import java.security.cert.X509Certificate;
 import java.security.cert.CertificateException;
-import java.security.cert.CertificateParsingException;
 import java.security.cert.TrustAnchor;
 import java.security.cert.URICertStoreParameters;
 
 
-import java.security.spec.ECParameterSpec;
 import java.text.Collator;
 import java.text.MessageFormat;
 import java.util.*;
@@ -66,7 +64,6 @@
 import sun.security.util.ConstraintsParameters;
 import sun.security.util.ECKeySizeParameterSpec;
 import sun.security.util.KeyUtil;
-import sun.security.util.NamedCurve;
 import sun.security.util.ObjectIdentifier;
 import sun.security.pkcs10.PKCS10;
 import sun.security.pkcs10.PKCS10Attribute;
@@ -3731,11 +3728,13 @@ private X500Name getX500Name() throws IOException {
         String userInput = null;
 
         int maxRetry = 20;
+        boolean needRepeat;
         do {
             if (maxRetry-- < 0) {
                 throw new RuntimeException(rb.getString(
                         "Too.many.retries.program.terminated"));
             }
+            System.err.println(rb.getString("enter.dname.components"));
             commonName = inputString(in,
                     rb.getString("What.is.your.first.and.last.name."),
                     commonName);
@@ -3756,28 +3755,40 @@ private X500Name getX500Name() throws IOException {
                     rb.getString
                         ("What.is.the.two.letter.country.code.for.this.unit."),
                     country);
-            name = new X500Name(commonName, organizationalUnit, organization,
-                                city, state, country);
-            MessageFormat form = new MessageFormat
-                (rb.getString("Is.name.correct."));
-            Object[] source = {name};
-            userInput = inputString
-                (in, form.format(source), rb.getString("no"));
-        } while (collator.compare(userInput, rb.getString("yes")) != 0 &&
-                 collator.compare(userInput, rb.getString("y")) != 0);
+            name = new X500Name(
+                    dotToNull(commonName), dotToNull(organizationalUnit),
+                    dotToNull(organization), dotToNull(city),
+                    dotToNull(state), dotToNull(country));
+            if (name.isEmpty()) {
+                System.err.println(rb.getString("no.field.in.dname"));
+                needRepeat = true;
+            } else {
+                MessageFormat form = new MessageFormat
+                        (rb.getString("Is.name.correct."));
+                Object[] source = {name};
+                userInput = inputString
+                        (in, form.format(source), rb.getString("no"));
+                needRepeat = collator.compare(userInput, rb.getString("yes")) != 0 &&
+                        collator.compare(userInput, rb.getString("y")) != 0;
+            }
+        } while (needRepeat);
 
         System.err.println();
         return name;
     }
 
+    private static String dotToNull(String input) {
+        return ".".equals(input) ? null : input;
+    }
+
     private String inputString(BufferedReader in, String prompt,
                                String defaultValue)
         throws IOException
     {
         System.err.println(prompt);
         MessageFormat form = new MessageFormat
                 (rb.getString(".defaultValue."));
-        Object[] source = {defaultValue};
+        Object[] source = { ".".equals(defaultValue) ? "" : defaultValue };
         System.err.print(form.format(source));
         System.err.flush();
 