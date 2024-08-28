import java.util.*;

public class MyJVMTest_3767 {

    static int val = 8;

    static char[] CHARS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    String langForInt(int val) {
        StringBuilder buf = new StringBuilder(4);
        buf.append(CHARS[(val >> 12) & 0xF]);
        buf.append(CHARS[(val >> 8) & 0xF]);
        buf.append(CHARS[(val >> 4) & 0xF]);
        buf.append(CHARS[(val >> 0) & 0xF]);
        return buf.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3767().langForInt(val));
    }
}
