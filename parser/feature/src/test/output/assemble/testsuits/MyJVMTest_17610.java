public class MyJVMTest_17610 {

    void test() {
        Math.abs(1);
        Math.abs(-1);
        Math.abs(1L);
        Math.abs(-1L);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17610().test();
    }
}
