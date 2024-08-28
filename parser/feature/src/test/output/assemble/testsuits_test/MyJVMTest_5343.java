import java.io.*;
import java.util.*;
import java.security.cert.*;
import javax.security.cert.Certificate;
import javax.security.cert.X509Certificate;

public class MyJVMTest_5343 {

    static String name = "36_&{NxC(y";

    static Certificate cert = new X509Certificate();

    static String subCaCertStr = "-----BEGIN CERTIFICATE-----\n" + "MIICUDCCAbmgAwIBAgIBAzANBgkqhkiG9w0BAQQFADAfMQswCQYDVQQGEwJVUzEQ\n" + "MA4GA1UEChMHRXhhbXBsZTAeFw0wOTA0MjcwMjI0MzRaFw0yOTAxMTIwMjI0MzRa\n" + "MDExCzAJBgNVBAYTAlVTMRAwDgYDVQQKEwdFeGFtcGxlMRAwDgYDVQQLEwdDbGFz\n" + "cy0xMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiAJnAQW2ad3ZMKUhSJVZj\n" + "8pBqxTcHSTwAVguQkDglsN/OIwUpvR5Jgp3lpRWUEt6idEp0FZzORpvtjt3pr5MG\n" + "Eg2CDptekC5BSPS+fIAIKlncB3HwOiFFhH6b3wTydDCdEd2fvsi4QMOSVrIYMeA8\n" + "P/mCz6kRhfUQPE0CMmOUewIDAQABo4GJMIGGMB0GA1UdDgQWBBT0/nNP8WpyxmYr\n" + "IBp4tN8y08jw2jBHBgNVHSMEQDA+gBSCJd0hpl5PdAD9IZS+Hzng4lXLG6EjpCEw\n" + "HzELMAkGA1UEBhMCVVMxEDAOBgNVBAoTB0V4YW1wbGWCAQAwDwYDVR0TAQH/BAUw\n" + "AwEB/zALBgNVHQ8EBAMCAgQwDQYJKoZIhvcNAQEEBQADgYEAS9PzI6B39R/U9fRj\n" + "UExzN1FXNP5awnAPtiv34kSCL6n6MryqkfG+8aaAOdZsSjmTylNFaF7cW/Xp1VBF\n" + "hq0bg/SbEAbK7+UwL8GSC3crhULHLbh+1iFdVTEwxCw5YmB8ji3BaZ/WKW/PkjCZ\n" + "7cXP6VDeZMG6oRQ4hbOcixoFPXo=\n" + "-----END CERTIFICATE-----";

    static String subCrlIssuerCertStr = "-----BEGIN CERTIFICATE-----\n" + "MIICPTCCAaagAwIBAgIBBDANBgkqhkiG9w0BAQQFADAfMQswCQYDVQQGEwJVUzEQ\n" + "MA4GA1UEChMHRXhhbXBsZTAeFw0wOTA0MjcwMjI0MzRaFw0yOTAxMTIwMjI0MzRa\n" + "MDExCzAJBgNVBAYTAlVTMRAwDgYDVQQKEwdFeGFtcGxlMRAwDgYDVQQLEwdDbGFz\n" + "cy0xMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDWUtDQx2MB/7arDiquMJyd\n" + "LWwSg6p8sg5z6wKrC1v47MT4DBhFX+0RUgTMUdQgYpgxGpczn+6y4zfV76064S0N\n" + "4L/IQ+SunTW1w4yRGjB+xkyyJmWAqijG1nr+Dgkv5nxPI+9Er5lHcoVWVMEcvvRm\n" + "6jIBQdldVlSgv+VgUnFm5wIDAQABo3cwdTAdBgNVHQ4EFgQUkV3Qqtk7gIot9n60\n" + "jX6dloxrfMEwRwYDVR0jBEAwPoAUgiXdIaZeT3QA/SGUvh854OJVyxuhI6QhMB8x\n" + "CzAJBgNVBAYTAlVTMRAwDgYDVQQKEwdFeGFtcGxlggEAMAsGA1UdDwQEAwIBAjAN\n" + "BgkqhkiG9w0BAQQFAAOBgQADu4GM8EdmIKhC7FRvk5jF90zfvZ38wbXBzCjKI4jX\n" + "QJrhne1bfyeNNm5c1w+VKidT+XzBzBGH7ZqYzoZmzRIfcbLKX2brEBKiukeeAyL3\n" + "bctQtbp19tX+uu2dQberD188AAysKTkHcJUV+rRsTwVJ9vcYKxoRxKk8DhH7ZS3M\n" + "rg==\n" + "-----END CERTIFICATE-----";

    static String targetCertStr = "-----BEGIN CERTIFICATE-----\n" + "MIICNzCCAaCgAwIBAgIBAjANBgkqhkiG9w0BAQQFADAxMQswCQYDVQQGEwJVUzEQ\n" + "MA4GA1UEChMHRXhhbXBsZTEQMA4GA1UECxMHQ2xhc3MtMTAeFw0wOTA0MjcwMjI0\n" + "MzZaFw0yOTAxMTIwMjI0MzZaMEExCzAJBgNVBAYTAlVTMRAwDgYDVQQKEwdFeGFt\n" + "cGxlMRAwDgYDVQQLEwdDbGFzcy0xMQ4wDAYDVQQDEwVBbGljZTCBnzANBgkqhkiG\n" + "9w0BAQEFAAOBjQAwgYkCgYEAvYSaU3oiE4Pxp/aUIXwMqOwSiWkZ+O3aTu13hRtK\n" + "ZyR+Wtj63IuvaigAC4uC+zBypF93ThjwCzVR2qKDQaQzV8CLleO96gStt7Y+i3G2\n" + "V3IUGgrVCqeK7N6nNYu0wW84sibcPqG/TIy0UoaQMqgB21xtRF+1DUVlFh4Z89X/\n" + "pskCAwEAAaNPME0wCwYDVR0PBAQDAgPoMB0GA1UdDgQWBBSynMEdcal/e9TmvlNE\n" + "4suXGA4+hjAfBgNVHSMEGDAWgBT0/nNP8WpyxmYrIBp4tN8y08jw2jANBgkqhkiG\n" + "9w0BAQQFAAOBgQB/jru7E/+piSmUwByw5qbZsoQZVcgR97pd2TErNJpJMAX2oIHR\n" + "wJH6w4NuYs27+fEAX7wK4whc6EUH/w1SI6o28F2rG6HqYQPPZ2E2WqwbBQL9nYE3\n" + "Vfzu/G9axTUQXFbf90h80UErA+mZVxqc2xtymLuH0YEaMZImtRZ2MXHfXg==\n" + "-----END CERTIFICATE-----";

    boolean match(String name, Certificate cert) throws Exception {
        X509CertSelector selector = new X509CertSelector();
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        ByteArrayInputStream is = null;
        if (name.equals("subca")) {
            is = new ByteArrayInputStream(subCaCertStr.getBytes());
        } else if (name.equals("subci")) {
            is = new ByteArrayInputStream(subCrlIssuerCertStr.getBytes());
        } else {
            is = new ByteArrayInputStream(targetCertStr.getBytes());
        }
        X509Certificate target = (X509Certificate) cf.generateCertificate(is);
        return target.equals(cert);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5343().match(name, cert));
    }
}
