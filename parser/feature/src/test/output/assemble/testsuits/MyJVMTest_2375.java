public class MyJVMTest_2375 {

    static long val = -9223372036854775808L;

    static int num = 464199383;

    static long expected = 1206127395130135235L;

    long callback(long val) {
        System.out.println("Debug: result was: " + val);
        if (val != expected) {
            throw new RuntimeException("Expected " + expected + " but got: " + val);
        }
        return val;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2375().callback(val);
    }
}
