import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_11985 {

    static String s = "If:L}Q5_MQ";

    static String alg = "]g)cm]'4tQ";

    static byte[] input = {65,105,27,36,-85,-35,-84,-18,14,15};

    static byte[] macvalue = {90,49,26,-83,59,-71,113,-109,-71,10};

    static byte[] key = {3,57,-44,34,115,-109,0,100,-45,117};

    static byte[] ALONG = {43,84,-97,87,-56,89,40,-16,-97,-17}, BLONG = {118,27,-93,-122,46,119,57,114,84,-18}, BKEY = {18,-51,55,25,15,91,96,121,-36,-29};

    static byte[] BKEY_20 = {-102,97,-92,-62,86,-104,-18,-89,-8,-20}, DDDATA_50 = {48,-112,-110,122,-100,-70,-113,7,26,-42}, AAKEY_20 = {29,-5,-86,96,60,-47,18,-40,-33,50}, CDDATA_50 = {-90,71,35,14,-26,37,56,60,77,-69}, AAKEY_131 = {-15,63,32,-54,100,-106,51,-46,83,-125};

    byte[] s(String s) {
        try {
            return s.getBytes("UTF8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_11985().s(s)));
    }
}
