import java.util.concurrent.Semaphore;

public class MyJVMTest_16133 {

    int method1() throws InterruptedException {
        int localInt = 1234;
        int int2 = 0x22222222;
        int int3 = 0x33333333;
        int int4 = 0x44444444;
        int int5 = 0x55555555;
        thrd.release();
        main.acquire();
        return localInt;
    }

    static Semaphore main = new Semaphore(0);

    static Semaphore thrd = new Semaphore(0);

    void run() {
        try {
            method1();
            method1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method1: run done");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16133().run();
    }
}
