import java.net.*;
import java.util.*;
import javax.net.ssl.*;

public class MyJVMTest_13311 {

    static String[] supportedSuites = { "||yj$ =pD#", "}pg~A8G.)<", "ozY\\_O2a5G", "txFT4Bl,S}", "k'4`H\"zMX7", "\\>uhF:w?^;", "6P&,DBTa{T", "GOES:<`Shq", "vQ8Uytas\\:", "'E\\Imtz0Q^" };

    static List<String> KERBEROS_CIPHER_SUITES = Arrays.asList("TLS_KRB5_WITH_RC4_128_SHA", "TLS_KRB5_WITH_RC4_128_MD5", "TLS_KRB5_WITH_3DES_EDE_CBC_SHA", "TLS_KRB5_WITH_3DES_EDE_CBC_MD5", "TLS_KRB5_WITH_DES_CBC_SHA", "TLS_KRB5_WITH_DES_CBC_MD5", "TLS_KRB5_EXPORT_WITH_RC4_40_SHA", "TLS_KRB5_EXPORT_WITH_RC4_40_MD5", "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5");

    String[] checkNotSupported(String[] supportedSuites) {
        for (String suites : supportedSuites) {
            if (KERBEROS_CIPHER_SUITES.contains(suites)) {
                throw new RuntimeException("Supported list of cipher suites " + " should not include Kerberos cipher suites");
            }
        }
        return supportedSuites;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13311().checkNotSupported(supportedSuites);
    }
}
