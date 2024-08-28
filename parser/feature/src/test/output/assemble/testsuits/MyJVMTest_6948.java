public class MyJVMTest_6948 {

    void testInner() {
        assert false;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6948().testInner();
    }
}
