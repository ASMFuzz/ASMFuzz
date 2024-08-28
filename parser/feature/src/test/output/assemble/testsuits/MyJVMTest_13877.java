import java.security.*;
import java.security.cert.*;
import java.util.*;
import java.io.*;

public class MyJVMTest_13877 {

    static String alias = "_7~j{a8=9h";

    static KeyStore.ProtectionParameter protectionParam = null;

    static FileInputStream pre15fis = null;

    static KeyStore.ProtectionParameter protection = null;

    KeyStore.Entry engineGetEntry(String alias, KeyStore.ProtectionParameter protectionParam) throws UnrecoverableEntryException {
        throw new UnrecoverableEntryException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13877().engineGetEntry(alias, protectionParam));
    }
}
