import java.io.*;
import java.util.*;
import java.security.cert.*;

public class MyJVMTest_12678 {

    static String selfSignedCertStr = "-----BEGIN CERTIFICATE-----\n" + "MIICTjCCAbegAwIBAgIJAIoSzC1A/k4vMA0GCSqGSIb3DQEBBQUAMB8xCzAJBgNV\n" + "BAYTAlVTMRAwDgYDVQQKEwdFeGFtcGxlMB4XDTA5MDUwNzA5MjcxMloXDTMwMDQx\n" + "NzA5MjcxMlowHzELMAkGA1UEBhMCVVMxEDAOBgNVBAoTB0V4YW1wbGUwgZ8wDQYJ\n" + "KoZIhvcNAQEBBQADgY0AMIGJAoGBANXzlv5Fn2cdgBRdEK/37/o8rqQXIRIMZqX6\n" + "BPuo46Cdhctv+n3hu5bj/PwgJVbAJcqcQfDudSSF5gwGlRqDX9vekPSS47XZXjOZ\n" + "qFcnDoWP0gSQXLYVVtjuItkecTrPyUE5v2lRIAh13MGKOSh3ZsrtFvj7Y5d9EqIP\n" + "SLxWWPuHAgMBAAGjgZEwgY4wHQYDVR0OBBYEFFydJvQMB2j4EDHW2bQabNsPUvDt\n" + "ME8GA1UdIwRIMEaAFFydJvQMB2j4EDHW2bQabNsPUvDtoSOkITAfMQswCQYDVQQG\n" + "EwJVUzEQMA4GA1UEChMHRXhhbXBsZYIJAIoSzC1A/k4vMA8GA1UdEwEB/wQFMAMB\n" + "Af8wCwYDVR0PBAQDAgIEMA0GCSqGSIb3DQEBBQUAA4GBAHgoopmZ1Q4qXhMDbbYQ\n" + "YCi4Cg6cXPFblx5gzhWu/6l9SkvZbAZiLszgyMq5dGj9WyTtibNEp232dQsKTFu7\n" + "3ag0DiFqoQ8btgvbwBlzhnRagoeVFjhuBBQutOScw7x8NCSBkZQow+31127mwu3y\n" + "YGYhEmI2dNmgbv1hVYTGmLXW\n" + "-----END CERTIFICATE-----";

    static String subCaCertStr = "-----BEGIN CERTIFICATE-----\n" + "MIICdTCCAd6gAwIBAgIJAL+MYVyy7k5YMA0GCSqGSIb3DQEBBQUAMB8xCzAJBgNV\n" + "BAYTAlVTMRAwDgYDVQQKEwdFeGFtcGxlMB4XDTA5MDUwNzA5MjcxNFoXDTI5MDEy\n" + "MjA5MjcxNFowMTELMAkGA1UEBhMCVVMxEDAOBgNVBAoTB0V4YW1wbGUxEDAOBgNV\n" + "BAsTB0NsYXNzLTEwgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGBAM2mwX8dhP3M\n" + "i6ATRsd0wco+c7rsyEbP0CRQunVIP8/kOL8+zyQix+QZquY23tvBCbia424GXDkT\n" + "irvK/M4yGzrdS51hA5dlH3SHY3CWOAqEPqKtNLn1My4MWtTiUWbHi0YjFuOv0BXz\n" + "x9lTEfMf+3QcOgO5FitcqHIMP4jIlT+lAgMBAAGjgaYwgaMwHQYDVR0OBBYEFJHg\n" + "eyEWcjxcAwc01BPQrau/4HJaME8GA1UdIwRIMEaAFFydJvQMB2j4EDHW2bQabNsP\n" + "UvDtoSOkITAfMQswCQYDVQQGEwJVUzEQMA4GA1UEChMHRXhhbXBsZYIJAIoSzC1A\n" + "/k4vMA8GA1UdEwEB/wQFMAMBAf8wCwYDVR0PBAQDAgIEMBMGA1UdHgQMMAqhCDAG\n" + "iAQqAwQFMA0GCSqGSIb3DQEBBQUAA4GBAI3CDQWZiTlVVVqfCiZwc/yIL7G5bu2g\n" + "ccgVz9PyKfTpq8vk59S23TvPwdPt4ZVx4RSoar9ONtbrcLxfP3X6WQ7e9popWNZV\n" + "q49YfyU1tD5HFuxj7CAsvfykuRo4ovXaTCVWlTMi7fJJdzU0Eb4xkXXhiWT/RbHG\n" + "R7J+8ROMZ+nR\n" + "-----END CERTIFICATE-----";

    static String targetCertStr = "-----BEGIN CERTIFICATE-----\n" + "MIICUDCCAbmgAwIBAgIJAOA8c10w019XMA0GCSqGSIb3DQEBBQUAMDExCzAJBgNV\n" + "BAYTAlVTMRAwDgYDVQQKEwdFeGFtcGxlMRAwDgYDVQQLEwdDbGFzcy0xMB4XDTA5\n" + "MDUwNzEwMjY0M1oXDTI5MDEyMjEwMjY0M1owQTELMAkGA1UEBhMCVVMxEDAOBgNV\n" + "BAoTB0V4YW1wbGUxEDAOBgNVBAsTB0NsYXNzLTExDjAMBgNVBAMTBVN1c2FuMIGf\n" + "MA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDlmyS8SskMX3mreD95oBaXUGNvPTK0\n" + "39IBdxle2TpJEBL/BcS4QUb2+67WjrXhUZWFtpc4RzywfvSSxZH2wbwDDJPs56OC\n" + "Eczsdnqe7gOroYm2TMfY0/pItgP3mRkhJpxAWFc/y7Qr8jJbPmKfiYbYROp1eR2t\n" + "BrjUiUTrAtM7GwIDAQABo2AwXjALBgNVHQ8EBAMCA+gwDwYDVR0RBAgwBogEKgME\n" + "BTAdBgNVHQ4EFgQUyqtfkWtPah5J658LHN8CEGIgAbgwHwYDVR0jBBgwFoAUkeB7\n" + "IRZyPFwDBzTUE9Ctq7/gclowDQYJKoZIhvcNAQEFBQADgYEAnwaLBteuJhXF56Rg\n" + "l8FIEzgJtT4yu/8WsYjhN6/aLGkgJ37VavWdhjwXIb1RVJE/ab3hTbWF5ht7jMcQ\n" + "/WnD8R8CpwEEX/n2wpb3zMHZ8zT7k0mWYm10mPHw1psjOUvJd/zB4gT4tc2A2soM\n" + "FbcNIaCtg8blO5ImdOz5hAi+NuY=\n" + "-----END CERTIFICATE-----";

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
        System.out.println(new MyJVMTest_12678().generateCertificatePath());
    }
}
