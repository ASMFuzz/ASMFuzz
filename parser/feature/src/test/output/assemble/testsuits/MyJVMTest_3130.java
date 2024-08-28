public class MyJVMTest_3130 {

    static char c = Character.MIN_VALUE;

    boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    boolean isStartOfNumber(char c) {
        return isDigit(c) || c == '-';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3130().isStartOfNumber(c));
    }
}
