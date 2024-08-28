import java.io.*;

public class MyJVMTest_7065 {

    static char[] cbuf = { Character.MIN_VALUE, '*', 'P', Character.MAX_VALUE, Character.MIN_VALUE, 'h', 'k', Character.MAX_VALUE, '0', 'N' };

    static int off = 5;

    static int len = -1273114891;

    static StringBuffer buf = null;

    int write(char[] cbuf, int off, int len) {
        if ((off < 0) || (off > cbuf.length) || (len < 0) || ((off + len) > cbuf.length) || ((off + len) < 0)) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return;
        }
        buf.append(cbuf, off, len);
        return off;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7065().write(cbuf, off, len);
    }
}
