import java.lang.management.*;

public class MyJVMTest_12275 {

    void doit() {
        String tmp = "";
        long hashCode = 0;
        for (int counter = 0; counter < 1000; counter++) {
            tmp += counter;
            hashCode = tmp.hashCode();
        }
        System.out.println(Thread.currentThread().getName() + " hashcode: " + hashCode);
    }

    static boolean testFailed = false;

    static boolean done = false;

    static boolean done1 = false;

    static Object obj = new Object();

    void run() {
        ThreadAllocatedMemoryArray.doit();
        synchronized (obj) {
            while (!done) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    System.out.println("Unexpected exception is thrown.");
                    e.printStackTrace(System.out);
                    testFailed = true;
                    break;
                }
            }
        }
        ThreadAllocatedMemoryArray.doit();
        synchronized (obj) {
            while (!done1) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    System.out.println("Unexpected exception is thrown.");
                    e.printStackTrace(System.out);
                    testFailed = true;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12275().run();
    }
}
