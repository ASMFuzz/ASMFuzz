import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;

public class MyJVMTest_2144 {

    static char[] passwd = {'0',Character.MAX_VALUE,'0',Character.MIN_VALUE,Character.MAX_VALUE,'0','4',Character.MAX_VALUE,Character.MIN_VALUE,Character.MIN_VALUE};

    static byte[] salt = {12,-79,-48,-26,-121,-31,-111,19,-31,-67};

    static int iCount = 1575976856;

    String getFormat() {
        return "RAW";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2144().getFormat());
    }
}
