import java.security.*;
import java.security.cert.*;
import java.util.*;
import java.io.*;

public class MyJVMTest_1114 {

    static String alias = "\\VBXi}n~\"P";

    static KeyStore.ProtectionParameter protectionParam = null;

    KeyStore.Entry engineGetEntry(String alias, KeyStore.ProtectionParameter protectionParam) throws UnrecoverableEntryException {
        throw new UnrecoverableEntryException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1114().engineGetEntry(alias, protectionParam));
    }
}
