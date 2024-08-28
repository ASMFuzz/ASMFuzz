import java.io.*;
import java.util.*;
import java.security.*;
import java.security.KeyStore.*;
import java.security.cert.*;

public class MyJVMTest_10107 {

    static String filename = "h8SkTu23OR";

    static char[] passwd = { Character.MAX_VALUE, '0', '0', Character.MAX_VALUE, 'A', '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE };

    static KeyStoreSpi dstksParam1 = null;

    static String dstksParam2Param1 = "@3'/uo'e{!";

    static double dstksParam2Param2 = 0d;

    static String dstksParam2Param3 = "S+ ^QJ]lp}";

    static Provider dstksParam2 = new AuthProvider(dstksParam2Param1, dstksParam2Param2, dstksParam2Param3);

    static String dstksParam3 = ";rpw\\3uA@D";

    static KeyStore dstks = new KeyStore(dstksParam1, dstksParam2, dstksParam3);

    String importKeyStore(String filename, char[] passwd, KeyStore dstks) throws Exception {
        System.out.println("Importing JKS KeyStore " + filename);
        InputStream in = new FileInputStream(filename);
        KeyStore srcks = KeyStore.getInstance("JKS");
        srcks.load(in, passwd);
        in.close();
        List<String> aliases = Collections.list(srcks.aliases());
        for (String alias : aliases) {
            System.out.println("Alias: " + alias);
            if (srcks.isCertificateEntry(alias)) {
                X509Certificate cert = (X509Certificate) srcks.getCertificate(alias);
                System.out.println("  Certificate: " + cert.getSubjectX500Principal());
                dstks.setCertificateEntry(alias + "-cert", cert);
            } else if (srcks.isKeyEntry(alias)) {
                PrivateKeyEntry entry = (PrivateKeyEntry) srcks.getEntry(alias, new PasswordProtection(passwd));
                System.out.println("  Key: " + entry.getPrivateKey().toString().split("\n")[0]);
                dstks.setEntry(alias, entry, null);
            } else {
                System.out.println("  Unknown entry: " + alias);
            }
        }
        System.out.println();
        return alias;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10107().importKeyStore(filename, passwd, dstks);
    }
}
