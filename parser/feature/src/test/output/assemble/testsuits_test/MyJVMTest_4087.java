import java.io.*;
import java.security.*;
import java.security.cert.*;
import java.util.*;

public class MyJVMTest_4087 {

    static String keyType = "\"GpaH5ERKV";

    static Principal[] issuers = { null, null, null, null, null, null, null, null, null, null };

    static HashMap keyMap = new HashMap();

    static HashMap certChainMap = new HashMap();

    String[] getServerAliases(String keyType, Principal[] issuers) {
        String[] s = new String[1];
        s[0] = "server";
        return s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_4087().getServerAliases(keyType, issuers)));
    }
}
