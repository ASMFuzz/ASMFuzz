import java.util.concurrent.Semaphore;

public class MyJVMTest_16702 {

    static Semaphore main = new Semaphore(0);

    static Semaphore thrd = new Semaphore(0);

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

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16702().method1());
    }
}
