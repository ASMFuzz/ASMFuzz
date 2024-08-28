public class MyJVMTest_5719 {

    static int expected = 4;

    static int max = 6;

    static int i = 7;

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
        new MyJVMTest_5719().doTest2(expected, max, i);
    }
}
