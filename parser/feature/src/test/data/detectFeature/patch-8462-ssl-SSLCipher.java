@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,6 +25,16 @@
 
 package sun.security.ssl;
 
+import sun.security.ssl.Authenticator.MAC;
+
+import javax.crypto.BadPaddingException;
+import javax.crypto.Cipher;
+import javax.crypto.IllegalBlockSizeException;
+import javax.crypto.NoSuchPaddingException;
+import javax.crypto.SecretKey;
+import javax.crypto.ShortBufferException;
+import javax.crypto.spec.GCMParameterSpec;
+import javax.crypto.spec.IvParameterSpec;
 import java.nio.ByteBuffer;
 import java.security.AccessController;
 import java.security.GeneralSecurityException;
@@ -41,17 +51,17 @@
 import java.util.HashMap;
 import java.util.Locale;
 import java.util.Map;
-import javax.crypto.BadPaddingException;
-import javax.crypto.Cipher;
-import javax.crypto.IllegalBlockSizeException;
-import javax.crypto.NoSuchPaddingException;
-import javax.crypto.SecretKey;
-import javax.crypto.ShortBufferException;
-import javax.crypto.spec.GCMParameterSpec;
-import javax.crypto.spec.IvParameterSpec;
-import sun.security.ssl.Authenticator.MAC;
-import static sun.security.ssl.CipherType.*;
-import static sun.security.ssl.JsseJce.*;
+
+import static sun.security.ssl.CipherType.AEAD_CIPHER;
+import static sun.security.ssl.CipherType.BLOCK_CIPHER;
+import static sun.security.ssl.CipherType.NULL_CIPHER;
+import static sun.security.ssl.CipherType.STREAM_CIPHER;
+import static sun.security.ssl.JsseJce.CIPHER_3DES;
+import static sun.security.ssl.JsseJce.CIPHER_AES;
+import static sun.security.ssl.JsseJce.CIPHER_AES_GCM;
+import static sun.security.ssl.JsseJce.CIPHER_CHACHA20_POLY1305;
+import static sun.security.ssl.JsseJce.CIPHER_DES;
+import static sun.security.ssl.JsseJce.CIPHER_RC4;
 
 enum SSLCipher {
     // exportable ciphers
@@ -881,39 +891,45 @@ static final class StreamReadCipher extends SSLReadCipher {
             public Plaintext decrypt(byte contentType, ByteBuffer bb,
                     byte[] sequence) throws GeneralSecurityException {
                 int len = bb.remaining();
-                int pos = bb.position();
-                ByteBuffer dup = bb.duplicate();
+                int pos;
+                ByteBuffer pt;
+
+                // Do in-place with the bb buffer if it's not read-only
+                if (!bb.isReadOnly()) {
+                    pt = bb.duplicate();
+                    pos = bb.position();
+                } else {
+                    pt = ByteBuffer.allocate(bb.remaining());
+                    pos = 0;
+                }
+
                 try {
-                    if (len != cipher.update(dup, bb)) {
+                    if (len != cipher.update(bb, pt)) {
                         // catch BouncyCastle buffering error
                         throw new RuntimeException(
                                 "Unexpected number of plaintext bytes");
                     }
-                    if (bb.position() != dup.position()) {
-                        throw new RuntimeException(
-                                "Unexpected ByteBuffer position");
-                    }
                 } catch (ShortBufferException sbe) {
                     // catch BouncyCastle buffering error
                     throw new RuntimeException("Cipher buffering error in " +
                         "JCE provider " + cipher.getProvider().getName(), sbe);
                 }
-                bb.position(pos);
+                pt.position(pos);
                 if (SSLLogger.isOn && SSLLogger.isOn("plaintext")) {
                     SSLLogger.fine(
-                            "Plaintext after DECRYPTION", bb.duplicate());
+                            "Plaintext after DECRYPTION", pt.duplicate());
                 }
 
                 MAC signer = (MAC)authenticator;
                 if (signer.macAlg().size != 0) {
-                    checkStreamMac(signer, bb, contentType, sequence);
+                    checkStreamMac(signer, pt, contentType, sequence);
                 } else {
                     authenticator.increaseSequenceNumber();
                 }
 
                 return new Plaintext(contentType,
                         ProtocolVersion.NONE.major, ProtocolVersion.NONE.minor,
-                        -1, -1L, bb.slice());
+                        -1, -1L, pt.slice());
             }
 
             @Override
@@ -1059,26 +1075,30 @@ public Plaintext decrypt(byte contentType, ByteBuffer bb,
                 int cipheredLength = bb.remaining();
                 int tagLen = signer.macAlg().size;
                 if (tagLen != 0) {
-                    if (!sanityCheck(tagLen, bb.remaining())) {
+                    if (!sanityCheck(tagLen, cipheredLength)) {
                         reservedBPE = new BadPaddingException(
                                 "ciphertext sanity check failed");
                     }
                 }
                 // decryption
-                int len = bb.remaining();
-                int pos = bb.position();
-                ByteBuffer dup = bb.duplicate();
+                ByteBuffer pt;
+                int pos;
+
+                // Do in-place with the bb buffer if it's not read-only
+                if (!bb.isReadOnly()) {
+                    pt = bb.duplicate();
+                    pos = bb.position();
+                } else {
+                    pt = ByteBuffer.allocate(cipheredLength);
+                    pos = 0;
+                }
+
                 try {
-                    if (len != cipher.update(dup, bb)) {
+                    if (cipheredLength != cipher.update(bb, pt)) {
                         // catch BouncyCastle buffering error
                         throw new RuntimeException(
                                 "Unexpected number of plaintext bytes");
                     }
-
-                    if (bb.position() != dup.position()) {
-                        throw new RuntimeException(
-                                "Unexpected ByteBuffer position");
-                    }
                 } catch (ShortBufferException sbe) {
                     // catch BouncyCastle buffering error
                     throw new RuntimeException("Cipher buffering error in " +
@@ -1088,14 +1108,14 @@ public Plaintext decrypt(byte contentType, ByteBuffer bb,
                 if (SSLLogger.isOn && SSLLogger.isOn("plaintext")) {
                     SSLLogger.fine(
                             "Padded plaintext after DECRYPTION",
-                            bb.duplicate().position(pos));
+                            pt.duplicate().position(pos));
                 }
 
                 // remove the block padding
-                int blockSize = cipher.getBlockSize();
-                bb.position(pos);
+                pt.position(pos);
                 try {
-                    removePadding(bb, tagLen, blockSize, protocolVersion);
+                    removePadding(pt, tagLen, cipher.getBlockSize(),
+                        protocolVersion);
                 } catch (BadPaddingException bpe) {
                     if (reservedBPE == null) {
                         reservedBPE = bpe;
@@ -1106,7 +1126,7 @@ public Plaintext decrypt(byte contentType, ByteBuffer bb,
                 // block cipher suites.
                 try {
                     if (tagLen != 0) {
-                        checkCBCMac(signer, bb,
+                        checkCBCMac(signer, pt,
                                 contentType, cipheredLength, sequence);
                     } else {
                         authenticator.increaseSequenceNumber();
@@ -1124,7 +1144,7 @@ public Plaintext decrypt(byte contentType, ByteBuffer bb,
 
                 return new Plaintext(contentType,
                         ProtocolVersion.NONE.major, ProtocolVersion.NONE.minor,
-                        -1, -1L, bb.slice());
+                        -1, -1L, pt.slice());
             }
 
             @Override
@@ -1330,48 +1350,50 @@ public Plaintext decrypt(byte contentType, ByteBuffer bb,
                 int cipheredLength = bb.remaining();
                 int tagLen = signer.macAlg().size;
                 if (tagLen != 0) {
-                    if (!sanityCheck(tagLen, bb.remaining())) {
+                    if (!sanityCheck(tagLen, cipheredLength)) {
                         reservedBPE = new BadPaddingException(
                                 "ciphertext sanity check failed");
                     }
                 }
 
                 // decryption
-                int len = bb.remaining();
-                int pos = bb.position();
-                ByteBuffer dup = bb.duplicate();
+                ByteBuffer pt;
+                int pos;
+
+                // Do in-place with the bb buffer if it's not read-only
+                if (!bb.isReadOnly()) {
+                    pt = bb.duplicate();
+                    pos = bb.position();
+                } else {
+                    pt = ByteBuffer.allocate(cipheredLength);
+                    pos = 0;
+                }
+
                 try {
-                    if (len != cipher.update(dup, bb)) {
+                    if (cipheredLength != cipher.update(bb, pt)) {
                         // catch BouncyCastle buffering error
                         throw new RuntimeException(
                                 "Unexpected number of plaintext bytes");
                     }
-
-                    if (bb.position() != dup.position()) {
-                        throw new RuntimeException(
-                                "Unexpected ByteBuffer position");
-                    }
                 } catch (ShortBufferException sbe) {
                     // catch BouncyCastle buffering error
                     throw new RuntimeException("Cipher buffering error in " +
                         "JCE provider " + cipher.getProvider().getName(), sbe);
                 }
 
                 if (SSLLogger.isOn && SSLLogger.isOn("plaintext")) {
-                    SSLLogger.fine(
-                            "Padded plaintext after DECRYPTION",
-                            bb.duplicate().position(pos));
+                    SSLLogger.fine("Padded plaintext after DECRYPTION",
+                        pt.duplicate().position(pos));
                 }
 
                 // Ignore the explicit nonce.
-                bb.position(pos + cipher.getBlockSize());
-                pos = bb.position();
+                int blockSize = cipher.getBlockSize();
+                pos += blockSize;
+                pt.position(pos);
 
                 // remove the block padding
-                int blockSize = cipher.getBlockSize();
-                bb.position(pos);
                 try {
-                    removePadding(bb, tagLen, blockSize, protocolVersion);
+                    removePadding(pt, tagLen, blockSize, protocolVersion);
                 } catch (BadPaddingException bpe) {
                     if (reservedBPE == null) {
                         reservedBPE = bpe;
@@ -1382,7 +1404,7 @@ public Plaintext decrypt(byte contentType, ByteBuffer bb,
                 // block cipher suites.
                 try {
                     if (tagLen != 0) {
-                        checkCBCMac(signer, bb,
+                        checkCBCMac(signer, pt,
                                 contentType, cipheredLength, sequence);
                     } else {
                         authenticator.increaseSequenceNumber();
@@ -1400,7 +1422,7 @@ public Plaintext decrypt(byte contentType, ByteBuffer bb,
 
                 return new Plaintext(contentType,
                         ProtocolVersion.NONE.major, ProtocolVersion.NONE.minor,
-                        -1, -1L, bb.slice());
+                        -1, -1L, pt.slice());
             }
 
             @Override
@@ -1655,10 +1677,20 @@ public Plaintext decrypt(byte contentType, ByteBuffer bb,
 
                 // DON'T decrypt the nonce_explicit for AEAD mode. The buffer
                 // position has moved out of the nonce_explicit range.
-                int len, pos = bb.position();
-                ByteBuffer dup = bb.duplicate();
+                ByteBuffer pt;
+                int len, pos;
+
+                // Do in-place with the bb buffer if it's not read-only
+                if (!bb.isReadOnly()) {
+                    pt = bb.duplicate();
+                    pos = bb.position();
+                } else {
+                    pt = ByteBuffer.allocate(bb.remaining());
+                    pos = 0;
+                }
+
                 try {
-                    len = cipher.doFinal(dup, bb);
+                    len = cipher.doFinal(bb, pt);
                 } catch (IllegalBlockSizeException ibse) {
                     // unlikely to happen
                     throw new RuntimeException(
@@ -1670,17 +1702,17 @@ public Plaintext decrypt(byte contentType, ByteBuffer bb,
                         "JCE provider " + cipher.getProvider().getName(), sbe);
                 }
                 // reset the limit to the end of the decrypted data
-                bb.position(pos);
-                bb.limit(pos + len);
+                pt.position(pos);
+                pt.limit(pos + len);
 
                 if (SSLLogger.isOn && SSLLogger.isOn("plaintext")) {
                     SSLLogger.fine(
-                            "Plaintext after DECRYPTION", bb.duplicate());
+                            "Plaintext after DECRYPTION", pt.duplicate());
                 }
 
                 return new Plaintext(contentType,
                         ProtocolVersion.NONE.major, ProtocolVersion.NONE.minor,
-                        -1, -1L, bb.slice());
+                        -1, -1L, pt.slice());
             }
 
             @Override
@@ -1922,17 +1954,26 @@ public Plaintext decrypt(byte contentType, ByteBuffer bb,
                     throw new RuntimeException(
                                 "invalid key or spec in GCM mode", ikae);
                 }
-
                 // Update the additional authentication data, using the
                 // implicit sequence number of the authenticator.
                 byte[] aad = authenticator.acquireAuthenticationBytes(
                                         contentType, bb.remaining(), sn);
                 cipher.updateAAD(aad);
 
-                int len, pos = bb.position();
-                ByteBuffer dup = bb.duplicate();
+                ByteBuffer pt;
+                int len, pos;
+
+                // Do in-place with the bb buffer if it's not read-only
+                if (!bb.isReadOnly()) {
+                    pt = bb.duplicate();
+                    pos = bb.position();
+                } else {
+                    pt = ByteBuffer.allocate(bb.remaining());
+                    pos = 0;
+                }
+
                 try {
-                    len = cipher.doFinal(dup, bb);
+                    len = cipher.doFinal(bb, pt);
                 } catch (IllegalBlockSizeException ibse) {
                     // unlikely to happen
                     throw new RuntimeException(
@@ -1944,32 +1985,31 @@ public Plaintext decrypt(byte contentType, ByteBuffer bb,
                         "JCE provider " + cipher.getProvider().getName(), sbe);
                 }
                 // reset the limit to the end of the decrypted data
-                bb.position(pos);
-                bb.limit(pos + len);
+                pt.position(pos);
+                pt.limit(pos + len);
 
                 // remove inner plaintext padding
-                int i = bb.limit() - 1;
-                for (; i > 0 && bb.get(i) == 0; i--) {
-                    // blank
-                }
+                int i = pt.limit() - 1;
+                for (; i > 0 && pt.get(i) == 0; i--);
+
                 if (i < (pos + 1)) {
                     throw new BadPaddingException(
                             "Incorrect inner plaintext: no content type");
                 }
-                contentType = bb.get(i);
-                bb.limit(i);
+                contentType = pt.get(i);
+                pt.limit(i);
 
                 if (SSLLogger.isOn && SSLLogger.isOn("plaintext")) {
                     SSLLogger.fine(
-                            "Plaintext after DECRYPTION", bb.duplicate());
+                            "Plaintext after DECRYPTION", pt.duplicate());
                 }
                 if (keyLimitEnabled) {
                     keyLimitCountdown -= len;
                 }
 
                 return new Plaintext(contentType,
                         ProtocolVersion.NONE.major, ProtocolVersion.NONE.minor,
-                        -1, -1L, bb.slice());
+                        -1, -1L, pt.slice());
             }
 
             @Override
@@ -2203,11 +2243,20 @@ public Plaintext decrypt(byte contentType, ByteBuffer bb,
 
                 // DON'T decrypt the nonce_explicit for AEAD mode. The buffer
                 // position has moved out of the nonce_explicit range.
-                int len;
-                int pos = bb.position();
-                ByteBuffer dup = bb.duplicate();
+                ByteBuffer pt;
+                int len, pos;
+
+                // Do in-place with the bb buffer if it's not read-only
+                if (!bb.isReadOnly()) {
+                    pt = bb.duplicate();
+                    pos = bb.position();
+                } else {
+                    pt = ByteBuffer.allocate(bb.remaining());
+                    pos = 0;
+                }
+
                 try {
-                    len = cipher.doFinal(dup, bb);
+                    len = cipher.doFinal(bb, pt);
                 } catch (IllegalBlockSizeException ibse) {
                     // unlikely to happen
                     throw new RuntimeException(
@@ -2219,17 +2268,17 @@ public Plaintext decrypt(byte contentType, ByteBuffer bb,
                         "JCE provider " + cipher.getProvider().getName(), sbe);
                 }
                 // reset the limit to the end of the decrypted data
-                bb.position(pos);
-                bb.limit(pos + len);
+                pt.position(pos);
+                pt.limit(pos + len);
 
                 if (SSLLogger.isOn && SSLLogger.isOn("plaintext")) {
                     SSLLogger.fine(
-                            "Plaintext after DECRYPTION", bb.duplicate());
+                            "Plaintext after DECRYPTION", pt.duplicate());
                 }
 
                 return new Plaintext(contentType,
                         ProtocolVersion.NONE.major, ProtocolVersion.NONE.minor,
-                        -1, -1L, bb.slice());
+                        -1, -1L, pt.slice());
             }
 
             @Override
@@ -2473,11 +2522,20 @@ public Plaintext decrypt(byte contentType, ByteBuffer bb,
                                         contentType, bb.remaining(), sn);
                 cipher.updateAAD(aad);
 
-                int len;
-                int pos = bb.position();
-                ByteBuffer dup = bb.duplicate();
+                ByteBuffer pt;
+                int len, pos;
+
+                // Do in-place with the bb buffer if it's not read-only
+                if (!bb.isReadOnly()) {
+                    pt = bb.duplicate();
+                    pos = bb.position();
+                } else {
+                    pt = ByteBuffer.allocate(bb.remaining());
+                    pos = 0;
+                }
+
                 try {
-                    len = cipher.doFinal(dup, bb);
+                    len = cipher.doFinal(bb, pt);
                 } catch (IllegalBlockSizeException ibse) {
                     // unlikely to happen
                     throw new RuntimeException(
@@ -2489,29 +2547,29 @@ public Plaintext decrypt(byte contentType, ByteBuffer bb,
                         "JCE provider " + cipher.getProvider().getName(), sbe);
                 }
                 // reset the limit to the end of the decrypted data
-                bb.position(pos);
-                bb.limit(pos + len);
+                pt.position(pos);
+                pt.limit(pos + len);
 
                 // remove inner plaintext padding
-                int i = bb.limit() - 1;
-                for (; i > 0 && bb.get(i) == 0; i--) {
+                int i = pt.limit() - 1;
+                for (; i > 0 && pt.get(i) == 0; i--) {
                     // blank
                 }
                 if (i < (pos + 1)) {
                     throw new BadPaddingException(
                             "Incorrect inner plaintext: no content type");
                 }
-                contentType = bb.get(i);
-                bb.limit(i);
+                contentType = pt.get(i);
+                pt.limit(i);
 
                 if (SSLLogger.isOn && SSLLogger.isOn("plaintext")) {
                     SSLLogger.fine(
-                            "Plaintext after DECRYPTION", bb.duplicate());
+                            "Plaintext after DECRYPTION", pt.duplicate());
                 }
 
                 return new Plaintext(contentType,
                         ProtocolVersion.NONE.major, ProtocolVersion.NONE.minor,
-                        -1, -1L, bb.slice());
+                        -1, -1L, pt.slice());
             }
 
             @Override