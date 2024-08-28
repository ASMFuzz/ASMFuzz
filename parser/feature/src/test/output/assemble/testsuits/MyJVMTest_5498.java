import com.sun.net.httpserver.*;
import java.util.*;
import java.util.concurrent.*;
import java.io.*;
import java.net.*;

public class MyJVMTest_5498 {

    static String user = "~+{d+4u\\;&";

    static String pass = "[9&Q#Yk2gR";

    boolean checkCredentials(String user, String pass) {
        return user.equals("fred") && pass.equals("fredpassword");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5498().checkCredentials(user, pass));
    }
}
