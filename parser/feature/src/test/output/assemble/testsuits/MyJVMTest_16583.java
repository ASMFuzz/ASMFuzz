import java.io.*;

public class MyJVMTest_16583 {

    static char[] cbuf = { '0', Character.MIN_VALUE, '>', '0', '0', Character.MIN_VALUE, '0', Character.MIN_VALUE, '0', Character.MIN_VALUE };

    static int off = 0;

    static int len = 9;

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
        new MyJVMTest_16583().write(cbuf, off, len);
    }
}
