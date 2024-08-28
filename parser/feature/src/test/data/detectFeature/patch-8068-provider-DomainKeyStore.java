@@ -29,13 +29,11 @@
 import java.net.*;
 import java.security.*;
 import java.security.cert.Certificate;
-import java.security.cert.CertificateFactory;
 import java.security.cert.CertificateException;
 import java.util.*;
 
 import static java.nio.charset.StandardCharsets.UTF_8;
 
-import sun.security.pkcs.EncryptedPrivateKeyInfo;
 import sun.security.util.PolicyUtil;
 
 /**
@@ -798,11 +796,8 @@ private List<KeyStoreBuilderComponents> getBuilders(URI configuration,
             parser.read(configurationReader);
             domains = parser.getDomainEntries();
 
-        } catch (MalformedURLException mue) {
-            throw new IOException(mue);
-
-        } catch (PolicyParser.ParsingException pe) {
-            throw new IOException(pe);
+        } catch (MalformedURLException | PolicyParser.ParsingException e) {
+            throw new IOException(e);
         }
 
         for (PolicyParser.DomainEntry domain : domains) {