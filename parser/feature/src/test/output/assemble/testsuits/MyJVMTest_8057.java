public class MyJVMTest_8057 {

    static int expected = 3;

    static int got = 6;

    int assertEqual(int expected, int got) {
        if (got != expected)
            throw new AssertionError("Expected " + expected + " got " + got);
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8057().assertEqual(expected, got);
    }
}
