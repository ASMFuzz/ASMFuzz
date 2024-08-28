public class MyJVMTest_10133 {

    static char c = Character.MIN_VALUE;

    char testSigned(char c) {
        int result = c + Integer.MAX_VALUE;
        if (result == Character.MAX_VALUE) {
            throw new RuntimeException("Should not reach here!");
        }
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10133().testSigned(c);
    }
}
