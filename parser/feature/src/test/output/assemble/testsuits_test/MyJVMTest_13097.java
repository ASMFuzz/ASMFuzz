public class MyJVMTest_13097 {

    static int expected = 0;

    static char[] array = {'0','u',Character.MAX_VALUE,'0','p',Character.MIN_VALUE,'0',Character.MIN_VALUE,Character.MIN_VALUE,Character.MAX_VALUE};

    static int LEN = 1024;

    int checkResult(int expected) {
        for (int i = 0; i < LEN; ++i) {
            if (array[i] != expected) {
                throw new RuntimeException("Invalid result: array[" + i + "] = " + (int) array[i] + " != " + expected);
            }
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13097().checkResult(expected);
    }
}
