public class MyJVMTest_1027 {

    static short a = 32767;

    static short b = 1792;

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
        new MyJVMTest_1027().testShort(a, b);
    }
}
