public class MyJVMTest_3688 {

    void test1() {
        A1 bar = new A1() {
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3688().test1();
    }
}
