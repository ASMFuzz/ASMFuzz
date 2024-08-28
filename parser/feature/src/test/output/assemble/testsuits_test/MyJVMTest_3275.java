public class MyJVMTest_3275 {

    static int a = 1;

    static int b = 9;

    static short c = 12040;

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
        new MyJVMTest_3275().test();
    }
}
