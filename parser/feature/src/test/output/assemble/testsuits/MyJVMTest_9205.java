public class MyJVMTest_9205 {

    static char c = '0';

    boolean isPrintable(char c) {
        return ('\u0020' < c) && (c < '\u007f');
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9205().isPrintable(c));
    }
}
