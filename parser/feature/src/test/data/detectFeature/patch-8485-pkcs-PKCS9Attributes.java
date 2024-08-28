@@ -158,13 +158,12 @@ public PKCS9Attributes(PKCS9Attribute[] attribs)
         ObjectIdentifier oid;
         for (int i=0; i < attribs.length; i++) {
             oid = attribs[i].getOID();
-            if (attributes.containsKey(oid))
+            if (attributes.putIfAbsent(oid, attribs[i]) != null)
                 throw new IllegalArgumentException(
                           "PKCSAttribute " + attribs[i].getOID() +
                           " duplicated while constructing " +
                           "PKCS9Attributes.");
 
-            attributes.put(oid, attribs[i]);
         }
         derEncoding = generateDerEncoding();
         permittedAttributes = null;