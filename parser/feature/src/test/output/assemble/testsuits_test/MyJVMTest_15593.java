import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class MyJVMTest_15593 {

    static String pParam1 = "JkY7S&Y6q6";

    static double pParam2 = 0.9468369420089124;

    static String pParam3 = "}09Ac{L'k<";

    static Provider p = new AuthProvider(pParam1, pParam2, pParam3);

    String toString(byte[] b) {
        if (b == null) {
            return "(null)";
        }
        StringBuffer sb = new StringBuffer(b.length * 3);
        for (int i = 0; i < b.length; i++) {
            int k = b[i] & 0xff;
            if (i != 0) {
                sb.append(':');
            }
            sb.append(hexDigits[k >>> 4]);
            sb.append(hexDigits[k & 0xf]);
        }
        return sb.toString();
    }

    static char[] hexDigits = "0123456789abcdef".toCharArray();

    static String alg = "nh7-9lNg@0";

    static byte[] input = {-108,127,-77,-62,82,-70,-46,66,-52,37};

    static byte[] macvalue = {86,1,-32,-34,91,-108,21,5,90,5};

    static byte[] key = {-8,-56,27,75,-72,-16,14,-31,-16,-51};

    static byte[] ALONG = {-63,15,93,-1,35,62,124,27,113,-87}, BLONG = {103,-125,17,-51,-7,70,-48,36,70,-85}, BKEY = {94,117,26,106,65,43,24,-107,-29,55};

    static byte[] BKEY_20 = {-86,-72,-35,-36,29,-77,-128,-21,-37,10}, DDDATA_50 = {111,2,-12,-110,124,-61,25,-49,110,103}, AAKEY_20 = {-121,110,-118,52,-124,-113,-48,-45,111,0}, CDDATA_50 = {-69,93,-14,-65,-59,-58,-97,26,-1,-119}, AAKEY_131 = {5,39,-79,0,-103,-84,29,-66,-99,-111};

    Mac run(Provider p) throws Exception {
        Mac mac = Mac.getInstance(alg, p);
        SecretKey keySpec = new SecretKeySpec(key, alg);
        mac.init(keySpec);
        mac.update(input);
        byte[] macv = mac.doFinal();
        if (Arrays.equals(macvalue, macv) == false) {
            System.out.println("Mac test for " + alg + " failed:");
            if (input.length < 256) {
                System.out.println("input:       " + toString(input));
            }
            System.out.println("key:        " + toString(key));
            System.out.println("macvalue:   " + toString(macvalue));
            System.out.println("calculated: " + toString(macv));
            throw new Exception("Mac test for " + alg + " failed");
        }
        System.out.println("passed: " + alg);
        return mac;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15593().run(p);
    }
}
