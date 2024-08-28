public class MyJVMTest_11281 {

    static char c = Character.MIN_VALUE;

    boolean isAscii(char c) {
        return c < '\u0080';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11281().isAscii(c));
    }
}
