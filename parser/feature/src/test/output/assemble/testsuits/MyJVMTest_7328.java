import java.io.*;
import java.net.*;

public class MyJVMTest_7328 {

    static String s = "<{nLq?OUsw";

    String getHexBytes(String s) throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i);
            int b1 = (a >> 8) & 0xff;
            int b2 = (byte) a;
            int b11 = (b1 >> 4) & 0x0f;
            int b12 = b1 & 0x0f;
            int b21 = (b2 >> 4) & 0x0f;
            int b22 = b2 & 0x0f;
            sb.append(Integer.toHexString(b11));
            sb.append(Integer.toHexString(b12));
            sb.append(Integer.toHexString(b21));
            sb.append(Integer.toHexString(b22));
            sb.append(' ');
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7328().getHexBytes(s));
    }
}
