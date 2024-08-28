public class MyJVMTest_12360 {

    static int ch = 0;

    boolean isDigit(int ch) {
        return ((ch - '0') | ('9' - ch)) >= 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12360().isDigit(ch));
    }
}
