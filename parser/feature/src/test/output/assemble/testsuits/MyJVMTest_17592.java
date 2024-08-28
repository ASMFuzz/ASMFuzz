import java.io.*;
import java.security.*;
import java.security.cert.*;
import java.util.*;

public class MyJVMTest_17592 {

    static String keyType = "`Ea#/hxF-A";

    static Principal[] issuers = { null, null, null, null, null, null, null, null, null, null };

    static HashMap keyMap = new HashMap();

    static HashMap certChainMap = new HashMap();

    String[] getClientAliases(String keyType, Principal[] issuers) {
        String[] s = new String[1];
        s[0] = "client";
        return s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_17592().getClientAliases(keyType, issuers)));
    }
}
