import java.security.*;
import java.security.spec.*;
import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_5817 {

    void printHeadings() {
        System.out.println("The following tests numbers are generated using");
        System.out.println("our JCA calling through Cipher to a particular provider");
        System.out.println("=========================================================");
        System.out.println("Algorithm                      DataSize Rounds Kbytes/sec");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5817().printHeadings();
    }
}
