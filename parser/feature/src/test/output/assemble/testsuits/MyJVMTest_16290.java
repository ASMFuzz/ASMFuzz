import java.security.*;
import java.security.cert.*;
import java.util.*;
import java.io.*;

public class MyJVMTest_16290 {

    static FileInputStream pre15fis = null;

    static KeyStore.ProtectionParameter protection = null;

    KeyStore getJKS() {
        try {
            return (KeyStore) KeyStore.getInstance("JKS");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16290().getJKS());
    }
}
