import java.io.*;
import java.util.*;
import java.security.*;

public class MyJVMTest_6785 {

    static String rParam1 = "@ ~}sy6^y{";

    static StringReader r = new StringReader(rParam1);

    static String alg = "yz1'n,1(gU";

    static byte[] data = {-25,29,127,90,-55,-88,35,-36,-125,26};

    static byte[] digest = {-89,44,13,64,-7,-45,99,52,43,64};

    static byte[] ALONG = {-21,-24,105,-37,-81,-26,-85,8,101,-100}, BLONG = {-35,108,-58,-42,111,-126,24,-34,112,-26};

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
        System.out.println(new MyJVMTest_6785().nextNibble(r));
    }
}
