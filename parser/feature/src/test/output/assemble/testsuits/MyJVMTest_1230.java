public class MyJVMTest_1230 {

    static boolean notified = false;

    void sendNotification() {
        notified = true;
        notifyAll();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1230().sendNotification();
    }
}
