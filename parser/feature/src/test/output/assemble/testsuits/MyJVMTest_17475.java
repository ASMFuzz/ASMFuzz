import java.io.*;
import java.security.*;
import java.security.spec.*;
import java.security.interfaces.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.crypto.interfaces.*;

public class MyJVMTest_17475 {

    void usage() {
        System.err.print("DHKeyAgreement usage: ");
        System.err.println("[-gen]");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17475().usage();
    }
}
