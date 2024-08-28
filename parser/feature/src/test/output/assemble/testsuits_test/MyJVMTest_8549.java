import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;

public class MyJVMTest_8549 {

    static char[] passwd = {'0','0','0','9','0',Character.MIN_VALUE,Character.MAX_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,Character.MIN_VALUE};

    static byte[] salt = {110,-27,84,7,-17,-14,-36,-116,-77,116};

    static int iCount = -349580342;

    char[] getPassword() {
        return passwd.clone();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_8549().getPassword()));
    }
}
