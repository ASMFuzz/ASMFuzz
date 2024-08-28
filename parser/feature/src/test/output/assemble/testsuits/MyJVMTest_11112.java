import java.io.*;
import java.util.*;
import java.security.cert.*;

public class MyJVMTest_11112 {

    static String selfSignedCertStr = "-----BEGIN CERTIFICATE-----\n" + "MIICPjCCAaegAwIBAgIBADANBgkqhkiG9w0BAQQFADAfMQswCQYDVQQGEwJVUzEQ\n" + "MA4GA1UEChMHRXhhbXBsZTAeFw0wOTA0MjcwMjI0MzJaFw0zMDA0MDcwMjI0MzJa\n" + "MB8xCzAJBgNVBAYTAlVTMRAwDgYDVQQKEwdFeGFtcGxlMIGfMA0GCSqGSIb3DQEB\n" + "AQUAA4GNADCBiQKBgQC4OTag24sTxL2tXTNuvpmUEtdxrYAZoFsslFQ60T+WD9wQ\n" + "Jeiw87FSPsR2vxRuv0j8DNm2a4h7LNNIFcLurfNldbz5pvgZ7VqdbbUMPE9qP85n\n" + "jgDl4woyRTSUeRI4A7O0CO6NpES21dtbdhroWQrEkHxpnrDPxsxrz5gf2m3gqwID\n" + "AQABo4GJMIGGMB0GA1UdDgQWBBSCJd0hpl5PdAD9IZS+Hzng4lXLGzBHBgNVHSME\n" + "QDA+gBSCJd0hpl5PdAD9IZS+Hzng4lXLG6EjpCEwHzELMAkGA1UEBhMCVVMxEDAO\n" + "BgNVBAoTB0V4YW1wbGWCAQAwDwYDVR0TAQH/BAUwAwEB/zALBgNVHQ8EBAMCAgQw\n" + "DQYJKoZIhvcNAQEEBQADgYEAluy6HIjWcq009lTLmhp+Np6dxU78pInBK8RZkza0\n" + "484qGaxFGD3UGyZkI5uWmsH2XuMbuox5khfIq6781gmkPBHXBIEtJN8eLusOHEye\n" + "iE8h7WI+N3qa6Pj56WionMrioqC/3X+b06o147bbhx8U0vkYv/HyPaITOFfMXTdz\n" + "Vjw=\n" + "-----END CERTIFICATE-----";

    static String subCaCertStr = "-----BEGIN CERTIFICATE-----\n" + "MIICUDCCAbmgAwIBAgIBAzANBgkqhkiG9w0BAQQFADAfMQswCQYDVQQGEwJVUzEQ\n" + "MA4GA1UEChMHRXhhbXBsZTAeFw0wOTA0MjcwMjI0MzRaFw0yOTAxMTIwMjI0MzRa\n" + "MDExCzAJBgNVBAYTAlVTMRAwDgYDVQQKEwdFeGFtcGxlMRAwDgYDVQQLEwdDbGFz\n" + "cy0xMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiAJnAQW2ad3ZMKUhSJVZj\n" + "8pBqxTcHSTwAVguQkDglsN/OIwUpvR5Jgp3lpRWUEt6idEp0FZzORpvtjt3pr5MG\n" + "Eg2CDptekC5BSPS+fIAIKlncB3HwOiFFhH6b3wTydDCdEd2fvsi4QMOSVrIYMeA8\n" + "P/mCz6kRhfUQPE0CMmOUewIDAQABo4GJMIGGMB0GA1UdDgQWBBT0/nNP8WpyxmYr\n" + "IBp4tN8y08jw2jBHBgNVHSMEQDA+gBSCJd0hpl5PdAD9IZS+Hzng4lXLG6EjpCEw\n" + "HzELMAkGA1UEBhMCVVMxEDAOBgNVBAoTB0V4YW1wbGWCAQAwDwYDVR0TAQH/BAUw\n" + "AwEB/zALBgNVHQ8EBAMCAgQwDQYJKoZIhvcNAQEEBQADgYEAS9PzI6B39R/U9fRj\n" + "UExzN1FXNP5awnAPtiv34kSCL6n6MryqkfG+8aaAOdZsSjmTylNFaF7cW/Xp1VBF\n" + "hq0bg/SbEAbK7+UwL8GSC3crhULHLbh+1iFdVTEwxCw5YmB8ji3BaZ/WKW/PkjCZ\n" + "7cXP6VDeZMG6oRQ4hbOcixoFPXo=\n" + "-----END CERTIFICATE-----";

    static String targetCertStr = "-----BEGIN CERTIFICATE-----\n" + "MIICNzCCAaCgAwIBAgIBBDANBgkqhkiG9w0BAQQFADAxMQswCQYDVQQGEwJVUzEQ\n" + "MA4GA1UEChMHRXhhbXBsZTEQMA4GA1UECxMHQ2xhc3MtMTAeFw0wOTA0MjcwMjI0\n" + "MzhaFw0yOTAxMTIwMjI0MzhaMEExCzAJBgNVBAYTAlVTMRAwDgYDVQQKEwdFeGFt\n" + "cGxlMRAwDgYDVQQLEwdDbGFzcy0xMQ4wDAYDVQQDEwVTdXNhbjCBnzANBgkqhkiG\n" + "9w0BAQEFAAOBjQAwgYkCgYEAyPKlfep+EIIUOpZF3xtYUhAx79qEqe2RPRcH2YeR\n" + "1ogM8+AZMdcXoiuDl4CFLzQwRv1DSKUZAPdPbROLVDsUn+IGvgn2jnE7ZQEUtQQJ\n" + "+rorcasE7bo5MBPuno/0oQRi/4MZn6lX3qB13ZUHAvZH96oCF6C3Ro19LAwav1Lo\n" + "FRcCAwEAAaNPME0wCwYDVR0PBAQDAgPoMB0GA1UdDgQWBBTCUH1tqQk96Pocr8Is\n" + "tDKMoIRQljAfBgNVHSMEGDAWgBT0/nNP8WpyxmYrIBp4tN8y08jw2jANBgkqhkiG\n" + "9w0BAQQFAAOBgQB3YXuTA+QfaImQ2aN/e27Nv5a/FMml6y6t0+pzt5hUYG2W0C2f\n" + "5Hdmf3whNCA7zE5RVDQP0iuGBPgjvrABuN98Vimv2eTV+N5aYTak0Aav/OuR5Lpi\n" + "tYhXMMg5gSmT+JDARba4CX+Ap1oAaNe9Mtv8L6FWdvBqfzzifDHWavdIWA==\n" + "-----END CERTIFICATE-----";

    CertPath generateCertificatePath() throws CertificateException {
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        ByteArrayInputStream is;
        is = new ByteArrayInputStream(targetCertStr.getBytes());
        Certificate targetCert = cf.generateCertificate(is);
        is = new ByteArrayInputStream(subCaCertStr.getBytes());
        Certificate subCaCert = cf.generateCertificate(is);
        is = new ByteArrayInputStream(selfSignedCertStr.getBytes());
        Certificate selfSignedCert = cf.generateCertificate(is);
        List<Certificate> list = Arrays.asList(new Certificate[] { targetCert, subCaCert, selfSignedCert });
        return cf.generateCertPath(list);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11112().generateCertificatePath());
    }
}
