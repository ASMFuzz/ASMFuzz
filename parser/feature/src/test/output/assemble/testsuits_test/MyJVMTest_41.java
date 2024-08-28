public class MyJVMTest_41 {

    static int ch = 2;

    boolean isDigit(int ch) {
        return Character.isDigit(ch);
    }

    boolean isAlnum(int ch) {
        return Character.isAlphabetic(ch) || Character.isDigit(ch);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_41().isAlnum(ch));
    }
}
