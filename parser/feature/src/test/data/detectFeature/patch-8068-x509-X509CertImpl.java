@@ -648,9 +648,7 @@ public Object get(String name)
             if (attr.getSuffix() != null) {
                 try {
                     return info.get(attr.getSuffix());
-                } catch (IOException e) {
-                    throw new CertificateParsingException(e.toString());
-                } catch (CertificateException e) {
+                } catch (IOException | CertificateException e) {
                     throw new CertificateParsingException(e.toString());
                 }
             } else {