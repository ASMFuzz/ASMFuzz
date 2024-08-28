import java.rmi.MarshalledObject;

public class MyJVMTest_2426 {

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
        new MyJVMTest_2426().unreferenced();
    }
}
