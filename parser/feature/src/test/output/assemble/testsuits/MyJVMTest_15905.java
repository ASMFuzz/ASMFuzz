public class MyJVMTest_15905 {

    static int ch = 9;

    boolean isLower(int ch) {
        return Character.isLowerCase(ch);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15905().isLower(ch));
    }
}
