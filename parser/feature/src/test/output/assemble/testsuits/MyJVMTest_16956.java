public class MyJVMTest_16956 {

    static int ch = -115032699;

    boolean isLower(int ch) {
        return ((ch - 'a') | ('z' - ch)) >= 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16956().isLower(ch));
    }
}
