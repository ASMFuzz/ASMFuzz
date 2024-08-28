public class MyJVMTest_2052 {

    static char a = 'x';

    static char b = Character.MIN_VALUE;

    char testChar(char a, char b) {
        if (a != Character.reverseBytes(b)) {
            throw new RuntimeException("FAIL: " + (int) a + " != Character.reverseBytes(" + (int) b + ")");
        }
        if (b != Character.reverseBytes(a)) {
            throw new RuntimeException("FAIL: " + (int) b + " != Character.reverseBytes(" + (int) a + ")");
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2052().testChar(a, b);
    }
}
