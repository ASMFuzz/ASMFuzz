import java.io.*;
import java.util.*;
import java.security.cert.*;

public class MyJVMTest_11374 {

    static String selfSignedCertStr = "-----BEGIN CERTIFICATE-----\n" + "MIICPjCCAaegAwIBAgIBADANBgkqhkiG9w0BAQQFADAfMQswCQYDVQQGEwJVUzEQ\n" + "MA4GA1UEChMHRXhhbXBsZTAeFw0wOTA2MjgxMzMyMThaFw0zMDA2MDgxMzMyMTha\n" + "MB8xCzAJBgNVBAYTAlVTMRAwDgYDVQQKEwdFeGFtcGxlMIGfMA0GCSqGSIb3DQEB\n" + "AQUAA4GNADCBiQKBgQDInJhXi0655bPXAVkz1n5I6fAcZejzPnOPuwq3hU3OxFw8\n" + "81Uf6o9oKI1h4w4XAD8u1cUNOgiX+wPwojronlp68bIfO6FVhNf287pLtLhNJo+7\n" + "m6Qxw3ymFvEKy+PVj20CHSggdKHxUa4MBZBmHMFNBuxfYmjwzn+yTMmCCXOvSwID\n" + "AQABo4GJMIGGMB0GA1UdDgQWBBSQ52Dpau+gtL+Kc31dusYnKj16ZTBHBgNVHSME\n" + "QDA+gBSQ52Dpau+gtL+Kc31dusYnKj16ZaEjpCEwHzELMAkGA1UEBhMCVVMxEDAO\n" + "BgNVBAoTB0V4YW1wbGWCAQAwDwYDVR0TAQH/BAUwAwEB/zALBgNVHQ8EBAMCAQYw\n" + "DQYJKoZIhvcNAQEEBQADgYEAjBt6ea65HCqbGsS2rs/HhlGusYXtThRVC5vwXSey\n" + "ZFYwSgukuq1KDzckqZFu1meNImEwdZjwxdN0e2p/nVREPC42rZliSj6V1ThayKXj\n" + "DWEZW1U5aR8T+3NYfDrdKcJGx4Hzfz0qKz1j4ssV1M9ptJxYYv4y2Da+592IN1S9\n" + "v/E=\n" + "-----END CERTIFICATE-----";

    Set<TrustAnchor> generateTrustAnchors() throws CertificateException {
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        ByteArrayInputStream is = new ByteArrayInputStream(selfSignedCertStr.getBytes());
        Certificate selfSignedCert = cf.generateCertificate(is);
        TrustAnchor anchor = new TrustAnchor((X509Certificate) selfSignedCert, null);
        return Collections.singleton(anchor);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11374().generateTrustAnchors());
    }
}
