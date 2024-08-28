import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_12005 {

    static String rParam1 = "3~9%hLr3-D";

    static StringReader r = new StringReader(rParam1);

    static String alg = ")OSq.gD,A5";

    static byte[] input = {77,45,-32,3,60,33,-19,17,-72,-10};

    static byte[] macvalue = {-23,-9,-109,71,110,-7,-54,-87,-117,-4};

    static byte[] key = {-71,-36,59,0,-49,46,11,86,30,19};

    static byte[] ALONG = {19,108,-10,-16,96,-32,47,-54,-46,27}, BLONG = {43,-110,83,107,48,-114,-52,-100,-65,86}, DDDATA_50 = {20,16,1,87,25,-94,-30,80,6,95}, CDDATA_50 = {104,-117,-105,-116,-124,43,-51,-28,107,-128};

    static byte[] STR_HI_THERE = {-26,-91,-39,88,-28,-9,72,103,-59,10}, STR_WHAT_DO_YA_WANT = {104,91,-36,-65,-40,-24,-45,-88,34,-69};

    static byte[] STR_TEST_USING1 = {-108,-69,37,-87,76,70,-96,104,120,65}, STR_TEST_USING2 = {55,120,-61,-21,-30,-4,62,33,-46,-123};

    static byte[] STR_NIST1 = {102,-15,-31,16,-1,72,-68,-122,8,117}, STR_NIST2 = {23,-117,-100,24,-43,-96,-76,64,16,37}, STR_NIST3 = {109,75,-73,-43,-76,86,-55,-32,17,119};

    static byte[] BKEY = {-65,55,24,-122,119,-74,-88,98,-55,-108}, BKEY_20 = {36,-94,15,-3,-98,-117,80,51,86,-57}, CKEY_20 = {-83,9,116,-79,-43,28,-66,2,42,20};

    static byte[] AAKEY_20 = {-2,-26,-21,98,45,81,13,-78,-63,99}, AAKEY_131 = {-44,-94,26,-123,71,1,-47,-16,92,76}, AAKEY_147 = {23,-67,-49,-11,38,-60,37,-122,66,58}, INCKEY_25 = {61,-75,-93,-71,-81,-21,-29,-73,-47,-54};

    int nextNibble(StringReader r) throws IOException {
        while (true) {
            int ch = r.read();
            if (ch == -1) {
                return -1;
            } else if ((ch >= '0') && (ch <= '9')) {
                return ch - '0';
            } else if ((ch >= 'a') && (ch <= 'f')) {
                return ch - 'a' + 10;
            } else if ((ch >= 'A') && (ch <= 'F')) {
                return ch - 'A' + 10;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12005().nextNibble(r));
    }
}
