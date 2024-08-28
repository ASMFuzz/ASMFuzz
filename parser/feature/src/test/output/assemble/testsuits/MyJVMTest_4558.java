import java.util.concurrent.Semaphore;

public class MyJVMTest_4558 {

    static Semaphore startSem = null;

    static Semaphore redefineSem = null;

    String meth3() {
        try {
            System.out.println("meth3: release startSem");
            startSem.release();
            System.out.println("meth3: acquire redefineSem");
            redefineSem.acquire();
            System.out.println("meth3: acquired redefineSem");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4558().meth3());
    }
}
