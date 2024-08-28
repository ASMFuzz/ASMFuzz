public class MyJVMTest_12446 {

    static char c = 'w';

    boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    boolean isStartOfNumber(char c) {
        return isDigit(c) || c == '-';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12446().isStartOfNumber(c));
    }
}
