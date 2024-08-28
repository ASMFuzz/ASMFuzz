public class MyJVMTest_12839 {

    static int expected = 542144793;

    static int max = 1641212402;

    static int i = 0;

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
        new MyJVMTest_12839().doTest(expected, max, i);
    }
}
