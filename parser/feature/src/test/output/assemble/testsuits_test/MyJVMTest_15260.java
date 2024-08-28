import java.io.*;
import java.util.*;
import java.security.cert.*;

public class MyJVMTest_15260 {

    static String selfSignedCertStr = "-----BEGIN CERTIFICATE-----\n" + "MIICTjCCAbegAwIBAgIJAIoSzC1A/k4vMA0GCSqGSIb3DQEBBQUAMB8xCzAJBgNV\n" + "BAYTAlVTMRAwDgYDVQQKEwdFeGFtcGxlMB4XDTA5MDUwNzA5MjcxMloXDTMwMDQx\n" + "NzA5MjcxMlowHzELMAkGA1UEBhMCVVMxEDAOBgNVBAoTB0V4YW1wbGUwgZ8wDQYJ\n" + "KoZIhvcNAQEBBQADgY0AMIGJAoGBANXzlv5Fn2cdgBRdEK/37/o8rqQXIRIMZqX6\n" + "BPuo46Cdhctv+n3hu5bj/PwgJVbAJcqcQfDudSSF5gwGlRqDX9vekPSS47XZXjOZ\n" + "qFcnDoWP0gSQXLYVVtjuItkecTrPyUE5v2lRIAh13MGKOSh3ZsrtFvj7Y5d9EqIP\n" + "SLxWWPuHAgMBAAGjgZEwgY4wHQYDVR0OBBYEFFydJvQMB2j4EDHW2bQabNsPUvDt\n" + "ME8GA1UdIwRIMEaAFFydJvQMB2j4EDHW2bQabNsPUvDtoSOkITAfMQswCQYDVQQG\n" + "EwJVUzEQMA4GA1UEChMHRXhhbXBsZYIJAIoSzC1A/k4vMA8GA1UdEwEB/wQFMAMB\n" + "Af8wCwYDVR0PBAQDAgIEMA0GCSqGSIb3DQEBBQUAA4GBAHgoopmZ1Q4qXhMDbbYQ\n" + "YCi4Cg6cXPFblx5gzhWu/6l9SkvZbAZiLszgyMq5dGj9WyTtibNEp232dQsKTFu7\n" + "3ag0DiFqoQ8btgvbwBlzhnRagoeVFjhuBBQutOScw7x8NCSBkZQow+31127mwu3y\n" + "YGYhEmI2dNmgbv1hVYTGmLXW\n" + "-----END CERTIFICATE-----";

    Set<TrustAnchor> generateTrustAnchors() throws CertificateException {
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        ByteArrayInputStream is = new ByteArrayInputStream(selfSignedCertStr.getBytes());
        Certificate selfSignedCert = cf.generateCertificate(is);
        TrustAnchor anchor = new TrustAnchor((X509Certificate) selfSignedCert, null);
        return Collections.singleton(anchor);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15260().generateTrustAnchors());
    }
}
