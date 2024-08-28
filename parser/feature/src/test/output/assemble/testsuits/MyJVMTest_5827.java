public class MyJVMTest_5827 {

    static int f = 0;

    static TestWriteBarrierClearControl fo = new TestWriteBarrierClearControl();

    void test2() {
        TestWriteBarrierClearControl o = fo;
        o.f = 0x42;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5827().test2();
    }
}
