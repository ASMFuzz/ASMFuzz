public class MyJVMTest_11638 {

    static long val = -9223372036854775808L;

    static int num = 1;

    static long expected = -9223372036854775808L;

    long callback(long val) {
        System.out.println("Debug: result was: " + val);
        if (val != expected) {
            throw new RuntimeException("Expected " + expected + " but got: " + val);
        }
        return val;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11638().callback(val);
    }
}
