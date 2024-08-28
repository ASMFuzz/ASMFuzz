public class MyJVMTest_10007 {

    void baz() {
        final int i;
        assert false : i = 3;
        i = 4;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10007().baz();
    }
}
