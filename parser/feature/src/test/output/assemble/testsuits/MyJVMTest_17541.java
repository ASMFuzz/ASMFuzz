public class MyJVMTest_17541 {

    static int ch = 0;

    boolean isAlpha(int ch) {
        return Character.isAlphabetic(ch);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17541().isAlpha(ch));
    }
}
