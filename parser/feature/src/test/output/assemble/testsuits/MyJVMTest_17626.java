public class MyJVMTest_17626 {

    static int expected = 1179796627;

    static int got = 0;

    int assertEqual(int expected, int got) {
        if (got != expected)
            throw new AssertionError("Expected " + expected + " got " + got);
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17626().assertEqual(expected, got);
    }
}
