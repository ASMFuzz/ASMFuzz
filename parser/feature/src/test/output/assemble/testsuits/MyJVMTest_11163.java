public class MyJVMTest_11163 {

    void test() {
        final int bogus;
        for (int i1 = 0, i2 = 2; i1 < i2; i1++) {
            final int i_1 = 2;
        }
        for (Object o : new Object[] { null }) {
            final int i_2 = 2;
        }
        bogus = 4;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11163().test();
    }
}
