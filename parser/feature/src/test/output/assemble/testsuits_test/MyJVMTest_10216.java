public class MyJVMTest_10216 {

    static short a = 0;

    static short b = 0;

    short testShort(short a, short b) {
        if (a != Short.reverseBytes(b)) {
            throw new RuntimeException("FAIL: " + (int) a + " != Short.reverseBytes(" + (int) b + ")");
        }
        if (b != Short.reverseBytes(a)) {
            throw new RuntimeException("FAIL: " + (int) b + " != Short.reverseBytes(" + (int) a + ")");
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10216().testShort(a, b);
    }
}
