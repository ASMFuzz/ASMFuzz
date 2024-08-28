import java.io.*;
import java.util.*;
import java.security.cert.*;

public class MyJVMTest_18020 {

    static String selfSignedCertStr = "-----BEGIN CERTIFICATE-----\n" + "MIICPjCCAaegAwIBAgIBADANBgkqhkiG9w0BAQQFADAfMQswCQYDVQQGEwJVUzEQ\n" + "MA4GA1UEChMHRXhhbXBsZTAeFw0wOTA0MjcwMjI0MzJaFw0zMDA0MDcwMjI0MzJa\n" + "MB8xCzAJBgNVBAYTAlVTMRAwDgYDVQQKEwdFeGFtcGxlMIGfMA0GCSqGSIb3DQEB\n" + "AQUAA4GNADCBiQKBgQC4OTag24sTxL2tXTNuvpmUEtdxrYAZoFsslFQ60T+WD9wQ\n" + "Jeiw87FSPsR2vxRuv0j8DNm2a4h7LNNIFcLurfNldbz5pvgZ7VqdbbUMPE9qP85n\n" + "jgDl4woyRTSUeRI4A7O0CO6NpES21dtbdhroWQrEkHxpnrDPxsxrz5gf2m3gqwID\n" + "AQABo4GJMIGGMB0GA1UdDgQWBBSCJd0hpl5PdAD9IZS+Hzng4lXLGzBHBgNVHSME\n" + "QDA+gBSCJd0hpl5PdAD9IZS+Hzng4lXLG6EjpCEwHzELMAkGA1UEBhMCVVMxEDAO\n" + "BgNVBAoTB0V4YW1wbGWCAQAwDwYDVR0TAQH/BAUwAwEB/zALBgNVHQ8EBAMCAgQw\n" + "DQYJKoZIhvcNAQEEBQADgYEAluy6HIjWcq009lTLmhp+Np6dxU78pInBK8RZkza0\n" + "484qGaxFGD3UGyZkI5uWmsH2XuMbuox5khfIq6781gmkPBHXBIEtJN8eLusOHEye\n" + "iE8h7WI+N3qa6Pj56WionMrioqC/3X+b06o147bbhx8U0vkYv/HyPaITOFfMXTdz\n" + "Vjw=\n" + "-----END CERTIFICATE-----";

    Set<TrustAnchor> generateTrustAnchors() throws CertificateException {
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        ByteArrayInputStream is = new ByteArrayInputStream(selfSignedCertStr.getBytes());
        Certificate selfSignedCert = cf.generateCertificate(is);
        TrustAnchor anchor = new TrustAnchor((X509Certificate) selfSignedCert, null);
        return Collections.singleton(anchor);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18020().generateTrustAnchors());
    }
}
