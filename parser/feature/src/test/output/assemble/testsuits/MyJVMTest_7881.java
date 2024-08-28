public class MyJVMTest_7881 {

    static char c = Character.MIN_VALUE;

    boolean isLetter(char c) {
        return ((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z'));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7881().isLetter(c));
    }
}
