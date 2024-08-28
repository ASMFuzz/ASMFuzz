public class MyJVMTest_5132 {

    void close() {
        return;
    }

    void test1() {
        try (TwrLint r1 = new TwrLint();
            TwrLint r2 = new TwrLint();
            TwrLint r3 = new TwrLint()) {
            r1.close();
            r2.close(42);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5132().test1();
    }
}
