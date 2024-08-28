public class MyJVMTest_3758 {

    static int expected = 577357842;

    static char[] array = {'"',Character.MIN_VALUE,'0',Character.MIN_VALUE,Character.MAX_VALUE,'5','0',Character.MIN_VALUE,'/','j'};

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
        new MyJVMTest_3758().checkResult(expected);
    }
}
