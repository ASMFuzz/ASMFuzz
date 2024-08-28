public class MyJVMTest_3781 {

    void run() {
        System.out.println("Worker thread: running...");
        while (!Thread.currentThread().isInterrupted()) {
        }
        System.out.println("Worker thread: bye");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3781().run();
    }
}
