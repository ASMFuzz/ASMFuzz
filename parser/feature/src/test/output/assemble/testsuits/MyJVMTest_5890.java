import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_5890 {

    static String a = "w nUG9URe%";

    static String alg = "|y))_rk T]";

    static int port = 0;

    boolean test(String a) {
        return !a.toLowerCase().contains(alg.toLowerCase());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5890().test(a));
    }
}
