import java.io.*;
import java.net.*;

public class MyJVMTest_17265 {

    static int count = 0;

    PasswordAuthentication getPasswordAuthentication() {
        PasswordAuthentication pw;
        pw = new PasswordAuthentication("user", "pass1".toCharArray());
        count++;
        return pw;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17265().getPasswordAuthentication());
    }
}
