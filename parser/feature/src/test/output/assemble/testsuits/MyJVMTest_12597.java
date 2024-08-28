public class MyJVMTest_12597 {

    static int a = -2088724965;

    static int b = 5;

    static short c = 0;

    void test() {
        for (int i = 0; i < 10; ++i) {
            a = c;
            if (i > 1) {
                b = 0;
            }
            c = (short) (b - 7);
        }
        a--;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12597().test();
    }
}
