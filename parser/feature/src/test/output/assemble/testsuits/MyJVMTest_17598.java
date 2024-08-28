public class MyJVMTest_17598 {

    void run() {
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17598().run();
    }
}
