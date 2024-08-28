import java.io.*;
import java.util.*;
import java.security.*;

public class MyJVMTest_5212 {

    static String s = " 6Q/CZ;R>H";

    static String alg = "Is}}&WM\\~}";

    static byte[] data = {69,-70,-64,98,81,84,-44,4,106,-123};

    static byte[] digest = {-11,63,-38,63,-116,-94,79,68,13,-93};

    static byte[] ALONG = {10,101,-47,45,-25,-75,-118,48,-51,-2}, BLONG = {-115,-110,-49,-120,-3,-51,110,34,-42,41};

    byte[] s(String s) {
        try {
            return s.getBytes("UTF8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_5212().s(s)));
    }
}
