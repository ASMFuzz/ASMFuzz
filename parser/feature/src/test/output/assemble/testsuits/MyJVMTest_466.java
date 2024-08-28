import java.io.*;
import java.security.*;
import java.security.cert.*;
import java.util.*;

public class MyJVMTest_466 {

    static String alias = "l9=181;+t[";

    static HashMap keyMap = new HashMap();

    static HashMap certChainMap = new HashMap();

    PrivateKey getPrivateKey(String alias) {
        Object key;
        key = keyMap.get(alias);
        if (!(key instanceof PrivateKey))
            return null;
        return (PrivateKey) key;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_466().getPrivateKey(alias));
    }
}
