import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;

public class MyJVMTest_6037 {

    static char[] passwd = {'R','0',Character.MAX_VALUE,Character.MIN_VALUE,'*',Character.MAX_VALUE,'/','0',Character.MIN_VALUE,Character.MIN_VALUE};

    static byte[] salt = {-21,71,-9,-40,66,-51,-46,-121,77,24};

    static int iCount = 5;

    String getAlgorithm() {
        return "PBE";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6037().getAlgorithm());
    }
}
