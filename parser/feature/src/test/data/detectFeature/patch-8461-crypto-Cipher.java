@@ -25,27 +25,47 @@
 
 package javax.crypto;
 
-import java.util.*;
-import java.util.concurrent.ConcurrentHashMap;
-import java.util.concurrent.ConcurrentMap;
-import java.util.regex.*;
-
+import sun.security.jca.GetInstance;
+import sun.security.jca.JCAUtil;
+import sun.security.jca.ServiceId;
+import sun.security.util.Debug;
+import sun.security.util.KnownOIDs;
 
-import java.security.*;
+import javax.crypto.spec.IvParameterSpec;
+import javax.crypto.spec.PBEParameterSpec;
+import javax.crypto.spec.RC2ParameterSpec;
+import javax.crypto.spec.RC5ParameterSpec;
+import java.nio.ByteBuffer;
+import java.nio.ReadOnlyBufferException;
+import java.security.AlgorithmParameters;
+import java.security.GeneralSecurityException;
+import java.security.InvalidAlgorithmParameterException;
+import java.security.InvalidKeyException;
+import java.security.InvalidParameterException;
+import java.security.Key;
+import java.security.NoSuchAlgorithmException;
+import java.security.NoSuchProviderException;
+import java.security.Provider;
 import java.security.Provider.Service;
-import java.security.spec.AlgorithmParameterSpec;
-import java.security.spec.InvalidParameterSpecException;
+import java.security.ProviderException;
+import java.security.PublicKey;
+import java.security.SecureRandom;
+import java.security.Security;
 import java.security.cert.Certificate;
 import java.security.cert.X509Certificate;
