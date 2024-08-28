@@ -25,15 +25,13 @@
 
 package java.security;
 
-import java.io.*;
-import java.util.Locale;
-
+import javax.crypto.spec.SecretKeySpec;
+import java.io.NotSerializableException;
+import java.io.ObjectStreamException;
+import java.io.Serializable;
 import java.security.spec.PKCS8EncodedKeySpec;
 import java.security.spec.X509EncodedKeySpec;
-import java.security.spec.InvalidKeySpecException;
-
-import javax.crypto.SecretKeyFactory;
-import javax.crypto.spec.SecretKeySpec;
+import java.util.Locale;
 
 /**
  * Standardized representation for serialized Key objects.
@@ -65,7 +63,7 @@ public class KeyRep implements Serializable {
      *
      * @since 1.5
      */
-    public static enum Type {
+    public enum Type {
 
         /** Type for secret keys. */
         SECRET,
@@ -87,28 +85,28 @@ public static enum Type {
      *
      * @serial
      */
-    private Type type;
+    private final Type type;
 
     /**
      * The Key algorithm
      *
      * @serial
      */
-    private String algorithm;
+    private final String algorithm;
 
     /**
      * The Key encoding format
      *
      * @serial
      */
-    private String format;
+    private final String format;
 
     /**
      * The encoded Key bytes
      *
      * @serial
      */
-    private byte[] encoded;
+    private final byte[] encoded;
 
     /**
      * Construct the alternate Key class.