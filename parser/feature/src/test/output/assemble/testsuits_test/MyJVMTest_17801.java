import java.util.*;

public class MyJVMTest_17801 {

    static int addr = 8;

    static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    String toHex(int addr) {
        char[] buf = new char[8];
        int i = 0;
        for (int s = 28; s >= 0; s -= 4) {
            buf[i++] = digits[(addr >> s) & 0xf];
        }
        return "0x" + new String(buf);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17801().toHex(addr));
    }
}
