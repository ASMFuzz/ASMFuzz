import java.nio.charset.*;
import java.nio.*;
import java.util.*;

public class MyJVMTest_9184 {

    char[] getUTFChars() {
        char[] cc = new char[0x10000 - 0xe000 + 0xd800 + (0x110000 - 0x10000) * 2];
        int pos = 0;
        int i = 0;
        for (i = 0; i < 0xd800; i++) cc[pos++] = (char) i;
        for (i = 0xe000; i < 0x10000; i++) cc[pos++] = (char) i;
        for (i = 0x10000; i < 0x110000; i++) {
            pos += Character.toChars(i, cc, pos);
        }
        return cc;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_9184().getUTFChars()));
    }
}
