public class MyJVMTest_2036 {

    static char c = Character.MAX_VALUE;

    boolean isAscii(char c) {
        return c < '\u0080';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2036().isAscii(c));
    }
}
