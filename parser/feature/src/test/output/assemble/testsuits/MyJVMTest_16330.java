public class MyJVMTest_16330 {

    static Process worker = null;

    void run() {
        worker.destroy();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16330().run();
    }
}
