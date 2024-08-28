import javax.net.*;
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.net.*;
import java.util.*;

public class MyJVMTest_1184 {

    static String a = "L3Rc<c dE-";

    static String alg = "$,e.)t9XQ>";

    boolean test(String a) {
        return !a.toLowerCase().contains(alg.toLowerCase());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1184().test(a));
    }
}
