public class MyJVMTest_17465 {

    static int ch = 0;

    boolean isUpper(int ch) {
        return ((ch - 'A') | ('Z' - ch)) >= 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17465().isUpper(ch));
    }
}
