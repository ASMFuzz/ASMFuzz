import java.lang.management.*;
import java.io.*;

public class MyJVMTest_17002 {

    static char[] rParam1 = { Character.MIN_VALUE, '0', 'r', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, 'w', Character.MIN_VALUE, Character.MAX_VALUE };

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
        System.out.println(new MyJVMTest_17002().commandOutput(r));
    }
}
