import java.security.*;
import java.security.cert.*;
import java.util.*;
import java.io.*;

public class MyJVMTest_12785 {

    static String alias = "9DWh;(vtPT";

    static Class<? extends KeyStore.Entry> entryClass = null;

    static FileInputStream pre15fis = null;

    static KeyStore.ProtectionParameter protection = null;

    boolean engineEntryInstanceOf(String alias, Class<? extends KeyStore.Entry> entryClass) {
        if (!alias.equals("foo") || entryClass != KeyStore.PrivateKeyEntry.class) {
            throw new SecurityException("Post15 engineEntryInstanceOf(String, Class) " + "expected [foo] alias " + "and [KeyStore.PrivateKeyEntry] class");
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12785().engineEntryInstanceOf(alias, entryClass));
    }
}
