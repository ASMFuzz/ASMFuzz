public class MyJVMTest_2976 {

    static int expected = 8;

    static int max = 3;

    static int i = 0;

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
        new MyJVMTest_2976().doTest1(expected, max, i);
    }
}
