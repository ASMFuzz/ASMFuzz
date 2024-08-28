import java.io.*;
import java.util.*;
import java.security.cert.*;
import java.security.cert.CertPathValidatorException.*;

public class MyJVMTest_12352 {

    static String trustAnchor_SHA1withRSA_1024 = "-----BEGIN CERTIFICATE-----\n" + "MIICPjCCAaegAwIBAgIBADANBgkqhkiG9w0BAQUFADAfMQswCQYDVQQGEwJVUzEQ\n" + "MA4GA1UEChMHRXhhbXBsZTAeFw0wOTA4MDYwMTExNDRaFw0zMDA3MTcwMTExNDRa\n" + "MB8xCzAJBgNVBAYTAlVTMRAwDgYDVQQKEwdFeGFtcGxlMIGfMA0GCSqGSIb3DQEB\n" + "AQUAA4GNADCBiQKBgQC8UdC863pFk1Rvd7xUYd60+e9KsLhb6SqOfU42ZA715FcH\n" + "E1TRvQPmYzAnHcO04TrWZQtO6E+E2RCmeBnetBvIMVka688QkO14wnrIrf2tRodd\n" + "rZNZEBzkX+zyXCRo9tKEUDFf9Qze7Ilbb+Zzm9CUfu4M1Oz6iQcXRx7aM0jEAQID\n" + "AQABo4GJMIGGMB0GA1UdDgQWBBTn0C+xmZY/BTab4W9gBp3dGa7WgjBHBgNVHSME\n" + "QDA+gBTn0C+xmZY/BTab4W9gBp3dGa7WgqEjpCEwHzELMAkGA1UEBhMCVVMxEDAO\n" + "BgNVBAoTB0V4YW1wbGWCAQAwDwYDVR0TAQH/BAUwAwEB/zALBgNVHQ8EBAMCAgQw\n" + "DQYJKoZIhvcNAQEFBQADgYEAiCXL2Yp4ruyRXAIJ8zBEaPC9oV2agqgbSbly2z8z\n" + "Ik5SeSRysP+GHBpb8uNyANJnQKv+T0GrJiTLMBjKCOiJl6xzk3EZ2wbQB6G/SQ9+\n" + "UWcsXSC8oGSEPpkj5In/9/UbuUIfT9H8jmdyLNKQvlqgq6kyfnskME7ptGgT95Hc\n" + "tas=\n" + "-----END CERTIFICATE-----";

    static String trustAnchor_SHA1withRSA_512 = "-----BEGIN CERTIFICATE-----\n" + "MIIBuTCCAWOgAwIBAgIBADANBgkqhkiG9w0BAQUFADAfMQswCQYDVQQGEwJVUzEQ\n" + "MA4GA1UEChMHRXhhbXBsZTAeFw0wOTA4MDYwMTExNDRaFw0zMDA3MTcwMTExNDRa\n" + "MB8xCzAJBgNVBAYTAlVTMRAwDgYDVQQKEwdFeGFtcGxlMFwwDQYJKoZIhvcNAQEB\n" + "BQADSwAwSAJBAM0Kn4ieCdCHsrm78ZMMN4jQEEEqACAMKB7O8j9g4gfz2oAfmHwv\n" + "7JH/hZ0Xen1zUmBbwe+e2J5D/4Fisp9Bn98CAwEAAaOBiTCBhjAdBgNVHQ4EFgQU\n" + "g4Kwd47hdNQBp8grZsRJ5XvhvxAwRwYDVR0jBEAwPoAUg4Kwd47hdNQBp8grZsRJ\n" + "5XvhvxChI6QhMB8xCzAJBgNVBAYTAlVTMRAwDgYDVQQKEwdFeGFtcGxlggEAMA8G\n" + "A1UdEwEB/wQFMAMBAf8wCwYDVR0PBAQDAgIEMA0GCSqGSIb3DQEBBQUAA0EAn77b\n" + "FJx+HvyRvjZYCzMjnUct3Ql4iLOkURYDh93J5TXi/l9ajvAMEuwzYj0qZ+Ktm/ia\n" + "U5r+8B9nzx+j2Zh3kw==\n" + "-----END CERTIFICATE-----";

    Set<TrustAnchor> generateTrustAnchors() throws CertificateException {
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        HashSet<TrustAnchor> anchors = new HashSet<TrustAnchor>();
        ByteArrayInputStream is = new ByteArrayInputStream(trustAnchor_SHA1withRSA_1024.getBytes());
        Certificate cert = cf.generateCertificate(is);
        TrustAnchor anchor = new TrustAnchor((X509Certificate) cert, null);
        anchors.add(anchor);
        is = new ByteArrayInputStream(trustAnchor_SHA1withRSA_512.getBytes());
        cert = cf.generateCertificate(is);
        anchor = new TrustAnchor((X509Certificate) cert, null);
        anchors.add(anchor);
        return anchors;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12352().generateTrustAnchors());
    }
}
