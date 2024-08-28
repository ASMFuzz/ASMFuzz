import java.io.*;
import java.util.*;
import java.security.cert.*;
import javax.security.cert.Certificate;
import javax.security.cert.X509Certificate;

public class MyJVMTest_8939 {

    static String name = "] *0t0FX[J";

    static Certificate cert = new X509Certificate();

    static String subCaCertStr = "-----BEGIN CERTIFICATE-----\n" + "MIICUDCCAbmgAwIBAgIBAzANBgkqhkiG9w0BAQQFADAfMQswCQYDVQQGEwJVUzEQ\n" + "MA4GA1UEChMHRXhhbXBsZTAeFw0wOTA2MjgxMzMyMjRaFw0yOTAzMTUxMzMyMjRa\n" + "MDExCzAJBgNVBAYTAlVTMRAwDgYDVQQKEwdFeGFtcGxlMRAwDgYDVQQLEwdDbGFz\n" + "cy0xMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDPFv24SK78VI0gWlyIrq/X\n" + "srl1431K5hJJxMYZtaQunyPmrYg3oI9KvKFykxnR0N4XDPaIi75p9dXGppVu80BA\n" + "+csvIPBwlBQoNmKDQWTziDOqfK4tE+IMuL/Y7pxnH6CDMY7VGpvatty2zcmH+m/v\n" + "E/n+HPyeELJQT2rT/3T+7wIDAQABo4GJMIGGMB0GA1UdDgQWBBRidC8Dt3dBzYES\n" + "KpR2tR560sZ0+zBHBgNVHSMEQDA+gBSQ52Dpau+gtL+Kc31dusYnKj16ZaEjpCEw\n" + "HzELMAkGA1UEBhMCVVMxEDAOBgNVBAoTB0V4YW1wbGWCAQAwDwYDVR0TAQH/BAUw\n" + "AwEB/zALBgNVHQ8EBAMCAQYwDQYJKoZIhvcNAQEEBQADgYEAMeMKqrMr5d3eTQsv\n" + "MYOD15Dl3THQGLAa4ad5Eyq5/1eUeEOpztzCgDfi0iPD8YCubIEVasBTSqTiGXqb\n" + "RpGuPHOwwfWvHrTeHSludiFBAUiKj7aEV+oQa0FBn4U4TT8HA62HQ93FhzTDI3jP\n" + "iil34GktVl6gfMKGzUEW/Dh8OM4=\n" + "-----END CERTIFICATE-----";

    static String subCrlIssuerCertStr = "-----BEGIN CERTIFICATE-----\n" + "MIICUDCCAbmgAwIBAgIBBDANBgkqhkiG9w0BAQQFADAfMQswCQYDVQQGEwJVUzEQ\n" + "MA4GA1UEChMHRXhhbXBsZTAeFw0wOTA2MjgxMzMyMjdaFw0yOTAzMTUxMzMyMjda\n" + "MDExCzAJBgNVBAYTAlVTMRAwDgYDVQQKEwdFeGFtcGxlMRAwDgYDVQQLEwdDbGFz\n" + "cy0xMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC+8AcLJtGAVUWvv3ifcyQw\n" + "OGqwzcPrBw/XCs6vTMlcdtFzcH1M+Z3/QHN9+5VT1gqeTIZ+b8g9005Og3XKy/HX\n" + "obXZeLv20VZsr+jm52ySghEYOVCTJ9OyFOAp5adp6nf0cA66Feh3LsmVhpTEcDOG\n" + "GnyntQm0DBYxRoOT/GBlvQIDAQABo4GJMIGGMB0GA1UdDgQWBBSRWhMuZLQoHSDN\n" + "xhxr+vdDmfAY8jBHBgNVHSMEQDA+gBSQ52Dpau+gtL+Kc31dusYnKj16ZaEjpCEw\n" + "HzELMAkGA1UEBhMCVVMxEDAOBgNVBAoTB0V4YW1wbGWCAQAwDwYDVR0TAQH/BAUw\n" + "AwEB/zALBgNVHQ8EBAMCAQYwDQYJKoZIhvcNAQEEBQADgYEAMIDZLdOLFiPyS1bh\n" + "Ch4eUYHT+K1WG93skbga3kVYg3GSe+gctwkKwKK13bwfi8zc7wwz6MtmQwEYhppc\n" + "pKKKEwi5QirBCP54rihLCvRQaj6ZqUJ6VP+zPAqHYMDbzlBbHtVF/1lQUP30I6SV\n" + "Fu987DvLmZ2GuQA9FKJsnlD9pbU=\n" + "-----END CERTIFICATE-----";

    static String targetCertStr = "-----BEGIN CERTIFICATE-----\n" + "MIICNzCCAaCgAwIBAgIBAjANBgkqhkiG9w0BAQQFADAxMQswCQYDVQQGEwJVUzEQ\n" + "MA4GA1UEChMHRXhhbXBsZTEQMA4GA1UECxMHQ2xhc3MtMTAeFw0wOTA2MjgxMzMy\n" + "MzBaFw0yOTAzMTUxMzMyMzBaMEExCzAJBgNVBAYTAlVTMRAwDgYDVQQKEwdFeGFt\n" + "cGxlMRAwDgYDVQQLEwdDbGFzcy0xMQ4wDAYDVQQDEwVBbGljZTCBnzANBgkqhkiG\n" + "9w0BAQEFAAOBjQAwgYkCgYEA7wnsvR4XEOfVznf40l8ClLod+7L0y2/+smVV+GM/\n" + "T1/QF/stajAJxXNy08gK00WKZ6ruTHhR9vh/Z6+EQM2RZDCpU0A7LPa3kLE/XTmS\n" + "1MLDu8ntkdlpURpvhdDWem+rl2HU5oZgzV8Jkcov9vXuSjqEDfr45FlPuV40T8+7\n" + "cxsCAwEAAaNPME0wCwYDVR0PBAQDAgPoMB0GA1UdDgQWBBSBwsAhi6Z1kriOs3ty\n" + "uSIujv9a3DAfBgNVHSMEGDAWgBRidC8Dt3dBzYESKpR2tR560sZ0+zANBgkqhkiG\n" + "9w0BAQQFAAOBgQDEiBqd5AMy2SQopFaS3dYkzj8MHlwtbCSoNVYkOfDnewcatrbk\n" + "yFcp6FX++PMdOQFHWvvnDdkCUAzZQp8kCkF9tGLVLBtOK7XxQ1us1LZym7kOPzsd\n" + "G93Dcf0U1JRO77juc61Br5paAy8Bok18Y/MeG7uKgB2MAEJYKhGKbCrfMw==\n" + "-----END CERTIFICATE-----";

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
        System.out.println(new MyJVMTest_8939().match(name, cert));
    }
}
