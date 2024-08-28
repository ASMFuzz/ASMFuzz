import java.security.*;
import java.security.cert.*;
import java.util.*;
import java.io.*;

public class MyJVMTest_10309 {

    static String alias = ";b725Z'L5e";

    static KeyStore.ProtectionParameter protectionParam = null;

    KeyStore.Entry engineGetEntry(String alias, KeyStore.ProtectionParameter protectionParam) throws UnrecoverableEntryException {
        throw new UnrecoverableEntryException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10309().engineGetEntry(alias, protectionParam));
    }
}
