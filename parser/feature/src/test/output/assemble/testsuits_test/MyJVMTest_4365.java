import java.util.concurrent.Semaphore;

public class MyJVMTest_4365 {

    static Semaphore startSem = null;

    static Semaphore redefineSem = null;

    String meth3() {
        try {
            startSem.release();
            redefineSem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4365().meth3());
    }
}
