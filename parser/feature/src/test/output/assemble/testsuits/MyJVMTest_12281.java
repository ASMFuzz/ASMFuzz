public class MyJVMTest_12281 {

    static int expected = 0;

    static int max = 9;

    static int i = -1989644619;

    int doTest1(int expected, int max, int i) {
        int counted;
        for (counted = 0; (counted <= max) && (counted < expected); counted += 1) {
        }
        if (counted != expected) {
            throw new RuntimeException("Failed test1 iteration=" + i + " max=" + max + " counted=" + counted + " expected=" + expected);
        }
        return counted;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12281().doTest1(expected, max, i);
    }
}
