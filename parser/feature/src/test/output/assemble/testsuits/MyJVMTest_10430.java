public class MyJVMTest_10430 {

    static boolean notified = false;

    void sendNotification() {
        notified = true;
        notifyAll();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10430().sendNotification();
    }
}
