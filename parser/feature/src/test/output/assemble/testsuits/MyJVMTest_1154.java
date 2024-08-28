import java.lang.management.*;

public class MyJVMTest_1154 {

    void doit() {
        double sum = 0;
        for (int i = 0; i < 5000; i++) {
            double r = Math.random();
            double x = Math.pow(3, r);
            sum += x - r;
        }
        System.out.println(Thread.currentThread().getName() + " sum = " + sum);
    }

    static boolean testFailed = false;

    static boolean done = false;

    static Object obj = new Object();

    void run() {
        ThreadCpuTimeArray.doit();
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
        ThreadCpuTimeArray.doit();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1154().run();
    }
}
