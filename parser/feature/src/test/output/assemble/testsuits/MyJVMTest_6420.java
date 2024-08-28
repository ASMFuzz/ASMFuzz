public class MyJVMTest_6420 {

    static int ch = 3;

    boolean isLower(int ch) {
        return Character.isLowerCase(ch);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6420().isLower(ch));
    }
}
