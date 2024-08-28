public class MyJVMTest_5870 {

    static TestWriteBarrierClearControl o = null;

    static int f = 1;

    TestWriteBarrierClearControl test1(TestWriteBarrierClearControl o) {
        o.f = 0x42;
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5870().test1(o);
    }
}