-
-import javax.crypto.spec.*;
-
-import java.nio.ByteBuffer;
-import java.nio.ReadOnlyBufferException;
-
-import sun.security.util.Debug;
-import sun.security.jca.*;
-import sun.security.util.KnownOIDs;
+import java.security.spec.AlgorithmParameterSpec;
+import java.security.spec.InvalidParameterSpecException;
+import java.util.ArrayList;
+import java.util.Collections;
+import java.util.Iterator;
+import java.util.List;
+import java.util.Locale;
+import java.util.NoSuchElementException;
+import java.util.Set;
+import java.util.StringTokenizer;
+import java.util.concurrent.ConcurrentHashMap;
+import java.util.concurrent.ConcurrentMap;
+import java.util.regex.Pattern;
 
 /**
  * This class provides the functionality of a cryptographic cipher for
@@ -2838,4 +2858,234 @@ public String toString() {
         sb.append(", algorithm from: ").append(getProviderName());
         return sb.toString();
     }
+
+    /**
+     * fdsafsdafsdafda
+     * @return dsfasfa
+     */
+    public static Builder newBuilder() {
+        return new Builder();
+    }
+
+    /**
+     * fdsafsafsda
+     */
+    public static class Builder {
+        Cipher cyfr;
+        String algorithm;
+        Key key = null;
+        Certificate cert = null;
+        AlgorithmParameters ap = null;
+        AlgorithmParameterSpec aps = null;
+        SecureRandom random = null;
+        int op = Cipher.ENCRYPT_MODE;
+        Provider provider;
+        String provStr;
+        String keygenStr = null;
+
+        /**
+         * fdsafsdafda
+         */
+        public Builder() {
+            super();
+        }
+
+        /**
+         * fsdafd afdfasd
+         * @return fdsafsda
+         * @throws GeneralSecurityException blah
+         */
+        public Cipher build() throws GeneralSecurityException {
+            if (random == null) {
+                JCAUtil.getDefSecureRandom();
+            }
+            try {
+                if (provider == null && provStr == null) {
+                    cyfr = Cipher.getInstance(algorithm);
+                } else if (provider != null) {
+                    cyfr = Cipher.getInstance(algorithm, provider);
+                } else if (provStr != null) {
+                    cyfr = Cipher.getInstance(algorithm, provStr);
+                }
+
+                if (key == null && keygenStr != null) {
+                    KeyGenerator kg;
+                    if (cyfr.provider == null) {
+                         kg = KeyGenerator.getInstance(keygenStr);
+                    } else {
+                        kg = KeyGenerator.getInstance(keygenStr, cyfr.provider);
+                    }
+                    key = kg.generateKey();
+                }
+
+                if (aps != null) {
+                    cyfr.init(op, key, aps, random);
+                } else if (ap != null) {
+                    cyfr.init(op, key, ap, random);
+                } else if (cert != null) {
+                    cyfr.init(op, cert, random);
+                } else {
+                    cyfr.init(op, key, random);
+                }
+
+            } catch (Exception e) {
+                throw new GeneralSecurityException(e);
+            }
+            return cyfr;
+        }
+
+        /**
+         * Build a cipher object with the provided algorithm transformation
+         * @param algorithm - algorithm transformation
+         * @return the builder object
+         */
+        public Builder with(String algorithm) {
+            this.algorithm = algorithm;
+            return this;
+        }
+
+        /**
+         * Build a cipher object with the provided Key object
+         * @param key secret key object
+         * @return the builder object
+         */
+        public Builder with(Key key) {
+            this.key = key;
+            return this;
+        }
+
+        /**
+         * Build a cipher object with the provided Certificate object
+         * @param cert certificate object
+         * @return the builder object
+         * @throws GeneralSecurityException exception thrown if other builder
+         * methods were called that conflict with this method
+         */
+        public Builder with(Certificate cert) throws GeneralSecurityException {
+            if (aps != null) {
+                throw new GeneralSecurityException("AlgorithmParameterSpec " +
+                    "cannot be specified when using a certificate");
+            }
+            if (ap != null) {
+                throw new GeneralSecurityException("AlgorithmParameters " +
+                    "cannot be specified when using a certificate");
+            }
+            this.cert = cert;
+            return this;
+        }
+
+        /**
+         * Build a cipher object with the provided AlgorithmParameterSpec object
+         * @param params AlgorithmParameterSpec
+         * @return the builder object
+         * @throws GeneralSecurityException exception thrown if other builder
+         * methods were called that conflict with this method
+         */
+        Builder with(AlgorithmParameterSpec params) throws GeneralSecurityException {
+            if (cert != null) {
+                throw new GeneralSecurityException("AlgorithmParameterSpec " +
+                    "cannot be specified when using a certificate");
+            }
+            if (ap != null) {
+                throw new GeneralSecurityException("AlgorithmParameterSpec " +
+                    "cannot be specified after using an " +
+                    "AlgorithmParameters");
+            }            aps = params;
+            return this;
+        }
+
+        /**
+         * Build a cipher object with the provided AlgorithmParameters object
+         * @param params AlgorithmParameterSpec
+         * @return the builder object
+         * @throws GeneralSecurityException exception thrown if other builder
+         * methods were called that conflict with this method
+         */
+        public Builder with(AlgorithmParameters params) throws GeneralSecurityException {
+            if (cert != null) {
+                throw new GeneralSecurityException("AlgorithmParameters " +
+                    "cannot be specified when using a certificate");
+            }
+            if (aps != null) {
+                throw new GeneralSecurityException("AlgorithmParameters " +
+                    "cannot be specified after using an " +
+                    "AlgorithmParameterSpec");
+            }
+            ap = params;
+            return this;
+        }
+
+        /**
+         * Build a cipher object for encryption
+         * @return the builder object
+         */
+        public Builder encrypt() {
+            op = Cipher.ENCRYPT_MODE;
+            return this;
+        }
+
+        /**
+         * Build a cipher object for decrypt
+         * @return the builder object
+         */
+        public Builder decrypt() {
+            op = Cipher.DECRYPT_MODE;
+            return this;
+        }
+
+        /**
+         * Build a cipher object that will generate a key, using {@code KeyGenerator} with the given key type.
+         * If the builder has a specified provider, it will use that provider to generate the key.
+         * @param kgStr String of the key type
+         * @return the builder object
+         */
+        public Builder generate(String kgStr) {
+            keygenStr = kgStr;
+            return this;
+        }
+
+        /**
+         * Build a cipher object that will do all it's operations with the given provider
+         * @param prov Provider class
+         * @return the builder object
+         * @throws GeneralSecurityException throws if the provider has already been specified by another method
+         */
+        public Builder provider(Provider prov) throws GeneralSecurityException {
+            if (provStr != null) {
+                throw new GeneralSecurityException(
+                    "Provider already specified");
+            }
+            provider = prov;
+            return this;
+        }
+
+        /**
+         * Build a cipher object that will do all it's operations with the
+         * given provider
+         * @param prov Provider name as a string
+         * @return the builder object
+         * @throws GeneralSecurityException throws if the provider has already
+         * been specified by another method
+         */
+        public Builder provider(String prov) throws GeneralSecurityException {
+            if (provider != null) {
+                throw new GeneralSecurityException(
+                    "Provider already specified");
+            }
+            provStr = prov;
+            return this;
+        }
+
+        /**
+         * Return the key used in the cipher object.
+         * @return This method is for returning the {@code Key} when
+         * {@code generate()} has been used.  This must be used after the
+         * {@code build()} is called. If {@code generate()} was not called
+         * and {@code with(Key)} is called, this will return that key object,
+         * otherwise {@code null} will be returned
+         */
+        public Key getKey() {
+            return key;
+        }
+    }
 }