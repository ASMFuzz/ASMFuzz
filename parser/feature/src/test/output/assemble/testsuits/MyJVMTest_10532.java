import java.security.*;
import java.security.cert.*;

public class MyJVMTest_10532 {

    static PublicKey key = null;

    static String providerName = "Tfrri<\"KM/";

    static X509Certificate cert = null;

    String verifyCert(PublicKey key, String providerName) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Provider provider = Security.getProvider(providerName);
        if (provider == null) {
            throw new RuntimeException("Provider " + providerName + " not found.");
        }
        cert.verify(key, provider);
        return providerName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10532().verifyCert(key, providerName);
    }
}
