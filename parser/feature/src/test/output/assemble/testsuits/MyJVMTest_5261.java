public class MyJVMTest_5261 {

    void test() throws Exception {
        Object obj = new Object();
        synchronized (obj) {
            throw new Exception();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5261().test();
    }
}
