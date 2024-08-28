public class MyJVMTest_828 {

    void baz() {
        final int i;
        assert false : i = 3;
        i = 4;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_828().baz();
    }
}
