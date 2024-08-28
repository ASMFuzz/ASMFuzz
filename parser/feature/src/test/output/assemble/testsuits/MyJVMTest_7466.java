import java.lang.management.*;
import java.io.*;

public class MyJVMTest_7466 {

    static char[] rParam1 = { '0', '0', Character.MIN_VALUE, '$', '0', '0', 'a', Character.MIN_VALUE, '0', Character.MAX_VALUE };

    static Reader r = new CharArrayReader(rParam1);

    String commandOutput(Reader r) throws Exception {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = r.read()) > 0) {
            if (c != '\r') {
                sb.append((char) c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7466().commandOutput(r));
    }
}
