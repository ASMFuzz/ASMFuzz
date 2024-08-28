import java.util.concurrent.Semaphore;

public class MyJVMTest_4589 {

    static Semaphore startSem = null;

    static Semaphore redefineSem = null;

    String meth2() {
        return "after";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4589().meth2());
    }
}
