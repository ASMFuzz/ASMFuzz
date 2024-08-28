public class MyJVMTest_16458 {

    void testInner() {
        assert false;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16458().testInner();
    }
}
