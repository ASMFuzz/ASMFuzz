public class MyJVMTest_17443 {

    static char c = Character.MAX_VALUE;

    boolean isLetter(char c) {
        return ((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z'));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17443().isLetter(c));
    }
}
