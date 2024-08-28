public class MyJVMTest_6826 {

    static Process worker = null;

    void run() {
        worker.destroy();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6826().run();
    }
}
