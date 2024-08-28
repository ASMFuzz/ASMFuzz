public class MyJVMTest_12741 {

    static char c = '0';

    boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12741().isDigit(c));
    }
}
