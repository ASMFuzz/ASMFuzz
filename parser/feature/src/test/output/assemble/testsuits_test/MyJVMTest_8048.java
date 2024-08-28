public class MyJVMTest_8048 {

    static int i = 1;

    static int index = 714041826;

    static char[] buf = { Character.MAX_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE, 'm', '0', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE };

    int m(int i, int index, char[] buf) {
        while (i >= 65536) {
            i = i / 100;
            buf[--index] = 0;
            buf[--index] = 1;
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8048().m(i, index, buf);
    }
}
