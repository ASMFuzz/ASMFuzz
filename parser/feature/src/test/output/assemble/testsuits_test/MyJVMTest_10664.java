public class MyJVMTest_10664 {

    static char[] ch = { 'N', Character.MAX_VALUE, '0', Character.MAX_VALUE, 'V', '*', 'g', 'x', 'Z', Character.MAX_VALUE };

    static int start = 0;

    static int length = -1967035499;

    static StringBuffer currentValue = new StringBuffer();

    int characters(char[] ch, int start, int length) {
        currentValue.append(ch, start, length);
        return length;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10664().characters(ch, start, length);
    }
}
