import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_4530 {

    static String s = "m{!LQI~8SE";

    static String alg = "t4ln#_vG(\\";

    static byte[] input = {-106,-83,-98,-58,-118,122,85,-15,65,-36};

    static byte[] macvalue = {50,39,-7,66,-125,109,-52,-2,-96,-122};

    static byte[] key = {107,-121,-9,76,-75,45,89,56,27,75};

    static byte[] ALONG = {-27,52,-84,122,-119,-39,-26,-52,55,-127}, BLONG = {1,-7,-40,-22,59,13,62,-48,-120,-95}, DDDATA_50 = {-119,-44,72,27,73,87,-41,-46,21,-9}, CDDATA_50 = {-97,37,13,117,-68,-88,-18,-90,-73,-73};

    static byte[] STR_HI_THERE = {103,89,93,-110,83,-50,120,41,62,-22}, STR_WHAT_DO_YA_WANT = {96,26,21,17,-44,-70,-125,-116,-128,67};

    static byte[] STR_TEST_USING1 = {90,94,89,46,-17,70,76,-26,-9,-44}, STR_TEST_USING2 = {-87,4,97,-97,77,-32,114,92,102,110};

    static byte[] STR_NIST1 = {-52,-75,104,-14,30,42,-91,-18,82,32}, STR_NIST2 = {71,122,-105,120,34,17,-96,-46,123,-22}, STR_NIST3 = {-49,82,33,-37,-114,109,-50,53,68,-106};

    static byte[] BKEY = {-101,-37,94,57,-32,17,29,72,-87,-69}, BKEY_20 = {108,36,-85,114,-117,-79,-6,-105,-52,-112}, CKEY_20 = {74,46,56,-99,105,77,-16,120,51,-53};

    static byte[] AAKEY_20 = {-99,105,-71,47,44,-5,-28,-112,-60,22}, AAKEY_131 = {60,119,60,-116,44,-86,90,15,107,-35}, AAKEY_147 = {-112,27,-62,101,76,27,-26,-26,71,32}, INCKEY_25 = {-10,36,68,-46,69,75,2,-36,-26,-75};

    byte[] s(String s) {
        try {
            return s.getBytes("UTF8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_4530().s(s)));
    }
}
