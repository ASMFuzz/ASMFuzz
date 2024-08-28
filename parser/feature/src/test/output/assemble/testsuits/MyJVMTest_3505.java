public class MyJVMTest_3505 {

    static int expected = 8;

    static int max = 0;

    static int i = 7;

    int doTest(int expected, int max, int i) {
        int counted;
        for (counted = 0; (counted <= max) && (counted < expected); counted += 1) {
        }
        if (counted != expected) {
            throw new RuntimeException("Failed test iteration=" + i + " max=" + max + " counted=" + counted + " expected=" + expected);
        }
        return counted;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3505().doTest(expected, max, i);
    }
}
