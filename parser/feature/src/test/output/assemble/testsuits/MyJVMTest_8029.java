public class MyJVMTest_8029 {

    void run() {
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8029().run();
    }
}
