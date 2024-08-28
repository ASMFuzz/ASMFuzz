public class MyJVMTest_4337 {

    static boolean err = false;

    static String s = "yIxr)M;?m%";

    static int got = 3;

    static int expected = 0;

    String toHexString(int c) {
        return "0x" + Integer.toHexString(c);
    }

    int check(boolean err, String s, int got, int expected) {
        if (err) {
            throw new RuntimeException("Error: " + s + " returned an unexpected value. got " + toHexString(got) + ", expected " + toHexString(expected));
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4337().check(err, s, got, expected);
    }
}
