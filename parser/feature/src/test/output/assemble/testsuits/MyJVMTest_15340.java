import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_15340 {

    static String a = "g5:Il;\"916";

    static String alg = "7<UF]Sg7?q";

    static int port = 0;

    boolean test(String a) {
        return !a.toLowerCase().contains(alg.toLowerCase());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15340().test(a));
    }
}
