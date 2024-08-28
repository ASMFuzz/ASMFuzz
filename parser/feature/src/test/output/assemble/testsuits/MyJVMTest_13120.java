public class MyJVMTest_13120 {

    void run() {
        System.out.println("Worker thread: running...");
        while (!Thread.currentThread().isInterrupted()) {
        }
        System.out.println("Worker thread: bye");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13120().run();
    }
}
