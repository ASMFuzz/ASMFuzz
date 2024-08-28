import java.security.*;
import java.security.cert.*;

public class MyJVMTest_1326 {

    static PublicKey key = null;

    static String providerName = "#yvrPG5N5%";

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
        new MyJVMTest_1326().verifyCert(key, providerName);
    }
}
