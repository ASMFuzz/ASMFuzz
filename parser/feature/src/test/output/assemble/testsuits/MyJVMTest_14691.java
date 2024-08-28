import java.io.*;
import java.security.*;
import java.security.cert.*;
import java.util.*;
import javax.net.ssl.X509KeyManager;

public class MyJVMTest_14691 {

    static String alias = "gu#K,eAORL";

    static HashMap keyMap = new HashMap();

    static HashMap certChainMap = new HashMap();

    X509Certificate[] getCertificateChain(String alias) {
        Object chain;
        chain = certChainMap.get(alias);
        if (!(chain instanceof X509Certificate[]))
            return null;
        return (X509Certificate[]) chain;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_14691().getCertificateChain(alias)));
    }
}
