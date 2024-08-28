import java.util.*;
import java.text.*;

public class MyJVMTest_5651 {

    static char ch = Character.MIN_VALUE;

    static char[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    String toHex(char ch) {
        StringBuffer buff = new StringBuffer();
        buff.append(hex[ch >> 12]);
        buff.append(hex[(ch >> 8) & 0x0F]);
        buff.append(hex[(ch >> 4) & 0x0F]);
        buff.append(hex[ch & 0x0F]);
        return buff.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5651().toHex(ch));
    }
}
