public class MyJVMTest_12022 {

    void invertPriority() {
        System.out.println("Waiting ..., priority " + Thread.currentThread().getPriority());
        synchronized (this) {
        }
        System.out.println("Released Lock");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12022().invertPriority();
    }
}
