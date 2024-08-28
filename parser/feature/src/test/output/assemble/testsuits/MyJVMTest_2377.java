public class MyJVMTest_2377 {

    static int ch = 2;

    boolean isUpper(int ch) {
        return Character.isUpperCase(ch);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2377().isUpper(ch));
    }
}
