public class MyJVMTest_7903 {

    static int ch = 7;

    boolean isUpper(int ch) {
        return ((ch - 'A') | ('Z' - ch)) >= 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7903().isUpper(ch));
    }
}
