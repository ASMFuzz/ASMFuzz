import java.util.*;
import java.nio.*;
import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_10758 {

    void runTest2() throws Exception {
        System.out.println("Testing against Security.getAlgorithms()");
        Set<String> algorithms = Security.getAlgorithms("Cipher");
        for (String algorithm : algorithms) {
            int keylength = -1;
            keylength = Cipher.getMaxAllowedKeyLength(algorithm);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10758().runTest2();
    }
}
