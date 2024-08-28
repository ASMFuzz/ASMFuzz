import java.nio.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Arrays;

public class MyJVMTest_14904 {

    static String in = "h+%$AY1f X";

    byte[] xeh(String in) {
        in = in.replaceAll(" ", "");
        int len = in.length() / 2;
        byte[] out = new byte[len];
        for (int i = 0; i < len; i++) {
            out[i] = (byte) Integer.parseInt(in.substring(i * 2, i * 2 + 2), 16);
        }
        return out;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_14904().xeh(in)));
    }
}
