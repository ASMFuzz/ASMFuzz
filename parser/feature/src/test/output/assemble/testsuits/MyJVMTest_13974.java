import java.security.*;
import java.security.spec.*;

public class MyJVMTest_13974 {

    static byte[] data = { 9, -39, 79, -7, -112, -122, 117, -97, 107, 27 };

    static PublicKey pub = null;

    static PrivateKey priv = null;

    static String digestAlg = "2VjN_C/)K[";

    static int keySize = 1889625514;

    PSSParameterSpec genPSSParameter(String digestAlgo, int digestLen, int keySize) {
        int saltLength = keySize / 8 - digestLen - 2;
        if (saltLength < 0) {
            System.out.println("keysize: " + keySize / 8 + ", digestLen: " + digestLen);
            return null;
        }
        return new PSSParameterSpec(digestAlgo, "MGF1", new MGF1ParameterSpec(digestAlgo), saltLength, 1);
    }

    static String PROVIDER = "SunRsaSign";

    static int UPDATE_TIMES_TWO = 2;

    static int UPDATE_TIMES_TEN = 10;

    static String SIG_ALG = "RSASSA-PSS";

    String checkSignature(byte[] data, PublicKey pub, PrivateKey priv, String digestAlg, int keySize) throws RuntimeException {
        try {
            Signature sig = Signature.getInstance(SIG_ALG, PROVIDER);
            int digestLen = MessageDigest.getInstance(digestAlg).getDigestLength();
            PSSParameterSpec params = genPSSParameter(digestAlg, digestLen, keySize);
            if (params == null) {
                System.out.println("Skip test due to short key size");
                return;
            }
            sig.setParameter(params);
            sig.initSign(priv);
            for (int i = 0; i < UPDATE_TIMES_TEN; i++) {
                sig.update(data);
            }
            byte[] signedDataTen = sig.sign();
            sig.update(data);
            byte[] signedDataOne = sig.sign();
            System.out.println("Verify using params " + sig.getParameters());
            sig.initVerify(pub);
            sig.setParameter(params);
            for (int i = 0; i < UPDATE_TIMES_TEN; i++) {
                sig.update(data);
            }
            if (!sig.verify(signedDataTen)) {
                throw new RuntimeException("Signature verification test#1 failed w/ " + digestAlg);
            }
            sig.update(data);
            if (!sig.verify(signedDataOne)) {
                throw new RuntimeException("Signature verification test#2 failed w/ " + digestAlg);
            }
            for (int i = 0; i < UPDATE_TIMES_TWO; i++) {
                sig.update(data);
            }
            if (sig.verify(signedDataOne)) {
                throw new RuntimeException("Bad signature accepted w/ " + digestAlg);
            }
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException | NoSuchProviderException | InvalidAlgorithmParameterException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return digestAlg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13974().checkSignature(data, pub, priv, digestAlg, keySize);
    }
}
