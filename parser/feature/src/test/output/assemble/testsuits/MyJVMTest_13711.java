public class MyJVMTest_13711 {

    static boolean err = true;

    static String s = "9#3EA*YB\\Y";

    static int got = 0;

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
        new MyJVMTest_13711().check(err, s, got, expected);
    }
}
