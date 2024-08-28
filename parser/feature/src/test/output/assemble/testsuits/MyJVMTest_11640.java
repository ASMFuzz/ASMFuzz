public class MyJVMTest_11640 {

    static int ch = 0;

    boolean isUpper(int ch) {
        return Character.isUpperCase(ch);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11640().isUpper(ch));
    }
}
