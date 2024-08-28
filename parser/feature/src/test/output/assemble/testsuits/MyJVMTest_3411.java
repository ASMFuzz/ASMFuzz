public class MyJVMTest_3411 {

    static char c = '(';

    boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3411().isDigit(c));
    }
}
