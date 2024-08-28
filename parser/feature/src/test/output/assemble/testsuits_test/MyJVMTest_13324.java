public class MyJVMTest_13324 {

    static char c = Character.MIN_VALUE;

    int testUnsigned(char c) {
        int result = c - (Character.MAX_VALUE - Integer.MIN_VALUE) + 2;
        if (1 < result && result < 100) {
            throw new RuntimeException("Should not reach here!");
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13324().testUnsigned(c);
    }
}
