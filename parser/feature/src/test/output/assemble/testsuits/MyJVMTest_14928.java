import com.sun.net.httpserver.*;
import java.util.*;
import java.util.concurrent.*;
import java.io.*;
import java.net.*;

public class MyJVMTest_14928 {

    static String user = "p u~}R|G'K";

    static String pass = ":N\")b$(9>h";

    boolean checkCredentials(String user, String pass) {
        return user.equals("fred") && pass.equals("fredpassword");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14928().checkCredentials(user, pass));
    }
}
