import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_2699 {

    static String s = "^V{TX@7S\\H";

    static String alg = " AlKd:cJ:>";

    static byte[] input = {60,87,-29,34,-41,-81,-125,-75,26,-102};

    static byte[] macvalue = {112,125,11,-3,21,-76,-114,76,-39,-75};

    static byte[] key = {95,100,-128,66,-75,54,75,20,-45,-16};

    static byte[] ALONG = {54,26,81,53,-64,-8,-81,-90,-22,49}, BLONG = {49,72,9,-116,125,63,108,66,69,-80}, BKEY = {-59,-112,97,38,45,48,-2,-14,-118,-57};

    static byte[] BKEY_20 = {-119,-127,27,-28,-55,-95,-12,6,-99,117}, DDDATA_50 = {61,65,58,-124,15,-121,-127,-63,-109,-100}, AAKEY_20 = {-102,59,70,9,-12,-13,-2,-39,-16,-89}, CDDATA_50 = {-83,-124,35,108,52,-6,-37,-116,-105,-79}, AAKEY_131 = {13,-3,80,106,5,18,-14,85,47,79};

    byte[] s(String s) {
        try {
            return s.getBytes("UTF8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_2699().s(s)));
    }
}
