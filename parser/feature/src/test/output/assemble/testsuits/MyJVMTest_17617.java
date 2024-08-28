public class MyJVMTest_17617 {

    static int i = 2;

    static int index = 0;

    static char[] buf = { Character.MAX_VALUE, Character.MIN_VALUE, '0', Character.MIN_VALUE, '0', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0', 'Y' };

    int m(int i, int index, char[] buf) {
        while (i >= 65536) {
            i = i / 100;
            buf[--index] = 0;
            buf[--index] = 1;
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17617().m(i, index, buf);
    }
}
