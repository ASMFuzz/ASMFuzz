import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_10383 {

    static String a = "[o^2CY6?#2";

    static String alg = "4U_F+k/nSB";

    boolean test(String a) {
        return !a.toLowerCase().contains(alg.toLowerCase());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10383().test(a));
    }
}
