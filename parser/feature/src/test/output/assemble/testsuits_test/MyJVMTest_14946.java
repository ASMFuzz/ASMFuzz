import java.util.*;
import java.security.*;
import java.security.KeyStore.*;
import java.security.cert.*;
import javax.security.auth.callback.*;
import java.io.*;

public class MyJVMTest_14946 {

    static Entry entry = null;

    PrivateKeyEntry showEntry(Entry entry) {
        PrivateKeyEntry pke = (PrivateKeyEntry) entry;
        X509Certificate cert = (X509Certificate) pke.getCertificate();
        System.out.println("subject: " + cert.getSubjectX500Principal());
        return pke;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14946().showEntry(entry);
    }
}
