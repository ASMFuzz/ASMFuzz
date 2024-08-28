import java.rmi.MarshalledObject;

public class MyJVMTest_11693 {

    static Object lock = new Object();

    static boolean unreferencedInvoked = false;

    void unreferenced() {
        System.err.println("unreferenced() method invoked");
        synchronized (lock) {
            unreferencedInvoked = true;
            lock.notify();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11693().unreferenced();
    }
}
