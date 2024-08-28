import java.io.*;
import javax.smartcardio.*;

public class MyJVMTest_1529 {

    static String rParam1 = "~GJ&iZ$E{_";

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
        System.out.println(new MyJVMTest_1529().nextNibble(r));
    }
}
