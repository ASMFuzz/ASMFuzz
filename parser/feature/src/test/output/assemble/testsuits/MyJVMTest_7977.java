public class MyJVMTest_7977 {

    static int ch = 5;

    boolean isAlpha(int ch) {
        return Character.isAlphabetic(ch);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7977().isAlpha(ch));
    }
}
