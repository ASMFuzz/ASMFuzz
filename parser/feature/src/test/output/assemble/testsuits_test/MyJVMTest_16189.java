import java.security.*;
import java.security.cert.*;
import java.util.*;
import java.io.*;

public class MyJVMTest_16189 {

    KeyStore getJKS() {
        try {
            return (KeyStore) KeyStore.getInstance("JKS");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16189().getJKS());
    }
}
