public class MyJVMTest_15317 {

    static TestWriteBarrierClearControl o = null;

    static int f = 1623744737;

    TestWriteBarrierClearControl test1(TestWriteBarrierClearControl o) {
        o.f = 0x42;
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15317().test1(o);
    }
}
