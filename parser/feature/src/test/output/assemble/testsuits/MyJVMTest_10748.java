import java.io.*;
import javax.smartcardio.*;

public class MyJVMTest_10748 {

    static String rParam1 = "9'L/Xu cg\"";

    static StringReader r = new StringReader(rParam1);

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
        System.out.println(new MyJVMTest_10748().nextNibble(r));
    }
}
