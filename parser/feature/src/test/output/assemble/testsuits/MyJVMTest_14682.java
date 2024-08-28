public class MyJVMTest_14682 {

    void test() throws Exception {
        Object obj = new Object();
        synchronized (obj) {
            throw new Exception();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14682().test();
    }
}
