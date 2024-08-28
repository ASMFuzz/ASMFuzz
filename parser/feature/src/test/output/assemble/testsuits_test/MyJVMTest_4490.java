import java.security.*;
import java.security.cert.*;
import java.util.*;
import java.io.*;

public class MyJVMTest_4490 {

    static String alias = "!RbDPlxWhi";

    static KeyStore.ProtectionParameter protectionParam = null;

    static FileInputStream pre15fis = null;

    static KeyStore.ProtectionParameter protection = null;

    KeyStore.Entry engineGetEntry(String alias, KeyStore.ProtectionParameter protectionParam) throws UnrecoverableEntryException {
        throw new UnrecoverableEntryException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4490().engineGetEntry(alias, protectionParam));
    }
}
