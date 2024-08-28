public class MyJVMTest_15160 {

    static int expected = 3;

    static int max = 7;

    static int i = 9;

    int doTest2(int expected, int max, int i) {
        int counted;
        for (counted = 0; (counted < expected) && (counted <= max); counted += 1) {
        }
        if (counted != expected) {
            throw new RuntimeException("Failed test1 iteration=" + i + " max=" + max + " counted=" + counted + " expected=" + expected);
        }
        return counted;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15160().doTest2(expected, max, i);
    }
}
