@@ -25,16 +25,9 @@
 
 package javax.crypto;
 
-import java.security.AlgorithmParameters;
-import java.security.Key;
-import java.security.SecureRandom;
-import java.security.NoSuchAlgorithmException;
-import java.security.InvalidKeyException;
-import java.security.InvalidAlgorithmParameterException;
-import java.security.ProviderException;
-import java.security.spec.AlgorithmParameterSpec;
-
 import java.nio.ByteBuffer;
+import java.security.*;
+import java.security.spec.AlgorithmParameterSpec;
 
 /**
  * This class defines the <i>Service Provider Interface</i> (<b>SPI</b>)
@@ -540,7 +533,7 @@ protected abstract int engineUpdate(byte[] input, int inputOffset,
      * process ByteBuffers more efficiently than byte arrays.
      *
      * @param input the input ByteBuffer
-     * @param output the output ByteByffer
+     * @param output the output ByteBuffer
      *
      * @return the number of bytes stored in <code>output</code>
      *
@@ -701,7 +694,7 @@ protected abstract int engineDoFinal(byte[] input, int inputOffset,
      * process ByteBuffers more efficiently than byte arrays.
      *
      * @param input the input ByteBuffer
-     * @param output the output ByteByffer
+     * @param output the output ByteBuffer
      *
      * @return the number of bytes stored in <code>output</code>
      *
@@ -771,8 +764,9 @@ private int bufferCrypt(ByteBuffer input, ByteBuffer output,
             byte[] inArray = input.array();
             int inOfs = input.arrayOffset() + inPos;
 
+            byte[] outArray;
             if (a2) { // output has an accessible byte[]
-                byte[] outArray = output.array();
+                outArray = output.array();
                 int outPos = output.position();
                 int outOfs = output.arrayOffset() + outPos;
 
@@ -797,10 +791,7 @@ private int bufferCrypt(ByteBuffer input, ByteBuffer output,
                     // adjust output position manually
                     output.position(outPos + total);
                 }
-                // adjust input position manually
-                input.position(inLimit);
             } else { // output does not have an accessible byte[]
-                byte[] outArray = null;
                 if (isUpdate) {
                     outArray = engineUpdate(inArray, inOfs, inLen);
                 } else {
@@ -810,9 +801,9 @@ private int bufferCrypt(ByteBuffer input, ByteBuffer output,
                     output.put(outArray);
                     total = outArray.length;
                 }
-                // adjust input position manually
-                input.position(inLimit);
             }
+            // adjust input position manually
+            input.position(inLimit);
         } else { // input does not have an accessible byte[]
             // have to assume the worst, since we have no way of determine
             // if input and output overlaps or not
@@ -934,7 +925,7 @@ protected int engineGetKeySize(Key key)
     }
 
     /**
-     * Continues a multi-part update of the Additional Authentication
+     * Continues a multipart update of the Additional Authentication
      * Data (AAD), using a subset of the provided buffer.
      * <p>
      * Calls to this method provide AAD to the cipher when operating in
@@ -964,7 +955,7 @@ protected void engineUpdateAAD(byte[] src, int offset, int len) {
     }
 
     /**
-     * Continues a multi-part update of the Additional Authentication
+     * Continues a multipart update of the Additional Authentication
      * Data (AAD).
      * <p>
      * Calls to this method provide AAD to the cipher when operating in