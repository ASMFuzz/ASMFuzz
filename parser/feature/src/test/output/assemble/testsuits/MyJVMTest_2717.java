import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_2717 {

    static String rParam1 = "M3z-YU[W\"g";

    static StringReader r = new StringReader(rParam1);

    static String alg = "@>gV'Y\"{||";

    static byte[] input = {-106,-102,96,37,-1,94,99,-110,99,26};

    static byte[] macvalue = {67,-92,110,32,-86,-79,-34,-50,-35,109};

    static byte[] key = {48,-5,48,-117,-45,-16,-113,32,-84,-112};

    static byte[] ALONG = {84,114,-43,-44,-67,98,43,6,21,-1}, BLONG = {10,-73,-85,10,-13,-37,-12,27,-61,26}, DDDATA_50 = {98,-20,87,92,-34,71,-115,121,-87,46}, CDDATA_50 = {-51,8,-125,-25,-60,-113,-101,-42,-94,72};

    static byte[] STR_HI_THERE = {-35,-26,3,12,90,38,-60,-34,-3,-100}, STR_WHAT_DO_YA_WANT = {-93,-105,-33,-5,-108,22,-52,114,0,-74};

    static byte[] STR_TEST_USING1 = {-12,83,-68,125,19,53,-94,-3,-104,48}, STR_TEST_USING2 = {-33,24,107,13,6,-73,-34,-59,-122,3};

    static byte[] STR_NIST1 = {66,97,119,1,-36,73,-31,120,84,-47}, STR_NIST2 = {19,-103,98,-73,122,-103,-48,118,124,106}, STR_NIST3 = {-124,56,24,-116,7,-69,105,-8,-109,-81};

    static byte[] BKEY = {38,96,-108,84,-7,31,115,-9,-60,106}, BKEY_20 = {107,114,91,-15,-98,-117,-99,-13,-87,-111}, CKEY_20 = {106,5,-74,-88,118,-57,25,-35,86,-74};

    static byte[] AAKEY_20 = {-46,-74,11,-85,-21,15,-112,111,22,-120}, AAKEY_131 = {-55,19,79,-11,110,115,-65,-127,-97,90}, AAKEY_147 = {-41,115,-25,102,42,-87,5,-98,78,33}, INCKEY_25 = {121,-29,-91,-36,30,1,-50,4,112,15};

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
        System.out.println(new MyJVMTest_2717().nextNibble(r));
    }
}
