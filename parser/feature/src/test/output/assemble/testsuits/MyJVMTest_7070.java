import java.security.*;
import java.security.cert.*;
import java.util.*;
import java.io.*;

public class MyJVMTest_7070 {

    static String alias = "c5cR\"SDGGS";

    static Class<? extends KeyStore.Entry> entryClass = null;

    boolean engineEntryInstanceOf(String alias, Class<? extends KeyStore.Entry> entryClass) {
        if (!alias.equals("foo") || entryClass != KeyStore.PrivateKeyEntry.class) {
            throw new SecurityException("Post15 engineEntryInstanceOf(String, Class) " + "expected [foo] alias " + "and [KeyStore.PrivateKeyEntry] class");
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7070().engineEntryInstanceOf(alias, entryClass));
    }
}
