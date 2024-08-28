public class MyJVMTest_7424 {

    static int ch = 3;

    boolean isLower(int ch) {
        return ((ch - 'a') | ('z' - ch)) >= 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7424().isLower(ch));
    }
}
