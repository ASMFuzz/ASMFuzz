public class MyJVMTest_15273 {

    static int f = 1;

    static TestWriteBarrierClearControl fo = new TestWriteBarrierClearControl();

    void test2() {
        TestWriteBarrierClearControl o = fo;
        o.f = 0x42;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15273().test2();
    }
}
