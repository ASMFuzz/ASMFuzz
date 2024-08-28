import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;

public class MyJVMTest_15493 {

    static char[] passwd = {')',Character.MAX_VALUE,'A','w','0',Character.MAX_VALUE,'0','0',Character.MIN_VALUE,Character.MAX_VALUE};

    static byte[] salt = {-110,-15,-106,-13,12,70,-107,-45,82,-27};

    static int iCount = 0;

    String getAlgorithm() {
        return "PBE";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15493().getAlgorithm());
    }
}
