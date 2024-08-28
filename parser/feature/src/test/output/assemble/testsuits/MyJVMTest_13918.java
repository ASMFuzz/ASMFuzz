import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_13918 {

    static String s = "i]pHH`cd?@";

    static String alg = "CuU8{|+~Yj";

    static byte[] input = {-86,-30,122,-33,-22,86,112,103,-30,-26};

    static byte[] macvalue = {55,-126,55,68,10,112,-24,-37,119,122};

    static byte[] key = {86,91,6,52,-78,108,-87,88,-79,120};

    static byte[] ALONG = {113,98,-37,53,47,-108,-29,59,34,-90}, BLONG = {55,-48,52,6,39,44,-119,19,21,-124}, DDDATA_50 = {104,17,-71,105,4,13,-30,72,48,-121}, CDDATA_50 = {72,-8,-112,42,59,-3,-57,-122,-24,-37};

    static byte[] STR_HI_THERE = {121,41,113,92,-55,7,66,89,98,67}, STR_WHAT_DO_YA_WANT = {-89,-78,14,-49,-12,-91,112,-107,99,-96};

    static byte[] STR_TEST_USING1 = {48,72,-32,-118,-16,19,-82,-79,124,-102}, STR_TEST_USING2 = {105,7,3,-106,-74,44,-5,-87,-112,-28};

    static byte[] STR_NIST1 = {-15,88,38,-4,74,70,-30,-45,84,43}, STR_NIST2 = {36,-86,-39,8,-99,-110,124,112,-2,-104}, STR_NIST3 = {-63,-121,42,42,67,-104,-2,-93,92,-8};

    static byte[] BKEY = {85,76,-80,16,-19,-100,44,-46,25,90}, BKEY_20 = {-64,123,-68,103,22,-96,-2,-11,-118,-22}, CKEY_20 = {10,-61,-117,98,-25,-112,-42,118,-52,-105};

    static byte[] AAKEY_20 = {8,-87,-19,26,26,-54,78,118,-118,91}, AAKEY_131 = {-128,-126,104,-105,-123,115,92,62,95,61}, AAKEY_147 = {14,-36,-92,74,-109,-64,90,59,-97,-20}, INCKEY_25 = {-118,-117,-10,-58,-27,30,-37,11,-86,91};

    byte[] s(String s) {
        try {
            return s.getBytes("UTF8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_13918().s(s)));
    }
}
