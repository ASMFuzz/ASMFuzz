import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;

public class MyJVMTest_11394 {

    static char[] passwd = {Character.MAX_VALUE,Character.MAX_VALUE,Character.MAX_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,'&','0','0',Character.MIN_VALUE,'0'};

    static byte[] salt = {-89,-6,83,112,21,-50,-88,-71,-69,3};

    static int iCount = 9;

    String getFormat() {
        return "RAW";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11394().getFormat());
    }
}
