public class MyJVMTest_7312 {

    static int global = 42;

    void test() {
        int a = Integer.MIN_VALUE;
        int b = global;
        char[] buf = { 0 };
        for (int i = 0; i <= b; ++i) {
            a = i - b;
        }
        char c = buf[(a * 11) / 2 - a];
        buf[0] = 0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7312().test();
    }
}
