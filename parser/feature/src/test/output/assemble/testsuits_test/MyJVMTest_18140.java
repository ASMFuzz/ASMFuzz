import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;

public class MyJVMTest_18140 {

    static char[] passwd = {Character.MIN_VALUE,'O',Character.MIN_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,'Y','0',Character.MIN_VALUE,Character.MAX_VALUE,Character.MAX_VALUE};

    static byte[] salt = {122,35,120,-92,42,-64,94,-1,-44,71};

    static int iCount = 0;

    char[] getPassword() {
        return passwd.clone();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_18140().getPassword()));
    }
}
